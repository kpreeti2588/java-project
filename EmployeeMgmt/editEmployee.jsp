<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<%String id=request.getParameter("id"); %>
<h2>Edit Employee</h2><br><br>
<form action="UpdateEmployee" method="post">
EmployeeId:<input type="text" name="id" value=<%=id %>><br>
Phone:<input type="text" name="phone"><br>
Salary:<input type="text" name="salary"><br>
<input type="submit" name="submit" value="save">
</form>
<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>
