<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>
<head>
<c:set var="title" value="Ticket info" />

<%@ include file="/WEB-INF/jspf/headContent.jspf"%>
<style type="text/css">
@media print {
	.headerMain {
		display: none;
	}
	.ticketButton {
		display: none;
	}
	* {
		outline: none;
	}
	html, body {
		height: 100%;
	}
	body {
		background: #fff;
		min-width: 1000px;
		margin: 0;
		padding: 0;
		color: #000;
		overflow-y: visible;
	}
	h1, h3, h4, p {
		margin: 0;
		padding: 0;
	}
	img {
		border: none;
	}
	.clear {
		display: block;
		clear: both;
		font-size: 0;
		height: 0;
		margin: 0;
		padding: 0;
		overflow: hidden;
		line-height: 0;
	}
	.center {
		text-align: center;
	}
	.bold {
		font-weight: bold;
	}
	.nowrap {
		white-space: nowrap;
	}
	#middle {
		min-height: 100%;
	}
	#middle>div {
		min-height: 0;
		background: none;
		border: none;
	}
	#middle>div>div, #content {
		margin: 0 auto;
	}
	#middle>div>div {
		width: 1000px;
		margin: 0 auto;
		background: none;
		padding: 0;
	}
	#content {
		background: none;
		width: 998px;
		min-height: 480px;
		padding: 0;
	}
	.arial, .uid {
		font-size: 16px;
	}
	.v-top {
		vertical-align: top;
	}
	.align-right {
		text-align: right;
	}
	.w1 {
		width: 1%;
	}
	.w-right {
		width: 160px;
	}
	.upper {
		text-transform: uppercase;
	}
	.uid {
		font-size: 28px;
		white-space: nowrap;
	}
	.order_num {
		font-size: 21px;
		font-weight: bold;
	}
	.ticket_info {
		font-weight: bold;
		font-size: 17px;
	}
	#content .result h2 {
		font-size: 36px;
		margin: 20px 0;
	}
	#content .better_print {
		font-size: 16px;
		font-weight: bold;
		margin: 20px 0;
		text-align: center;
	}
	#content .controls {
		text-align: center;
	}
	#content .controls button {
		font-size: 22px;
		padding: 5px 20px;
		margin-left: 20px;
	}
	.cheque {
		padding-bottom: 20px;
	}
	.cheque .text h3, .cheque .text p, .cheque-text {
		text-indent: 30px;
		text-align: justify;
	}
	.cheque .text p {
		font-size: 18px;
		margin: 5px 0 10px;
		line-height: 1.5;
	}
	.cheque .text h3, .cheque-text {
		font-size: 28px;
		margin: 20px 0;
	}
	.cheque .text b {
		font-size: 24px;
	}
	.cheque .blank {
		border-top: 1px dashed;
		border-bottom: 1px dashed;
		padding: 10px;
	}
	.cheque .blank .header {
		font-weight: bold;
		font-size: 34px;
	}
	.cheque .blank .orderDate {
		font-size: 14px;
	}
	.cheque .blank .barcode {
		padding-bottom: 5px;
	}
	.cheque .blank table {
		width: 100%;
		background: #000;
		border-collapse: collapse;
	}
	.cheque .blank table tr {
		background: #fff;
	}
	.cheque .blank table td, .cheque .blank table th {
		padding: 2px 5px;
		border: 1px solid;
	}
	.cheque .blank table th {
		text-align: left;
	}
	.cheque .blank table.info th {
		font-weight: normal;
		width: 225px;
	}
	.cheque .blank table.info td, .cheque .blank table.places th {
		font-weight: bold;
		font-size: 15px;
	}
	.cheque .blank .places {
		margin-top: 10px;
	}
	.cheque .blank .places span {
		font-weight: normal;
	}
	.cheque .blank .prices {
		padding: 5px 0 10px;
	}
	.cheque .blank .price_info {
		border: 0;
		border-collapse: collapse;
	}
	.cheque .prices h4 {
		font-size: 14px;
	}
	.cheque .electronic {
		font-family: "Courier New", monospace;
		font-size: 16px;
	}
	.cheque .electronic .info p {
		font-size: 15px;
		font-weight: bold;
		padding-left: 1em;
	}
	.cheque .electronic .part1 tr:first-child {
		height: 42px;
	}
	.cheque .electronic .part2 tr:first-child td {
		border-top: none;
	}
	.cheque .electronic tr:first-child td:first-child {
		width: 5em;
	}
	.cheque .electronic .barcode {
		padding: 5px 0 0;
	}
	.cheque .blank .ch-num-l {
		white-space: nowrap;
		border-right: none;
	}
	.cheque .blank .ch-num {
		white-space: nowrap;
		border-left: none;
	}
	.cheque .blank.electronic .ch-num {
		width: 1px;
		text-align: right;
	}
	#content .return-mrg {
		margin-bottom: 20px;
	}
	.hostName {
		display: none;
	}
	.result_auth {
		
	}
	.result_auth>div {
		margin: 1em;
	}
}
</style>
</head>
<body>


	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	<c:set var="client" value="${sessionScope.client}"></c:set>
	<br>
	<c:if test="${empty wrong}">
		<input type="hidden" name="command" value="buyTicket.do" />
		<div id="hello">
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
											<td>${client.surname} 	${client.firstName} 	${client.secondName}
												</td>
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
											<td class="align-right">${bookingBean.benefit.getReason()}</td>
										</tr>
										<tr>
											<td colspan="2">Departure time:</td>
											<td class="ticket_info" colspan="3">${bookingBean.booking.departureTime}</td>
										</tr>
										<tr>
											<td colspan="5">Total price:
												${bookingBean.booking.price/100} grn</td>
										</tr>
									</table>
									<br> <br> <input type="button" class="ticketButton"
										onclick="location.href='javascript:history.back()';"
										value="Back" /> <br><br><input type="button" class="ticketButton"
										onclick="location.href='javascript:window.print()';"
										value="Print ticket" />
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty wrong}">
		<div class="msg">${wrong}
			<input type="button"
				onclick="location.href='javascript:history.back()';"
				value="<fmt:message key="show_ticket_page.back"/>" />
		</div>
	</c:if>
</body>
</html>

