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
import com.simplilearn.model.Regulation;
import com.simplilearn.service.RegulationDaoService;


/**
 * Servlet implementation class GetDepartment
 */
@WebServlet("/GetRegulation")
public class GetRegulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRegulation() {
        super();
        // TODO Auto-generated constructor updateRegDetailsbyEmpstub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        RegulationDaoService eService= new RegulationDaoService();
        PrintWriter out = response.getWriter();
        
		HttpSession session=request.getSession(false);
		
		RequestDispatcher rd=null;
		try {
			if(session!=null) {
			List<Regulation> list = eService.getRegulationDetails();
			String name=session.getAttribute("user").toString();
			
			request.setAttribute("regulation", list);
		
			if(name.contentEquals("admin")) {
				rd=request.getRequestDispatcher("regulationList.jsp");				
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
