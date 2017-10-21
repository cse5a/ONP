<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link  href="bootstrap\css\bootstrap.css" rel="stylesheet"/>
<script src="bootstrap\js\bootstrap.min.js"></script>
<script src="javascript/angular.min.js"></script>
<script>
	var app=angular.module("myapp",[]);
	app.controller("myctrl",function($scope,$http,$interval){
		$scope.getMessage=function()
		{
			$scope.data="{\"userId\":\""+$scope.userId+"\",\"touserId\":\""+$scope.touserId+"\"}";
			$http.post("MessageGet",$scope.data).then(function(response)
			{
				$scope.mydata=response.data.myrecords;
			},
			function(error)
			{
				
			});
		}
		$interval(function()
		{
			$scope.getMessage();
		},2000);
		$scope.sendMessage=function(id_1,id_2)
		{
			var text=document.getElementById("message").value;
			document.getElementById("message").value=null;
			$scope.data="{\"userId\":\""+id_1+"\",\"touserId\":\""+id_2+"\",\"text\":\""+text+"\"}";
			$http.post("MessageSend",$scope.data).then(function(response)
			{
				
			},
			function(error)
			{
				
			});
		}
	});
</script>
</head>
<body ng-app="myapp" ng-controller="myctrl">
	<div style="height:500px">
	<c:set var="userId" value="${param['Id1']}"/>
	<c:set var="touserId" value="${param['Id2']}"/>
	<c:set var="name" value="${param['name']}"/>
	<table>
	<tr ng-repeat="x in mydata | limitTo: mydata.length-1">
		<td>{{x.text}}</td>
	</tr>
	</table>
	<form ng-init="userId=<c:out value='${userId}'/>;touserId=<c:out value='${touserId}'/>">
		<p>{{userId}}</p>
		<input type="text" id="message" />
		<input type="button" ng-click="sendMessage(<c:out value="${userId}" />,<c:out value="${touserId}" />);" value="send"  />
	</form>
	</div>
</body>
</html>