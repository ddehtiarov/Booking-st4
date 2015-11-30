<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Edit Train" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<c:set var="train" value="${requestScope.train}"></c:set>
	<h2>
		<fmt:message key="edit_train_page.form_name" />
		= "${train.id}"
	</h2>
	<br>
	<hr />
	<form action="controller" method="post">
		<input type="hidden" name="command" value="editTrain" /> <input
			type="hidden" name="id" value="${train.id}" />
		<table>
			<tr>
				<td><fmt:message key="edit_train_page.name" />:</td>
				<td><input type="text" name="name" value="${train.name}"
					required></td>
			</tr>
			<tr>
				<td><fmt:message key="edit_train_page.coupe_seat" />:</td>
				<td><input type="number" name="coupeSeat"
					value="${train.coupeSeat}" max="1000" min="${train.coupeSeat}" required></td>
			</tr>
			<tr>
				<td><fmt:message key="edit_train_page.reserved_seat" />:</td>
				<td><input type="number" name="reservedSeat"
					value="${train.reservedSeat}" max="1000" min="${train.reservedSeat}" required></td>
			</tr>
			<tr>
				<td><fmt:message key="edit_train_page.general_seats" />:</td>
				<td><input type="number" name="generalSeat"
					value="${train.generalSeat}" max="1000" min="${train.generalSeat}" required></td>
			</tr>
		</table>
		<br>
		<c:if test="${not empty success}">
			<div class="success">${success}</div>
		</c:if>
		<c:if test="${not empty wrong}">
			<div class="msg">${wrong}</div>
		</c:if>
		<hr />
		<input type="submit"
			value="<fmt:message key="edit_train_page.button.edit_train"/>" /> <input
			type="button"
			onclick="location.href='controller?command=viewAllTrains';"
			value="<fmt:message key="edit_train_page.button.back_to_trains"/>" />
	</form>

</body>
</html>