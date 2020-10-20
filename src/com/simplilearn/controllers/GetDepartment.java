package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.simplilearn.model.DepartmentDetails;
import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.DepartmentDaoService;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class GetDepartment
 */
@WebServlet("/GetDepartment")
public class GetDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        DepartmentDaoService eService= new DepartmentDaoService();
    	PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		
		RequestDispatcher rd=null;
		try {
			if(session!=null) {	
			List<DepartmentDetails> list = eService.getDepartmentDetails();
			
			String name=session.getAttribute("user").toString();
			
			request.setAttribute("department", list);
			if(name.contentEquals("admin")) {
				rd=request.getRequestDispatcher("departmentList.jsp");
			}
			else {
				out.print("You are not authorized to perform this operation!");
				rd=request.getRequestDispatcher("/EmployeeMgmt/index.jsp");
			}			
			rd.forward(request, response);
			
			}else {
				
				response.sendRedirect("/EmployeeMgmt/index.jsp");
			}
				
			
		} catch (EMSException e) {
			// TODO Auto-generated catch block
			rd= request.getRequestDispatcher("errorPage.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}


}
