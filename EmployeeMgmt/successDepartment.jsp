<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
Data is saved successfully. Please save your id for future reference. Here is your id:
<%=request.getAttribute("DepId") %>
<br>
<a href="/EmployeeMgmt/GetDepartment">View All Departments</a>
<br><br><br><jsp:include page="footer.html"></jsp:include>
</body>
</html>