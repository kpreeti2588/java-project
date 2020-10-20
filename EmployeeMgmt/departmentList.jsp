<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page 
buffer="8kb" autoFlush="true" isThreadSafe="true" 
errorPage="errorPage.jsp" 
import="com.simplilearn.model.DepartmentDetails"   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Departments</title>
</head>
<body>
<a href="/EmployeeMgmt/department.jsp">Add a new Department</a><br>
<br>
<h1>Department List</h1>
<table border='1'>
<tr><td>DepId</td><td>DepName</td><td>DepLocation</td></tr>
<c:if test="${not empty requestScope.department }">
<c:out value="Data is available"></c:out>
<c:forEach items="${requestScope.department}" var="dep">
<tr><td>${dep.depid}</td>
<td>${dep.depname}</td>
<td>${dep.deplocation}</td>
<td>
<a href="editdepartment.jsp?id=${dep.depid}">Edit Details</a>
</td>
<td>
<a href="DeleteDepartment?id=${dep.depid}">Delete</a>
</td></tr>
</c:forEach>
</c:if>
</table>

<c:if test="${empty requestScope.department }">
<c:redirect url="errorPage.jsp"></c:redirect>
<c:out value="Data is not available in the database"></c:out>
</c:if>
<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>