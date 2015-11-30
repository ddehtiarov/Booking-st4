package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TripTest {

	static Trip trip;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		trip = new Trip();
	}

	@Test
	public void testGetStationBegin() {
		Station stationB = new Station();
		stationB.setTitle("stb");
		trip.setStationBegin(stationB);
		assertEquals(trip.getStationBegin().getTitle(), "stb");
	}

	@Test
	public void testGetStationEnd() {
		Station stationE = new Station();
		stationE.setTitle("ste");
		trip.setStationEnd(stationE);
		assertEquals(trip.getStationEnd().getTitle(), "ste");
	}

	@Test
	public void testToString() {
		System.out.println(trip);
	}

}
