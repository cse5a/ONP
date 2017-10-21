<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="admin.AdminBean" %>
<%@ page import="admin.GetDiscussion" %>
<%@ page import="control.GetCategory" %>
<%@ page import="admin.DiscussionBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	table
	{
		width: 70%;
	}
	table, th, td
	{
		width: 50%;
		border: 1px solid black;
	}
</style>
</head>
<body>
	<center>
	<c:set var="myobject" value="${sessionScope['adminObject']}"></c:set>
	<c:if test="${myobject==null}">
		 <c:redirect url = "adminLogin.jsp"/>
	</c:if>
	<table cellpadding="10">
		<tr>
			<td>
				Topic
			</td>
			<td>
				Description
			</td>
			<td>
				Category
			</td>
			<td>
				Publish
			</td>
			<td>
				Delete
			</td>
			<td>
				Edit
			</td>
		</tr>
	<c:set var="mydataObject" value="${GetDiscussion.getAdminDiscussion(myobject.getId())}" />
	<c:forEach items="${mydataObject}" var="elements">
		<tr>
			<td>
				<small>${elements.getTopic()}</small>
			</td>
			<td>
				<small>${elements.getDescription()}</small>
			</td>
			<td>
				<c:set var="list" value="${GetCategory.category()}"/>  
				<c:forEach items="${list}" var="element">
					<c:if test="${element.getCategoryId()==elements.getCategoryId()}">
						<small>${element.getCategoryName()}</small>
					</c:if>
				</c:forEach>
			</td>
			<td>
				<small>${elements.getDate()}</small>
			</td>
			<td>
				<a href='DeleteDiscussion?id=${elements.getId()}'>Delete</a>
			</td>
			<td>
				<a href='editDiscussion.jsp?id=${elements.getId()}'>Edit</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	</center>
</body>
</html>