package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class StationTest {
	
	static Station station;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		station = new Station();
	}

	@Test
	public void testGetTitle() {
		station.setTitle("title");
		assertEquals(station.getTitle(), "title");
	}

	@Test
	public void testToString() {
		System.out.println(station);
	}

}
