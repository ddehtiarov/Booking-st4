<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Add Train" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<form action="controller" method="post">
		<c:set var="train" value="${requestScope.train}"></c:set>
		<input type="hidden" name="command" value="addTrain.do" />
		<h2>
			<fmt:message key="add_new_train_page.form_name" />
		</h2>
		<br>
		<hr />
		<table>
			<tr>
				<td><fmt:message key="add_new_train_page.name" />:</td>
				<td><input name="name" value="${train.name}" maxlength="15" /></td>
			</tr>
			<tr>
				<td><fmt:message key="add_new_train_page.coupe_seat" />:</td>
				<td><input type="number" name="coupeSeat"
					value="${train.coupeSeat}" max="1000" min="0" required /></td>
			</tr>
			<tr>
				<td><fmt:message key="add_new_train_page.reserved_seat" />:</td>
				<td><input type="number" name="reservedSeat"
					value="${train.reservedSeat}" max="1000" min="0" required /></td>
			</tr>
			<tr>
				<td><fmt:message key="add_new_train_page.general_seats" />:</td>
				<td><input type="number" name="generalSeat"
					value="${train.generalSeat}" max="1000" min="0" required /></td>
		</table>
		<hr />
		<input type="submit"
			value="<fmt:message key="add_new_train_page.button.add_train"/>" />
		<input type="button"
			onclick="location.href='controller?command=viewAllTrains';"
			value="<fmt:message key="add_new_train_page.button.back_to_trains"/>" />
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