package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.exception.EMSException;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post method of login form");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		EmployeeDaoService daoService=new EmployeeDaoService();
		int status;
		try {
			status = daoService.validateUserDetails(name, password);
			if(status==0){
				System.out.println("error");
				request.setAttribute("msg", "Please provide correct username/password");				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
				//error page
			}else{
				
				out.println("Success");
				RequestDispatcher rd= null;
				
	     		HttpSession session=request.getSession();
				session.setAttribute("user", name);
				
				System.out.println("Success");
				if(name.contentEquals("admin")) {
					rd=request.getRequestDispatcher("adminHome.jsp");
				}
				else {
				rd=request.getRequestDispatcher("userhome.jsp");
				}
				rd.forward(request, response);
				//success
			}
			
		
		} catch (EMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		}

	

}
