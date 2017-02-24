<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="CharleyServlet" method="Get">
	<p>State</p><input type="text" name="state">
	<p>City</p><input type="text" name="city">
	<input type="submit" value="Search">
</form>

<div>

<% List<List> results = (List<List>) request.getAttribute("results");
	if (results != null) {
		for (List items: results) {
			for (Object item: items) {
				out.println("<p>" + item + "</p>");
				out.println("<br>");
			}
		}
	}
%>

</div>
</body>
</html>