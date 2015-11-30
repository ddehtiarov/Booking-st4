<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>
<head>
<c:set var="title" value="Stations in route" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<br>
	<h2>
		<fmt:message key="route_station_main_page.form_name" />
		: "${requestScope.routeStationsBean.route.name}"
	</h2>
	<br>
	<table id="t01"
		style="align: center; width: 1000px; text-align: center"
		cellpadding="10" cellspacing="0">
		<thead style="background: #aaaaff">
			<tr>
				<th><fmt:message key="route_station_main_page.position" /></th>
				<th><fmt:message key="route_station_main_page.station.title" /></th>
				<th><fmt:message key="route_station_main_page.travel_time" /></th>
				<th><fmt:message key="route_station_main_page.stop_time" /></th>
			</tr>
		</thead>
		<c:set var="routeStationsBean"
			value="${requestScope.routeStationsBean}"></c:set>
		<tbody>
			<c:forEach items="${routeStationsBean.stationTimesList}"
				var="stationTime">
				<tr>
					<td><c:out
							value="${routeStationsBean.stationTimesList.indexOf(stationTime) + 1}" /></td>
					<td><c:out value="${stationTime.station.title}" /></td>
					<c:if
						test="${routeStationsBean.stationTimesList.indexOf(stationTime) == routeStationsBean.stationTimesList.size()-1}">
						<td><c:out value="--\\-\\--" /></td>
						<td><c:out value="--\\-\\--" /></td>
					</c:if>
					<c:if
						test="${routeStationsBean.stationTimesList.indexOf(stationTime) != routeStationsBean.stationTimesList.size()-1}">
						<td><c:out value="${stationTime.travelTime}" /></td>
						<td><c:out value="${stationTime.stopTime}" /></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	<input type="button"
		onclick="location.href='javascript:history.back()';"
		value="<fmt:message key="route_station_main_page.back"/>" />
	<c:if test="${not empty error}">
		<div class="msg">${error}</div>
	</c:if>
</body>
</html>