<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div data-ng-app="myApp" data-ng-controller="myCont">

<form action="CharleyServlet" method="Get">
	<select name="state" data-ng-model="selectedState" data-ng-change="update()">
		<option value="">--Choose State--</option>
		<option data-ng-repeat="(k, v) in states" value="{{ k }}">{{ k }}</option>
	</select>
	<select name="city">
		<option value="">--Choose City--</option>
		<option data-ng-repeat="items in results">{{ items }}</option>
	</select>
	<input type="submit" value="Search">
</form>

<div>

<% List<List> results = (List<List>) request.getAttribute("results");
	if (results != null) {
		for (List items: results) {
			out.println("<div>");
			for (Object item: items) {
				out.println("<p>" + item + "</p>");
			}
			out.println("</div>");
			out.println("<hr/>");
		}
	}
%>

</div>

</div>

<script>

var app = angular.module("myApp", []);
app.controller("myCont", function ($scope) { 
	$scope.states = {"California": ["Sacramento", "Fresno", "Folsom"], "Ohio" : ["Akron", "Cleveland", "Cincinatti"], "Nevada" : ["Reno", "Las Vegas", "Falon"], "Texas" : ["Austin", "Dallas", "Houston"]};
	$scope.selectedState = "";
	$scope.results = $scope.states[$scope.selectedState];
	$scope.update = function () {
		$scope.results = $scope.states[$scope.selectedState];
	}
	});

</script>

</body>
</html>