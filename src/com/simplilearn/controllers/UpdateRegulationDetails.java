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
import com.simplilearn.model.Regulation;
import com.simplilearn.model.RegulationDetails;
import com.simplilearn.service.RegulationDaoService;
import com.simplilearn.service.RegulationDetailsDaoService;

/**
 * Servlet implementation class UpdateRegulationDetails
 */
@WebServlet("/UpdateRegulationDetails")
public class UpdateRegulationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRegulationDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegulationDetailsDaoService eService= new RegulationDetailsDaoService();
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(request.getParameter("submit").equals("save")) {
			String desc= request.getParameter("description");
			
			RegulationDetails details = new RegulationDetails();
			
			details.setId(id);
			details.setDescription(desc);
			
		RequestDispatcher rd=null;
		
		try {
			 if(session!=null) {				 
				 String username=session.getAttribute("user").toString();
					if(username.contentEquals("admin")) {
					int updated= eService.updateRegDetailsbyEmp(details);
					out.println("<!DOCTYPE html>");
	                out.println("<html>");
	                out.println("<body>");
	                out.print("<h5>RegulationDetails Id: "+ id+ " has been updated by Admin Comment"+"</h5><br>");
	                out.print("<br><a href=/EmployeeMgmt/GetRegulationDetails>"+ "View All Regulation Details"+"</a>");
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
