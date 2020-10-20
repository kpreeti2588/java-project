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
import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.EmployeeDaoService;

/**
 * Servlet implementation class AllDetailsServlet
 */
@WebServlet("/AllDetailsServlet")
public class AllDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDaoService eService= new EmployeeDaoService();
		
		HttpSession session=request.getSession(false);
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd=null;
		try {
			if(session!=null) {
			List<EmployeeDetails> details = eService.getEmpDetails();
			out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
			out.print("<table border='1'>");
			out.print("<tr><td>EmpId</td><td>EmpName</td><td>Phone</td><td>Gender</td><td>Salary</td><td>DOB</td><td>Designation</td><td>DepartmentId</td></tr>");
			for (EmployeeDetails employeeDetails : details) {
				out.println("<tr>");
				out.print("<td>"+employeeDetails.getId()+"</td>");
				out.print("<td>"+employeeDetails.getName()+"</td>");
				out.print("<td>"+employeeDetails.getPhone()+"</td>");
				out.print("<td>"+employeeDetails.getGender()+"</td>");
				out.print("<td>"+employeeDetails.getSalary()+"</td>");
				out.print("<td>"+employeeDetails.getDob()+"</td>");
				out.print("<td>"+employeeDetails.getDesignation()+"</td>");		
				out.print("<td>"+employeeDetails.getDep_id()+"</td>");
				out.println("</tr>");
			}
			out.print("</table>");
			
			out.println("<br><br><br><a href=/EmployeeMgmt/LogoutServlet>"+ " Logout"+"</a>");
			out.println("</body>");
            out.println("</html>");	
            
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
