package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.Regulation;
import com.simplilearn.service.DepartmentDaoService;
import com.simplilearn.service.RegulationDaoService;


/**
 * Servlet implementation class RegulationServlet
 */
@WebServlet("/RegulationServlet")
public class RegulationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegulationServlet() {
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
        
        String username=session.getAttribute("user").toString();
        
        RequestDispatcher rd = null;
        String regname = "";
        String dept= "";
        String regDesc = "";
        int dep_id = 0;

        DepartmentDaoService eService= new DepartmentDaoService();
        
		if(request.getParameter("submit").equals("save")) {
		
		dept= request.getParameter("department");
		regname= request.getParameter("name");
		regDesc = request.getParameter("description");
		}
	
		RegulationDaoService daoService =new RegulationDaoService();
		Regulation details = new Regulation();
		try {
			ResultSet rs = eService.getDepartmentDetails1(dept);
			if(rs!=null) {
				while(rs.next()) {
			 dep_id= rs.getInt("id");
				}
			 if(dep_id==0 || regname==null || regDesc==null) {throw new EMSException();}				
			}
			
			details.setRegName(regname);
			details.setRegDescription(regDesc);
			details.setRdep_id(dep_id);
			
		} catch (EMSException  | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("No Department found by this name");
		}	
	//	details.setName(name);
									
		try {
			if(session!=null && username.contentEquals("admin")) {
			int id = daoService.saveRegDetails(details);
			request.setAttribute("RegulationId", id);
			
			if(id!=0) {
				rd = request.getRequestDispatcher("successRegulation.jsp");
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
