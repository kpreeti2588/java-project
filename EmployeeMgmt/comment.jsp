<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Comment</title>
</head>
<body>
<h2>Add Comment</h2><br><br>
<%String name=request.getParameter("name"); %>
<form action="/EmployeeMgmt/SaveRegulationDetails" method="post">
Comment:<input type="text" name="comment"><br>
Employee Name:<input type="text" name="name" value=<%= name%>><br>
Regulation Name:<input type="text" name="regulation"><br>
<input type="submit" name="submit" value="save">
</form>


<br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>