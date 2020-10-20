<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<c:if test="${not empty requestScope.msg }">
<p style="color: red;">
<c:out value="${requestScope.msg } "></c:out>
</p>
</c:if>

<form action="/EmployeeMgmt/LoginServlet" method="post">
Username: <input type="text" name="username"><br>
Password: <input type="password" name="password"><br>
<input type="submit" name="login" value="login"><br>
</form>
	
<a href="/EmployeeMgmt/registration.html">Sign Up</a>
Click here to Register as Employee!
</body>
</html>