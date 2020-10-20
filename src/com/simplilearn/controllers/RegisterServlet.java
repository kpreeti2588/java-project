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

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.DepartmentDaoService;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		DepartmentDaoService dService = new DepartmentDaoService();
		
		int depId = 0;
		
		if(request.getParameter("submit").equals("save")) {
		String name= request.getParameter("name");
		String salary= request.getParameter("salary");
		String phone= request.getParameter("phone");
		String gender= request.getParameter("gender");
		String dob = request.getParameter("dob");
		String designation= request.getParameter("designation");
		String department= request.getParameter("department");
		
		try {
			ResultSet rs= dService.getDepartmentDetails1(department);
			if(rs!=null) {
				while(rs.next()) {
			 depId = rs.getInt("id");
			 System.out.println(depId);
			 if(depId==0) {throw new EMSException();}
				}
			}
		} catch (EMSException | NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Department Id not found");
		}
		EmployeeDaoService daoService =new EmployeeDaoService();
		EmployeeDetails details = new EmployeeDetails();
		
		details.setName(name);
		details.setPhone(phone);
		details.setDesignation(designation);
		float sal = Float.parseFloat(salary);
		char gen = gender.charAt(0);
		details.setGender(gen);
		details.setSalary(sal);
		details.setDob(dob);
		details.setDep_id(depId);
		System.out.println("preeti  "+ details);
		RequestDispatcher rd = null;
		try {
			int id = daoService.saveEmpDetails(details);
			request.setAttribute("EmpId", id);
			if(id!=0) {
				rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else {
				rd = request.getRequestDispatcher("failure.jsp");
				rd.forward(request, response);
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
