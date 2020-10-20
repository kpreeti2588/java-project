package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class GetRegulationDetails
 */
@WebServlet("/GetRegulationDetails")
public class GetRegulationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRegulationDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RegulationDetailsDaoService eService= new RegulationDetailsDaoService();
	        PrintWriter out = response.getWriter();
	        
			HttpSession session=request.getSession(false);
			
			RequestDispatcher rd=null;
			try {
				if(session!=null) {
				List<RegulationDetails> list = eService.getRegulationDetailsbyEmp();
				String name=session.getAttribute("user").toString();
				
				request.setAttribute("regulationdetails", list);
				
				if(name.contentEquals("admin")) {			
					rd=request.getRequestDispatcher("regulationDetailsList.jsp");				
				}
				else {	
					rd=request.getRequestDispatcher("userRegulationDetailsList.jsp");	
				}
				rd.forward(request, response);
				
				}else {
					
					response.sendRedirect("/EmployeeMgmt/index.jsp");
				}
					
				
			} catch (EMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rd= request.getRequestDispatcher("errorPage.jsp");
				rd.forward(request, response);
				
			}
		


	}

}
