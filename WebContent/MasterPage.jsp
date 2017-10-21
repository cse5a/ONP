<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link  rel="stylesheet" href="bootstrap\css\bootstrap.css"/>
 <link rel="stylesheet" href="stylesheet\bootstrap1.min.css">
<script src="bootstrap\js\bootstrap.min.js"></script>
<script src="javascript\jquery-3.2.1.min.js"></script>
<script src="javascript\MasterPageNavigation.js"></script>
<script src="javascript\angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Democratic</title>
<script>
	(function(){
	var app=angular.module("my_post_module",[]);
	app.controller("post_controller",function($http,$scope){
		$scope.getPost=function(id)
		{
			if(id>0)
			{
				$http.post("GetPostController","{\"id\":\""+id+"\"}").then(function(response){
					$scope.adminPost=response.data.adminpostdata;
				},function(error){
					
				});
			}
		}
	});
	})();
</script>
<style>
	body
	{
		padding-top:4%;
		padding-left:10%;
		padding-right:10%;
		background-color:  #f0f3f4;
	}
	div
	{
		background-color: #ffffff;
		padding:3%;
	}
	ul li
	{
		display: inline;
		margin-left: 1%;
		color:#5d6d7e ;
		font-weight: bold;
	}
	ul li:hover
	{
		display: inline;
		color: #dc7633;
		padding: 0px;
	}
	iframe 
	{
		width: 100%;
	}
	.wrapper
	{
		width:100%;
	}
	#sub-menu
	{
		display:none;
	}
	#sub-menu1
	{
		display:none;
	}
	#sub-menu2
	{
		display:none;
	}
	#sub-menu3
	{
		display:none;
	}
	#sub-menu4
	{
		display:none;
	}
	#sub-menu5
	{
		display:none;
	}
	#sub-menu6
	{
		display:none;
	}
	#sub-menu7
	{
		display:none;
	}
	#sub-menu8
	{
		display:none;
	}
</style>
</head>
<body ng-app="my_post_module" ng-controller="post_controller">
	<c:set var="useName" value="${sessionScope.userName}" />
	<p>${userName}</p>
	<a href="UserHome.jsp">Dashboard</a>
	<a href="Discussion.jsp">Discussion</a>
	<div>
	<table class="wrapper">
		<tr>
			<td><h1>Democratic</h1></td>
			<td style="text-align:right"><p>Login</p></td>
		</tr>
	</table>
	<div class="col-sm-12" style="padding:1%">
		<center>
		<ul>
	 		<li><a id="0"  ng-click="getPost(0);">Home</a></li>
      		<li><a id="1"  ng-click="getPost(1);">India</a></li>
      		<li><a id="2"  ng-click="getPost(2);">Politics</a></li>
    		<li><a id="3"  ng-click="getPost(3);">Business</a></li>
      		<li><a id="4"  ng-click="getPost(4);">Sports</a></li>
      		<li><a id="5"  ng-click="getPost(5);">Technology</a></li>
      		<li><a id="6"  ng-click="getPost(6);">App</a></li>
      		<li><a id="7"  ng-click="getPost(7);">Auto</a></li>
      		<li><a id="8"  ng-click="getPost(8);">Food</a></li>
      		<li><a id="9"  ng-click="getPost(9);">Education</a></li>
      		<li><a id="10" ng-click="getPost(10);">Environment</a></li>
      		<li><a id="11" ng-click="getPost(11);">Entertainment</a></li>
      	</ul>
      	</center>
   	</div>
   	<div>
   		<div>
   			<div ng-repeat="items in adminPost" ng-cloak>
   				<div>
   					<h1>{{items.name}}</h1>
   				</div>
   				<div>
   					<p>{{items.body}}</p>
   				</div>
   				<div>
   					<h5>{{items.work}}</h5>
   				</div>
   				<div>
   					<image ng-src="GetPostImage?requestFileIndex=1&requestId={{items.postId}}" style="width:50%;height:30%;"/>
   					<image ng-src="GetPostImage?requestFileIndex=2&requestId={{items.postId}}" style="width:50%;height:30%;"/>
   					 <video width="320" height="240" controls>
						  <source ng-src="GetPostImage?requestFileIndex=3&requestId={{items.postId}}">
					</video> 
   				</div>
   			</div>
   		</div>
   	</div>
   	<div>
	<table>
		<tr>
			<td style="width:75%">
				<div>
					
				</div>
			</td>
		</tr>
		<tr>
			<td>Footer</td>
		</tr>
	</table>
	</div>
	</div>
</body>
</html>