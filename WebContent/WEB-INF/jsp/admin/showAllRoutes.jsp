<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="All Routes" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<br>
	<input type="button"
			onclick="location.href='controller?command=viewAddRoutesPage';"
			value="<fmt:message key="edit_route_main_page.button.add_route"/>" />
			<hr/>
	<h2><fmt:message key="edit_route_main_page.form_name"/></h2>
	<br>
	<table id="t01" style="align: center; width: 700px; text-align: center">
		<thead style="background: #227755">
			<tr>
				<th><fmt:message key="edit_route_main_page.name"/></th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.routes}" var="route">
				<c:url var="infoUrl" value="controller?command=routeInfo&id=${route.id}" />
				<c:url var="removeUrl" value="controller?command=deleteRoutePage&id=${route.id}" />
				<tr>
					<td><c:out value="${route.name}" /></td>
					<td><a href="${infoUrl}"><fmt:message key="edit_route_main_page.button.show_info"/></a></td>
					<td><a href="${removeUrl}"><fmt:message key="edit_route_main_page.button.delete"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty error}">
		<div class="msg">${error}</div>
	</c:if>
</body>
</html>