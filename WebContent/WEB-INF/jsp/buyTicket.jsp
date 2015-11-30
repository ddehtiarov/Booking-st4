<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>

<title>Buy ticket</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="css/header.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/editbox.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/autoComplete.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="css/ticket.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">
	function calculate() {
		var priceElem = ${bookingBean.booking.price};
		var benefitElem = document.getElementById('benefitId');
		var sum = priceElem * benefitElem.value / 100;
		sum = Math.round(sum);
		var bp = document.getElementById('benefitPrice');
		bp.value = sum / 100;
		$('input[name=benefitReason]').val($("#benefitId>option:selected").html());
	}
	calculate();
</script>
</head>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<c:set var="client" value="${sessionScope.client}"></c:set>
	<br>
	<c:if test="${empty wrong}">
		<form action="controller" method="post">
		<input type="hidden" name="command" value="buyTicket.do" />
		<input type="hidden" name="benefitReason" value="none" />
			<div id="middle">
				<div>
					<div>
						<div id="content">
							<div class="cheque">
								<div class="blank electronic" data-doctype="return:travel">
									<table class="part1">
										<tr>
											<td class="nowrap">${bookingBean.voyageBean.routeStationsBean.route.name}</td>
											<td class="bold arial v-top">Ticket</td>
											<td class="bold nowrap">Dima product tm</td>
											<td class="bold arial w-right"></td>
										</tr>

									</table>
									<table class="part2">
										<tr>
											<td colspan="2">Client</td>
											<td>${client.secondName} ${client.firstName} ${client.surname}</td>
											<td>Train</td>
											<td class="align-right ticket_info w-right">${bookingBean.voyageBean.train.name}</td>
										</tr>
										<tr>
											<td class="nowrap w1">From</td>
											<td class="w1">${bookingBean.trip.stationBegin.id}</td>
											<td class="upper ticket_info">${bookingBean.trip.stationBegin.title}</td>
											<td>Train info</td>
											<td class="align-right ticket_info">${bookingBean.seat.getType()}</td>
										</tr>
										<tr>
											<td class="nowrap">To</td>
											<td>${bookingBean.trip.stationEnd.id}</td>
											<td class="upper ticket_info">${bookingBean.trip.stationEnd.title}</td>
											<td>Seat</td>
											<td class="align-right ticket_info">${bookingBean.booking.seatNumber}</td>
										</tr>
										<tr>
											<td colspan="2">Arrival time:</td>
											<td class="ticket_info">${bookingBean.booking.arrivalTime}</td>
											<td>Benefit</td>
											<td class="align-right"><c:set var="benefits"
													value="${requestScope.benefits}" /> <select
												onchange="calculate()" id="benefitId"><option
														disabled>Choose Benefit</option>
													<c:forEach items="${benefits}" var="benefit">
														<option value="${benefit.getCoefficient()}">${benefit.getReason()}</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td colspan="2">Departure time:</td>
											<td class="ticket_info" colspan="3">${bookingBean.booking.departureTime}</td>
										</tr>
										<tr>
											<td colspan="5">Total price:<br /> - price = <b>
													${bookingBean.booking.price/100} grn </b><br /> - with benefit
												= <b> <input id="benefitPrice" type="text"
													value="${bookingBean.booking.price/100}" readonly>grn</b><br />
											</td>

										</tr>
										<tr>
											<td colspan="5" align="center"><br> <input
												type="submit"
												value="<fmt:message key="buy_ticket_page.button.buy_ticket"/>" /><br></td>
										</tr>
									</table>
									<br> <br> <input type="button"
										onclick="location.href='javascript:history.back()';"
										value="<fmt:message key="buy_ticket_page.button.back"/>" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<br />
						</div>
					</div>
				</div>
			</div>
		</form>
	</c:if>
	<c:if test="${not empty wrong}">
		<div class="msg">${wrong}
			<input type="button"
				onclick="location.href='javascript:history.back()';" value="Back" />
		</div>
	</c:if>
</body>
</html>

