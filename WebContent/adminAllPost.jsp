<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="control.GetCategory" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="javascript/angular.min.js"></script>
<script src="javascript/jquery-3.2.1.min.js"></script>
<script src="javascript/jquery-ui.js"></script>
<link href="stylesheet/jquery-ui.css" rel="stylesheet" />
<script>
$(function() 
{
    $(".mydate").datepicker({ 
    	dateFormat: 'yy-mm-dd',
        changeYear: true,
        changeMonth: true,
        yearRange: '1945:'+'2020:'
    	}); 
});
	var app=angular.module("myapp",[]);
	app.controller("myctrl",function($scope,$http)
	{
		$scope.getPost_Title=function(title,id)
		{
			var sql="SELECT admin_postId,adminId,admin_postName,admin_postBody,admin_postWork,admin_postPublishDate,admin_postcategoryId FROM adminPost WHERE adminId="+id+" AND admin_postName LIKE '"+title+"%'";
			$http.post("GetPostController",'{"sql":"'+sql+'"}').then(function(response)
			{
				$scope.mydata=response.data.adminpostdata;
			},
			function(error)
			{
				
			});
		}
		$scope.getPost_Category=function(category_Id,id)
		{
			var sql="SELECT admin_postId,adminId,admin_postName,admin_postBody,admin_postWork,admin_postPublishDate,admin_postcategoryId FROM adminPost WHERE adminId="+id+" AND admin_postcategoryId="+category_Id;
			$http.post("GetPostController",'{"sql":"'+sql+'"}').then(function(response)
			{
				$scope.mydata=response.data.adminpostdata;
			},
			function(error)
			{
				
			});
		}
		$scope.getPost_Date=function(id)
		{
			var date=document.getElementById("mydate").value;
			var sql="SELECT admin_postId,adminId,admin_postName,admin_postBody,admin_postWork,admin_postPublishDate,admin_postcategoryId FROM adminPost WHERE adminId="+id+" AND admin_postPublishDate='"+date+"'";
			$http.post("GetPostController",'{"sql":"'+sql+'"}').then(function(response)
			{
				$scope.mydata=response.data.adminpostdata;
			},
			function(error)
			{
				
			});
		}
	});
</script>
<title>Insert title here</title>
</head>
<body ng-app="myapp" ng-controller="myctrl">
	<c:set var="myobject" value="${sessionScope['adminObject']}"></c:set>
	<p>${myobject.getId()}</p>
	<table>
		<tr>
			<td><input type="text" id="title" placeholder="text" ng-change="getPost_Title(title,${myobject.getId()});" ng-model="title"/></td>
			<td>
				<c:set var="list" value="${GetCategory.category()}" />
				<select id="category" ng-change="getPost_Category(mycategory,${myobject.getId()});" ng-model="mycategory">
				<c:forEach items="${list}" var="element">
					<option value="${element.getCategoryId()}">${element.getCategoryName()}</option>
				</c:forEach>
				</select>
			</td>
			<td>
				<input type="date" class="mydate" placeholder="date" id="mydate" ng-click="getPost_Date(${myobject.getId()});"/>
			</td>
		</tr>
	</table>
	<table>
		<tr ng-repeat="x in mydata" >
			<td>{{x.name}}</td>
			<td><a href="editAdminPost.jsp?id={{x.postId}}">Edit</a></td>
			<td><a href="DeletePost?id={{x.postId}}">Delete</a></td>
		</tr>
	</table>
</body>
</html>