<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>
<head>
<c:set var="title" value="All Trains" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<br>
	<input type="button"
			onclick="location.href='controller?command=viewAddTrainPage';"
			value="<fmt:message key="edit_train_main_page.button.add_train"/>" />
			<hr/>
	<h2><fmt:message key="edit_train_main_page.form_name"/></h2>
	<br>
	<table id="t01" style="align: center; width: 700px; text-align: center">
		<thead style="background: #227755">
			<tr>
				<th><fmt:message key="edit_train_main_page.name"/></th>
				<th><fmt:message key="edit_train_main_page.coupe_seat"/></th>
				<th><fmt:message key="edit_train_main_page.reserved_seat"/></th>
				<th><fmt:message key="edit_train_main_page.general_seats"/></th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.trains}" var="train">
				<c:url var="editUrl" value="controller?command=editTrainPage&id=${train.id}" />
				<c:url var="removeUrl" value="controller?command=deleteTrainPage&id=${train.id}" />
				<tr>
					<td><c:out value="${train.name}" /></td>
					<td><c:out value="${train.coupeSeat}" /></td>
					<td><c:out value="${train.reservedSeat}" /></td>
					<td><c:out value="${train.generalSeat}" /></td>
					<td><a href="${editUrl}"><fmt:message key="edit_train_main_page.button.edit"/></a></td>
					<td><a href="${removeUrl}"><fmt:message key="edit_train_main_page.button.delete"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty error}">
		<div class="msg">${error}</div>
	</c:if>
</body>
</html>