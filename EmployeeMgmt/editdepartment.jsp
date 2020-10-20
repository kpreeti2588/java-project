<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
</head>
<body>
<%String id=request.getParameter("id"); %>
<h2>Edit Department</h2><br><br>
<form action="UpdateDepartment" method="post">
DepartmentId:<input type="text" name="id" value=<%=id %>><br>
Name:<input type="text" name="name"><br>
Location:<input type="text" name="location"><br>
<input type="submit" name="submit" value="save">
</form>
<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>
