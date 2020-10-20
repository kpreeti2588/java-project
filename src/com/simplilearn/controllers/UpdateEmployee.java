package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoService eService= new EmployeeDaoService();
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(request.getParameter("submit").equals("save")) {
			String phone= request.getParameter("phone");
			Float salary= Float.parseFloat(request.getParameter("salary"));
			
			EmployeeDetails details = new EmployeeDetails();
			
			details.setId(id);
			details.setPhone(phone);
			details.setSalary(salary);
			
		RequestDispatcher rd=null;
		
		try {
			 if(session!=null) {				 
				 String username=session.getAttribute("user").toString();
					if(username.contentEquals("admin")) {
					int updated= eService.updateEmpDetails(details);
					out.println("<!DOCTYPE html>");
	                out.println("<html>");
	                out.println("<body>");
	                out.print("<h5>Employee Id: "+ id+ " has been updated"+"</h5><br>");
	                out.print("<br><a href=/EmployeeMgmt/AllDetailsServlet>"+ "View Employee List"+"</a>");
					out.println("<br><br><br><a href=/EmployeeMgmt/LogoutServlet>"+ " Logout"+"</a>");
					out.println("</body>");
	                out.println("</html>");							
					}
					else {
						out.print("You are not authorized to perform this operation!");
						rd=request.getRequestDispatcher("/EmployeeMgmt/index.jsp");
						rd.forward(request, response);
					}
			 }
		} catch (EMSException e) {
			// TODO Auto-generated catch block
			rd= request.getRequestDispatcher("errorPage.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		}
	}
}
