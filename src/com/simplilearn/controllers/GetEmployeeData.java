package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class GetDataContoller
 */
@WebServlet("/GetEmployeeData")
public class GetEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    EmployeeDaoService eService= new EmployeeDaoService();
		
		HttpSession session=request.getSession(false);
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd=null;
		try {
			if(session!=null) {
		//	List<EmployeeDetails> list = eService.getEmpDetails();
			
			String name=session.getAttribute("user").toString();
			
			ResultSet rs = eService.getEmpDetails1(name);		

			if(rs != null){
				while(rs.next()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Employee Detail</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Your Detail</h1>");
                out.print("<br/> EmployeeID: " + rs.getString("id"));
                out.print("<br/> Name: " + name);
                out.print("<br/> Salary: " + rs.getString("salary"));
                out.print("<br/> Phone: " + rs.getString("phone"));
                out.print("<br/> Gender: " + rs.getString("gender").charAt(0));
                out.print("<br/> DOB: " + rs.getString("dob"));
                out.print("<br/> Designation  : " + rs.getString("designation"));
                out.print("<br/> Department  : " + rs.getString("dep_id"));
                out.println("<br><br><br><a href=/EmployeeMgmt/LogoutServlet>"+ " Logout"+"</a>");
                out.println("</body>");
                out.println("</html>");
				}               
            }			
			}else {
				response.sendRedirect("/EmployeeMgmt/index.jsp");
			}
				
			
		} catch (SQLException | EMSException e) {
			// TODO Auto-generated catch block
			rd= request.getRequestDispatcher("errorPage.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		
		}
	}

}
