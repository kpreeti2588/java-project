<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="errorPage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Regulation Details</title>
</head>
<body>
<%String id=request.getParameter("id"); %>
<h2>Edit Regulation Details</h2><br><br>
<form action="UpdateRegulationDetails" method="post">
RegulationId:<input type="text" name="id" value=<%=id %>><br>
RegulationDescription:<input type="text" name="description"><br>
<input type="submit" name="submit" value="save">
</form>
<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>
