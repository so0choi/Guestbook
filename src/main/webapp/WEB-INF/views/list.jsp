<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guestbook</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/list_css.css">
</head>
<body>
	<h1 id="title">Welcome to my Guestbook</h1>
	<hr>
	<div class="outer">
		<h4>Leave me some MESSAGES!</h4>
		<div id="count">#Total number of messages: ${count }</div>
		<br>

		<table>
			<th>No.</th>
			<th>Writer</th>
			<th>Date</th>
			<th>Text</th>
			<%
				int i = 0;
			%>
			<c:forEach items="${list }" var="guestbook">
				<%
					i++;
					String type = "nocolor";
					if (i % 2 == 0)
						type = "colored";
				%>
				<tr class=<%=type%>>
					<td>${guestbook.id }</td>
					<td>${guestbook.name }</td>
					<td>${guestbook.regdate }</td>
					<td class="texts">${guestbook.content }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div id="pages">
		<% int j=0; %>
		<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
			<a href="list?start=${pageIndex}">${status.index +1 }</a>

		</c:forEach>
		</div>
	</div>
	<div class="outer">
		<form method="post" action="write">
			<div id="input_name">
				Name: <input type="text" name="name">
			</div>

			<textarea name="content" cols="60" rows="6"></textarea>
			<br> <input type="submit" value="Submit!" id="btn_submit">
		</form>
	</div>
</body>

</html>