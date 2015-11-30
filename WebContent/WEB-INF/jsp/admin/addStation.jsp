<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Add Station" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<form action="controller" method="post">
		<c:set var="station" value="${requestScope.station}"></c:set>
		<input type="hidden" name="command" value="addStation.do" />
		<h2>
			<fmt:message key="add_new_station_page.form_name" />
		</h2>
		<br>
		<hr />
		<table>
			<tr>
				<td><fmt:message key="add_new_station_page.station.title" />:</td>
				<td><input name="title" value="${station.title}" maxlength="15"
					required /></td>
			</tr>
		</table>
		<hr />
		<input type="submit"
			value="<fmt:message key="add_new_station_page.title"/>" /> <input
			type="button"
			onclick="location.href='controller?command=viewAllStations';"
			value="<fmt:message key="add_new_station_page.button.back_to_stations"/>" />
	</form>
	<c:if test="${not empty success}">
		<input type="hidden" name="success" value="${success}" />
		<div class="success">${success}</div>
	</c:if>
	<c:if test="${not empty wrong}">
		<div class="msg">${wrong}</div>
	</c:if>
</body>
</html>