package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookingTest {

	static Booking booking;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		booking = new Booking();
	}

	@Test
	public void testGetClientId() {
		long id = 1l;
		booking.setClientId(id);
		assertEquals(Long.valueOf(booking.getClientId()), Long.valueOf(id));
	}
	
	@Test
	public void testGetId() {
		long id = 1l;
		booking.setId(id);
		assertEquals(Long.valueOf(booking.getId()), Long.valueOf(id));
	}

	@Test
	public void testGetVoyageId() {
		long id = 1l;
		booking.setVoyageId(id);
		assertEquals(Long.valueOf(booking.getVoyageId()), Long.valueOf(id));
	}

	@Test
	public void testGetBenefitId() {
		long id = 1l;
		booking.setBenefitId(id);
		assertEquals(Long.valueOf(booking.getBenefitId()), Long.valueOf(id));
	}

	@Test
	public void testGetSeatNumber() {
		int n = 1;
		booking.setSeatNumber(n);
		assertEquals(booking.getSeatNumber(), n);
	}

	@Test
	public void testGetPrice() {
		int p = 1;
		booking.setPrice(p);
		assertEquals(booking.getPrice(), p);
	}

	@Test
	public void testGetDate() {
		Date d = new Date();
		booking.setDate(new Timestamp(d.getTime()));
		assertEquals(booking.getDate(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetTripId() {
		long id = 1l;
		booking.setTripId(id);
		assertEquals(Long.valueOf(booking.getTripId()), Long.valueOf(id));
	}

	@Test
	public void testGetSeatId() {
		long id = 1l;
		booking.setSeatId(id);
		assertEquals(Long.valueOf(booking.getSeatId()), Long.valueOf(id));
	}

	@Test
	public void testGetArrivalTime() {
		Date d = new Date();
		booking.setDepartureTime(new Timestamp(d.getTime()));
		assertEquals(booking.getDepartureTime(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetDepartureTime() {
		Date d = new Date();
		booking.setArrivalTime(new Timestamp(d.getTime()));
		assertEquals(booking.getArrivalTime(), new Timestamp(d.getTime()));
	}

	@Test
	public void testToString() {
		System.out.println(booking);
	}

}
