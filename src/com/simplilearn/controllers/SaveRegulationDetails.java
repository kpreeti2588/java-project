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
import com.simplilearn.model.RegulationDetails;
import com.simplilearn.service.EmployeeDaoService;
import com.simplilearn.service.RegulationDaoService;
import com.simplilearn.service.RegulationDetailsDaoService;

/**
 * Servlet implementation class SaveRegulationDetails
 */
@WebServlet("/SaveRegulationDetails")
public class SaveRegulationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveRegulationDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
        
        String username=session.getAttribute("user").toString();
        
        RequestDispatcher rd = null;
        String name = "";
        String comment = "";
        String regName = "";
        int reg_id = 0;
        int emp_id = 0;
		
        RegulationDaoService rService = new RegulationDaoService();
        EmployeeDaoService eService= new EmployeeDaoService();
        
		if(request.getParameter("submit").equals("save")) {
		
		comment= request.getParameter("comment");
		name= request.getParameter("name");
		regName = request.getParameter("regulation");
		
		}
	
		RegulationDetailsDaoService daoService =new RegulationDetailsDaoService();
		RegulationDetails details = new RegulationDetails();
		try {
			ResultSet rs = eService.getEmpDetails1(name);
			ResultSet rs1 = rService.getRegulationDetails1(regName);
			if(rs!=null) {
				while(rs.next()) {
			 emp_id= Integer.parseInt(rs.getString("id"));
				}
			 if(emp_id==0) {throw new EMSException();}
				
			}
			if(rs1!=null) {
				while(rs1.next()) {
			reg_id= Integer.parseInt(rs1.getString("id"));
				}
			if(reg_id==0) {throw new EMSException();}
				
			}
			
			details.setDescription(comment);
			details.setEmp_id(emp_id);
			details.setReg_id(reg_id);	
			
		} catch (EMSException  | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("No Employee or Regulation found by this name");
		}	
	//	details.setName(name);
									
		try {
			if(session!=null && username!=null) {
			int id = daoService.saveRegDetailsbyEmp(details);
			request.setAttribute("RegulationDetailsId", id);
			
			if(id!=0) {
				rd = request.getRequestDispatcher("successRegulationDetail.jsp");
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
