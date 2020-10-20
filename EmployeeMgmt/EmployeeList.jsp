<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page 
buffer="8kb" autoFlush="true" isThreadSafe="true" 
errorPage="errorPage.jsp" 
import="com.simplilearn.model.EmployeeDetails"   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Employees</title>
</head>
<body>


<table border='1'>
<tr><td>EmpId</td><td>EmpName</td><td>Phone</td><td>Gender</td><td>Salary</td><td>DOB</td><td>Designation</td><td>DepartmentId</td></tr>
<c:if test="${not empty requestScope.employees }">
<c:out value="List of Employees"></c:out>
<c:forEach items="${requestScope.employees}" var="emp">
<tr><td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.phone}</td>
<td>${emp.gender}</td>
<td>${emp.salary}</td>
<td>${emp.dob}</td>
<td>${emp.designation}</td>
<td>${emp.dep_id}</td>
</tr>
</c:forEach>
</c:if>
</table>

<c:if test="${empty requestScope.employees }">
<c:redirect url="errorPage.jsp"></c:redirect>
<c:out value="Data is not available in the database"></c:out>
</c:if>

<jsp:include page="footer.html"></jsp:include>
</body>
</html>