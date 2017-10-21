<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link  href="bootstrap\css\bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet" href="stylesheet\bootstrap1.min.css">
<script src="bootstrap\js\bootstrap.min.js"></script>
<script src="javascript\jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Democratic</title>
<script>
	function resizeIframe(obj) 
	{
	    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
	}
	$(document).ready(function(){
		$("#mydiv").hide();
		$("#mynav_elements").click(function(){
			$("#mydiv").fadeIn("slow");
		})
	})
</script>
<style>
	body
	{
		padding-top:4%;
		padding-left:3%;
		padding-right:3%;
		padding-bottom:5%;
		background:radial-gradient(circle,#d0d3d4,#cacfd2, #f4f6f7);
	}
	.header
	{
		background:linear-gradient(#f7f9f9,white);
	}
	.mycontent
	{
		display:block;
		height:600px;
	}
	.mynav li
	{
		display: inline-block;
		margin-left:1%;
	}
	.mynav li a
	{
		text-decoration: none;
		font-weight: bold;
	}
	.mynav li a:hover
	{
		color:#d35400;
	}
	iframe 
	{
		width: 100%;
		border:none;
	}
	.wrapper
	{
		box-shadow: 3px 4px 5px #5f6a6a;
	}
	.tableNavigation
	{
		
	}
	.myheading
	{
		font-weight: bold;
		color: #1f618d;
	}
	.homenav
	{
		text-align: right;
		font-weight: bold;
	}
	.homenav a
	{
		text-decoration: none;
		color: #154360; 
	}
	.homenav a:hover
	{
		text-decoration: none;
		color: #d35400;
	}
</style>
</head>
<body>
	<div class="wrapper container" style="background-color: white;">
	<c:set var="userId" value='${sessionScope.userId}' />
	<c:set var="userName" value='${sessionScope.userName }' />
	<c:set var="userEmail" value='${sessionScope.userEmail}' />
	<c:if test="${userId==null}">
		<c:redirect url="Login.jsp" />
	</c:if>
	<div>
		<div class="col-md-12 header">
			<div class="col-md-8" style="padding:2%">
				<h2 class="myheading">CUTM eHouse</h2>
			</div>
			<div class="col-md-4" style="padding:3%">
				<h4 class="homenav"><a href="MasterPage.jsp">Home</a></h4>
			</div>
		</div>
		<div class="col-md-12">
			<center>
			<ul class="mynav">
				<li><a href="addNews.jsp" target="myframe">Profile</a></li>
				<li><a href="userFriendList.jsp" target="myframe">Friend List</a></li>
				<li><a href="FindFriends.jsp" target="myframe">Find Friends</a></li>
				<li><a href="addNews.jsp" target="myframe">Add News</a></li>
				<li><a href="userAllPost.jsp" target="myframe">Edit News</a></li>
				<li><a href="Logout">Logout</a></li>
			</ul>
			</center>
		</div>
			<div class="mycontent col-md-4">
			 	<h1>My Information</h1>
			 </div>
			 <div class="mycontent col-md-8">
			 	<iframe width="100%" height="100%" src="#" name="myframe"></iframe>
			 </div>
		</div>
	</div>
</body>
</html>