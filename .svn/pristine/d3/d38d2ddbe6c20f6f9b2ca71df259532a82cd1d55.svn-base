package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class VoyageTest {

	static Voyage voyage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		voyage = new Voyage();
	}

	@Test
	public void testGetRouteId() {
		voyage.setRouteId(1L);
		assertEquals(Long.valueOf(voyage.getRouteId()), Long.valueOf(1l));
	}

	@Test
	public void testGetTrainId() {
		voyage.setTrainId(1L);
		assertEquals(Long.valueOf(voyage.getTrainId()), Long.valueOf(1l));
	}

	@Test
	public void testGetArrivalTime() {
		Date d = new Date();
		voyage.setArrivalTime(new Timestamp(d.getTime()));
		assertEquals(voyage.getArrivalTime(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetDepartureTime() {
		Date d = new Date();
		voyage.setDepartureTime(new Timestamp(d.getTime()));
		assertEquals(voyage.getDepartureTime(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetCoupe_seat() {
		voyage.setCoupeSeat(1);
		assertEquals(voyage.getCoupeSeat(), 1);
	}

	@Test
	public void testGetReserved_seat() {
		voyage.setReservedSeat(1);
		assertEquals(voyage.getReservedSeat(), 1);
	}

	@Test
	public void testGetGeneral_seat() {
		voyage.setGeneralSeat(1);
		assertEquals(voyage.getGeneralSeat(), 1);
	}

	@Test
	public void testToString() {
		System.out.println(voyage);
	}

}
