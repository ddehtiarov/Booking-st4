package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TrainTest {
	
	static Train train;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		train = new Train();
	}

	@Test
	public void testGetName() {
		train.setName("name");
		assertEquals(train.getName(), "name");
	}

	@Test
	public void testGetCoupeSeat() {
		train.setCoupeSeat(1);
		assertEquals(train.getCoupeSeat(), 1);
	}

	@Test
	public void testGetReservedSeat() {
		train.setReservedSeat(1);
		assertEquals(train.getReservedSeat(), 1);
	}

	@Test
	public void testGetGeneralSeat() {
		train.setGeneralSeat(1);
		assertEquals(train.getGeneralSeat(), 1);
	}

	@Test
	public void testToString() {
		System.out.println(train);
	}

}
