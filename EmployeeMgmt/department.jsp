<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department</title>
</head>
<body>
<h2>Add a New Department</h2><br><br>
<form action="DepartmentServlet" method="post">
Name:<input type="text" name="name"><br>
Location:<input type="text" name="location"><br>
<input type="submit" name="submit" value="save">
</form>
<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>