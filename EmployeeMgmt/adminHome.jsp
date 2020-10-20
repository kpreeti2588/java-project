<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp"
 language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>
<c:if test="${not empty sessionScope.user }">
Welcome,  <c:out value="${sessionScope.user}"></c:out><br>
</c:if>
<br>
<a href="GetDepartment">Department Detail</a><br>
<a href="/EmployeeMgmt/registration.html">Sign Up</a>
Click here to Register an Employee!
<br><a href="GetDataContoller">ListAllEmployees</a><br>
<a href="GetRegulation">Regulation</a><br>
<a href="GetRegulationDetails">RegulationDetails</a><br>
<a href="LogoutServlet">Logout</a>
	
</body>
</html>