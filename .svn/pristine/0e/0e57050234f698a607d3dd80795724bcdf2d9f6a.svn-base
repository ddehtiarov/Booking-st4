<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="All Stations" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<br>
	<input type="button"
		onclick="location.href='controller?command=addStationPage';"
		value="<fmt:message key="edit_station_main_page.button.add_station"/>" />
	<hr />
	<h2>
		<fmt:message key="edit_station_main_page.form_name" />
	</h2>
	<br>
	<table id="t01" style="align: center; width: 700px; text-align: center">
		<thead style="background: #227755">
			<tr>
				<th><fmt:message key="edit_station_main_page.station.title" /></th>
				<th colspan="1"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.stations}" var="station">
				<c:url var="removeUrl"
					value="controller?command=deleteStation.do&id=${station.id}" />
				<tr>
					<td><c:out value="${station.title}" /></td>
					<td><a href="${removeUrl}"><fmt:message
								key="edit_station_main_page.button.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty error}">
		<div class="msg">${error}</div>
	</c:if>
</body>
</html>