package ua.nure.degtuaryov.SummaryTask4.db;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;

public class SeatTest {
	
	Seat seat;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetType() {
		assertEquals(Seat.valueOf("COUPE").getType(), "coupe");
	}

	@Test
	public void testGetCoefficient() {
		assertEquals(Seat.values()[0].getCoefficient(), 1);
	}

	@Test
	public void testGetSeat() {
		Booking booking = new Booking();
		booking.setSeatId(1);
		assertEquals(Seat.getSeat(booking), Seat.RESERVED);
	}

}
