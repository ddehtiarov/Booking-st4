<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<c:set var="title" value="Add Voyage" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="addVoyage.do" />
		<h2><fmt:message key="add_voyage_page.form_name"/></h2>
		<br>
		<hr />
		<table>
		<tr>
		<td><fmt:message key="add_voyage_page.route"/></td>
		<td><fmt:message key="add_voyage_page.train"/></td>
		<td><fmt:message key="add_voyage_page.date"/>"2000-01-01T00:00"</td>
		</tr>
			<tr>
				<mct:preliminaryInformation/>
				<td><input type="datetime-local" pattern="(\d{4})-(\d{2})-(\d{2})T(\d{2}):(\d{2})" name="date" value="" required/></td>
			</tr>
		</table>
		<hr />
		<input type="submit" value="<fmt:message key="add_voyage_page.button.add"/>" /> <input type="button"
			onclick="location.href='controller?command=viewAllVoyages';"
			value="<fmt:message key="add_voyage_page.button.back_to_voyages"/>" />
	</form>
	<c:if test="${not empty sucess}">
		<input type="hidden" name="sucess" value="${sucess}" />
		<div class="success">${sucess}</div>
	</c:if>
	<c:if test="${not empty wrong}">
		<div class="msg">${wrong}</div>
	</c:if>
</body>
</html>