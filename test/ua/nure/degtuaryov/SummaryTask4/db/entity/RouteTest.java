package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class RouteTest {

	static Route route;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		route = new Route();
	}

	@Test
	public void testGetName() {
		route.setName("name");
		assertEquals(route.getName(), "name");
	}

	@Test
	public void testToString() {
		System.out.println(route);;
	}

}
