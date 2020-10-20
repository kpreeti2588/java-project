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
<title>Add Regulation</title>
</head>
<body>
<h2>Add new Regulation</h2><br><br>
<form action="/EmployeeMgmt/RegulationServlet" method="post">
RegulationName:<input type="text" name="name"><br>
Regulation Description:<input type="text" name="description"><br>
Department:<input type="text" name="department"><br> 
<input type="submit" name="submit" value="save">
</form>

<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>