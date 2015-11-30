<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Delete Train" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<form action="controller" method="post">
		<c:set var="train" value="${requestScope.train}"></c:set>
		<input type="hidden" name="command" value="deleteTrain.do" /> <input
			type="hidden" name="id" value="${train.id}" />
		<c:set var="train" value="${train}"></c:set>

		<h1>
			<fmt:message key="delete_train_page.sure_message" />
			= "${train.id}"?
		</h1>
		<h2>
			<fmt:message key="delete_train_page.attantion_message" />
		</h2>
		<table>
			<tr>
				<td><fmt:message key="delete_train_page.train_name" />:</td>
				<td>"${train.name}"</td>
			</tr>
		</table>
		<hr />
		<input type="submit"
			value="<fmt:message key="delete_train_page.button.delete"/>" /> <input
			type="button"
			onclick="location.href='controller?command=viewAllTrains';"
			value="<fmt:message key="delete_train_page.button.back_to_trains"/>" />
		<c:if test="${not empty success}">
			<input type="hidden" name="succsess" value="${success}" />
			<div class="success">${success}</div>
		</c:if>
	</form>

</body>
</html>