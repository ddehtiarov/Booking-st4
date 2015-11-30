package ua.nure.degtuaryov.SummaryTask4.db.bean;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.degtuaryov.SummaryTask4.db.Benefit;
import ua.nure.degtuaryov.SummaryTask4.db.Seat;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Client;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Trip;

public class BookingBeanTest {

	static BookingBean bookingBean;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookingBean = new BookingBean();
	}

	@Test
	public void testGetStationBE() {
		Station stationB = new Station();
		stationB.setTitle("stb");
		bookingBean.setStationBE(stationB, stationB);
		assertEquals(bookingBean.getStationBE().getStation1().getTitle(),
				bookingBean.getStationBE().getStation2().getTitle());
	}

	@Test
	public void testGetId() {
		long id = 1l;
		bookingBean.setId(id);
		assertEquals(Long.valueOf(bookingBean.getId()), Long.valueOf(id));
	}

	@Test
	public void testGetDate() {
		Date d = new Date();
		bookingBean.setDate(new Timestamp(d.getTime()));
		assertEquals(bookingBean.getDate(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetClient() {
		long id = 1l;
		Client client = new Client();
		client.setId(id);
		bookingBean.setClient(client);
		assertEquals(Long.valueOf(bookingBean.getClient().getId()), Long.valueOf(id));
	}

	@Test
	public void testGetTrip() {
		long id = 1l;
		Trip trip = new Trip();
		trip.setId(id);
		bookingBean.setTrip(trip);
		assertEquals(Long.valueOf(bookingBean.getTrip().getId()), Long.valueOf(id));
	}

	@Test
	public void testGetVoyageBean() {
		long id = 1l;
		VoyageBean voyageBean = new VoyageBean();
		voyageBean.setId(id);
		bookingBean.setVoyageBean(voyageBean);
		assertEquals(Long.valueOf(bookingBean.getVoyageBean().getId()), Long.valueOf(id));
	}

	@Test
	public void testGetBenefit() {
		bookingBean.setBenefit(Benefit.NONE);
		assertEquals(bookingBean.getBenefit(), Benefit.NONE);
	}

	@Test
	public void testGetSeat() {
		bookingBean.setSeat(Seat.COUPE);
		assertEquals(bookingBean.getSeat(), Seat.COUPE);
	}

	@Test
	public void testGetBooking() {
		long id = 1l;
		Booking booking = new Booking();
		booking.setId(id);
		bookingBean.setBooking(booking);
		assertEquals(Long.valueOf(bookingBean.getBooking().getId()), Long.valueOf(id));
	}

	@Test
	public void testToString() {
		System.out.println(bookingBean);
	}

}
