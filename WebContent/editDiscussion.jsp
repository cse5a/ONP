<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="admin.GetDiscussion" %>
<%@ page import="control.GetCategory" %>
<%@ page import="admin.DiscussionBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	table,tr,td
	{
		 border: 2px solid black;
	}
</style>
</head>
<body>
	<center>
	<c:set var="postId" value="${param.id}"></c:set>
	<c:set var="dataObject" value="${GetDiscussion.getDiscussion(postId)}" />
	<form method="POST" action="UpdateDiscussion?id=${postId}">
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
				<td colspan="3">
					Publish
				</td>
				<td>
					Add
				</td>
			</tr>
			<tr>
				<td>
					<textarea required name="topic">${dataObject.getTopic()}</textarea>
				</td>
				<td>
					<textarea required name="description">${dataObject.getDescription()}</textarea>
				</td>
				<td>
					<select name="category" id="category" required>
						<c:set var="list" value="${GetCategory.category()}"/>  
						<c:forEach items="${list}" var="element">
							<c:choose>
								<c:when test="${element.getCategoryId()==dataObject.getCategoryId()}">
									<option value="${element.getCategoryId()}" selected>
									${element.getCategoryName()}
									</option>
								</c:when>
								<c:otherwise>
									<option value="${element.getCategoryId()}">
									${element.getCategoryName()}
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<c:set var="date" value="${fn:split(dataObject.getDate(),'-')}" />
				<td>
					<select name="day" id="day" required>
					<c:forEach var="i" begin="1" end="31">
						<c:choose>
							<c:when test="${i==date[2]}"><option value="${i}" selected>${i}</option></c:when>
							<c:otherwise><option value="${i}">${i}</option></c:otherwise>
						</c:choose>
					</c:forEach>
					</select>
				</td>
				<td>
					<select name="month" id="month" required>
						<c:forEach var="i" begin="1" end="12">
							<c:choose>
								<c:when test="${i==date[1]}"><option value="${i}" selected>${i}</option></c:when>
								<c:otherwise><option value="${i}">${i}</option></c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="year" id="year" required>
						<c:forEach var="i" begin="2017" end="2100">
							<c:choose>
								<c:when test="${i==date[0]}"><option value="${i}" selected>${i}</option></c:when>
								<c:otherwise><option value="${i}">${i}</option></c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="submit" value="Add" onclick="validate();"/>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>