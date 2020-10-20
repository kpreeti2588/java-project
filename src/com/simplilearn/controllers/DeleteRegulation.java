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
import com.simplilearn.service.EmployeeDaoService;
import com.simplilearn.service.RegulationDaoService;

/**
 * Servlet implementation class DeleteRegulation
 */
@WebServlet("/DeleteRegulation")
public class DeleteRegulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegulation() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegulationDaoService eService= new RegulationDaoService();
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		int id = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher rd=null;
		
		 try {
			 if(session!=null) {				 
				 String name=session.getAttribute("user").toString();
					if(name.contentEquals("admin")) {
						int deleted= eService.deleteRegDetails(id);
						out.println("<!DOCTYPE html>");
		                out.println("<html>");
		                out.println("<body>");
		                out.print("<h5>Regulation Id: "+ id+ " has been deleted"+"</h5><br>");
						out.print("<br><a href=/EmployeeMgmt/GetRegulation>"+ "View All Regulations"+"</a>");
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
