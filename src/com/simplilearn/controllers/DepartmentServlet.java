package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession(false);
		RequestDispatcher rd = null;
       
        	
		if(request.getParameter("submit").equals("save")) {
		String name= request.getParameter("name");
		String location= request.getParameter("location");
		
	
		DepartmentDaoService daoService =new DepartmentDaoService();
		DepartmentDetails details = new DepartmentDetails();
		
		details.setDepname(name);
		details.setDeplocation(location);
				
		try {
			if(session.getAttribute("user")==null) {
				throw new EMSException();
			}
			if(session!=null && session.getAttribute("user").toString().contentEquals("admin")) {
			int id = daoService.saveDepDetails(details);
			request.setAttribute("DepId", id);
			if(id!=0) {
				rd = request.getRequestDispatcher("successDepartment.jsp");
				rd.forward(request, response);
			}
			else {
				rd = request.getRequestDispatcher("failure.jsp");
				rd.forward(request, response);
			}
			}
		} catch (EMSException e) {
			// TODO Auto-generated catch block
			rd = request.getRequestDispatcher("errorPage.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
		}
	}

}
