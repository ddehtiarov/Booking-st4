<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="All stations" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

<link rel="stylesheet" type="text/css" media="screen"
	href="css/autoComplete.css">
	
<script type="text/javascript">
	
<%@ include file="../script/add_row_route.js" %>
	
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<form action="controller" method="post">
		<c:set var="stations" value="${requestScope.stations}"></c:set>
		<input type="hidden" name="command" value="addRoute.do" />
		<h2>
			<fmt:message key="add_new_route_page.form_name" />
		</h2>
		<br>

		<table>
			<tr>
				<td><fmt:message key="add_new_route_page.name" />:</td>
				<td><input name="name" maxlength="15" required /></td>
				<td><input class="extrabutton" type="button"
					id="createExtraButton"
					value="+ <fmt:message key="add_new_route_page.button.station"/>">
				<td>
			</tr>

		</table>

		<hr>
		<table id="stations">
			<tr>
				<td><fmt:message key="add_new_route_page.first_station" />:</td>
				<td><input name="station0" class="viewstations" maxlength="15"
					required /></td>
				<td><fmt:message key="add_new_route_page.travel_time" />:</td>
				<td><input name="travelTime0" type="number" max="5000"
					value="10" required min="1"/></td>
				<td><fmt:message key="add_new_route_page.stop_time" />:</td>
				<td><input name="stopTime0" type="number" max="5000" value="2"
					required /></td>
				<td />
			</tr>

		</table>
		<hr />
		<table>
			<tr>
				<td><fmt:message key="add_new_route_page.last_station" />:</td>
				<td><input name="lastStation" class="viewstations"
					maxlength="15" required /></td>
			</tr>
		</table>
		<fmt:message key="add_new_route_page.chechbox.return_route" />
		:<input name="returnRoute" type="checkbox" />
		<hr />
		<input type="submit"
			value="<fmt:message key="add_new_route_page.button.add"/>" /> <input
			type="button"
			onclick="location.href='controller?command=viewAllRoutes';"
			value="<fmt:message key="add_new_route_page.button.back_to_routes"/>" />
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