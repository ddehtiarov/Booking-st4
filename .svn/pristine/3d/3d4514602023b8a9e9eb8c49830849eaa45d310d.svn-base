<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Delete Route" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<form action="controller" method="post">
		<c:set var="route" value="${requestScope.route}"></c:set>
		<input type="hidden" name="command" value="deleteRoute.do" /> <input
			type="hidden" name="id" value="${route.id}" />
		<c:set var="route" value="${route}"></c:set>
		<h1>
			<fmt:message key="delete_route_page.form_name" />
			= "${route.id}"?
		</h1>
		<h2>
			<fmt:message key="delete_route_page.attantion_message" />
		</h2>
		<table>
			<tr>
				<td><fmt:message key="delete_route_page.route_name" />:</td>
				<td>"${route.name}"</td>
			</tr>
		</table>
		<hr />
		<input type="submit"
			value="<fmt:message key="delete_route_page.delete"/>" /> <input
			type="button"
			onclick="location.href='controller?command=viewAllRoutes';"
			value="<fmt:message key="delete_route_page.button.back_to_routes"/>" />
		<c:if test="${not empty success}">
			<input type="hidden" name="succsess" value="${success}" />
			<div class="success">${success}</div>
		</c:if>
	</form>

</body>
</html>