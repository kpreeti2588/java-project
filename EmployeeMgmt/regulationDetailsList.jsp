<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page 
buffer="8kb" autoFlush="true" isThreadSafe="true" 
errorPage="errorPage.jsp" 
import="com.simplilearn.model.RegulationDetails"   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regulation Details </title>
</head>
<body>
<h1>RegulationDetails List</h1>
<table border='1'>
<tr><td>RegId</td><td>EmpId</td><td>RegulationId</td><td>RegDescription</td></tr>
<c:if test="${not empty requestScope.regulationdetails }">
<c:out value="Data is available"></c:out>
<c:forEach items="${requestScope.regulationdetails}" var="regdet">
<tr><td>${regdet.id}</td>
<td>${regdet.emp_id}</td>
<td>${regdet.reg_id}</td>
<td>${regdet.description}</td>
<td>
<a href="editRegulationDetails.jsp?id=${regdet.id}">Comment</a>
<a href="DeleteRegulationDetails?id=${regdet.id}">DeleteComment</a>
</td>
</tr>
</c:forEach>
</c:if>
</table>

<c:if test="${empty requestScope.regulationdetails }">
<c:redirect url="errorPage.jsp"></c:redirect>
<c:out value="Data is not available in the database"></c:out>
</c:if>

<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>