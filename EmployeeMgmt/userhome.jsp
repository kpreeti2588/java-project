<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp"
 language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<%-- <c:if test="${empty session}">
<c:redirect url="index.jsp"></c:redirect>
</c:if> --%>

<c:if test="${not empty sessionScope.user }">
Welcome,  <c:out value="${sessionScope.user}"></c:out><br><br>
</c:if>

<%String name =(String)session.getAttribute("user");%>
<a href="GetEmployeeData">Home</a><br><br>
<a href="/EmployeeMgmt/comment.jsp?name=<%=name%>">Comment</a><br>
<a href="GetDataContoller">EmployeeDetails</a><br>
<a href="LogoutServlet">Logout</a>	
</body>
</html>