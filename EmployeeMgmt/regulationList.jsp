<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page 
buffer="8kb" autoFlush="true" isThreadSafe="true" 
errorPage="errorPage.jsp" 
import="com.simplilearn.model.Regulation"   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Regulation</title>
</head>
<body>
<a href="/EmployeeMgmt/regulation.jsp">Add a new Regulation</a><br>
<br>
<h1>Regulation List</h1>
<table border='1'>
<tr><td>RegId</td><td>RegName</td><td>RegDescription</td><td>DepartmentId</td></tr>
<c:if test="${not empty requestScope.regulation }">
<c:out value="Data is available"></c:out>
<c:forEach items="${requestScope.regulation}" var="reg">
<tr><td>${reg.regId}</td>
<td>${reg.regName}</td>
<td>${reg.regDescription}</td>
<td>${reg.rdep_id}</td>
<td>
<a href="editRegulation.jsp?id=${reg.regId}">Edit Details</a>
</td>
<td>
<a href="DeleteRegulation?id=${reg.regId}">Delete</a>
</td></tr>
</c:forEach>
</c:if>
</table>

<c:if test="${empty requestScope.regulation }">
<c:redirect url="errorPage.jsp"></c:redirect>
<c:out value="Data is not available in the database"></c:out>
</c:if>

<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>