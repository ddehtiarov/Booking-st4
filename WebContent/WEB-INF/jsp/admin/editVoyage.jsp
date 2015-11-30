<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Edit Voyage" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<form action="controller" method="post">
		<c:set var="voyageBean" value="${requestScope.voyageBean}"></c:set>
		<input type="hidden" name="command" value="editVoyage.do" /> <input
			type="hidden" name="id" value="${voyageBean.id}" />
		<h2>
			<fmt:message key="edit_voyage_page.form_name" />
		</h2>
		<fmt:message key="edit_voyage_page.train_name" />
		:"${voyageBean.train.name}" <br>
		<fmt:message key="edit_voyage_page.coupe_seat" />
		"${voyageBean.train.coupeSeat - voyageBean.coupeSeat}";
		<fmt:message key="edit_voyage_page.reserved_seat" />
		:"${voyageBean.train.reservedSeat - voyageBean.reservedSeat}";
		<fmt:message key="edit_voyage_page.general_seats" />
		:"${voyageBean.train.generalSeat - voyageBean.generalSeat}";
		<hr />
		<table>
			<tr>
				<td><fmt:message key="edit_voyage_page.route" />:</td>
				<td><input type="text" readonly
					value="${voyageBean.routeStationsBean.route.name} (${voyageBean.routeStationsBean.stationTimesList.get(0).station.title} - ${voyageBean.routeStationsBean.stationTimesList.get(voyageBean.routeStationsBean.stationTimesList.size() - 1).station.title})" /></td>
			</tr>
			<tr>
				<td><fmt:message key="edit_voyage_page.train" />:</td>
				<td><select name="trainId"><option disabled>Choose
							Train</option>
						<c:forEach items="${requestScope.trains}" var="train">
							<option value="${train.id}"
								<c:if test="${voyageBean.train.id == train.id}">selected=selected</c:if>>
								${train.name}(K -${train.coupeSeat});(P -
								${train.reservedSeat});(G - ${train.generalSeat})</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><fmt:message key="edit_voyage_page.date" />:</td>
				<td><input type="text" readonly
					value="${voyageBean.arrivalTime}"></td>
			</tr>
		</table>
		<hr />
		<input type="submit"
			value="<fmt:message key="edit_voyage_page.button.edit"/>" /> <input
			type="button"
			onclick="location.href='controller?command=viewAllVoyages';"
			value="<fmt:message key="edit_voyage_page.button.back_to_voyages"/>" />
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