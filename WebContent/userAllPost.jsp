<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="control.UserPostGet" %>
 <%@ page import="control.UserPostGetBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
	<c:set var="userId" value="1" />
	<c:set var="list" value="${UserPostGet.getmypost(1)}" />
	<p>Mypage</p>
	<p>${list}</p>
	<c:forEach items="${list}" var="element">
		<p>${element.getPostId()}</p>
		<p>${element.getName()}</p>
		<a href="EditNews.jsp?name=${element.getName()}&body=${element.getBody()}&work=${element.getPostwork()}">Edit</a>
	</c:forEach>
</body>
</html>