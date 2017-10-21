<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="MaterialDesign/material.min.js"></script>
<link href="MaterialDesign/material.indigo-pink.min.css" rel="stylesheet" />
<link href="MaterialDesign/icon.css" rel="stylesheet" />
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.logindiv
{
	margin:5%;
	padding:0.5%;
}
	.mdl-card__title 
{
  color: #fff;
  height: 176px;
  background: url('images/icons/cardWall.jpg') center / cover;
}
</style>
</head>
<body>
	<c:set var="message" value="${requestScope['message']}"></c:set>
	<center>
	<div class="logindiv mdl-card mdl-shadow--2dp">
		<div class="mdl-card__title">
			<h5 class="mdl-card__title-text">Admin Login</h5>
		</div>
		<div class="mdl-card__menu">
			<a href="MasterPage.jsp"><i class="material-icons" style="color:white"></i></a>
		</div>
		<div class="mdl-card__supporting-text" style="text-align:left">
			<form method="POST" action="AdminLogin">
				<div class="mdl-textfield mdl-js-textfield">
					<input type="email" name="email"  class="mdl-textfield__input"/>
					<label class="mdl-textfield__label" for="user">Email</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input type="password" name="password" class="mdl-textfield__input"/>
					<label class="mdl-textfield__label" for="user">Password</label>
				</div>
				<c:if test="${not empty message}">
					<p>${message}</p>
				</c:if>
				<input type="submit" value="Login" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
			</form>
		</div>
		<div class="mdl-card__actions">
			<a href="#" class="mdl-button mdl-button--colored">Forget Password</a>
		</div>
	</div>
	</center>
</body>
</html>