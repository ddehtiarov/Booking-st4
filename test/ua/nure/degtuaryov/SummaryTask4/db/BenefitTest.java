package ua.nure.degtuaryov.SummaryTask4.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;

public class BenefitTest {
	
	static Benefit benefit;

	@Test
	public void testGetBenefit() {
		Booking booking = new Booking();
		booking.setBenefitId(1);
		assertEquals(Benefit.getBenefit(booking), Benefit.STUDENT);
	}

	@Test
	public void testGetReason() {
		assertEquals(Benefit.valueOf("PENSIONER").getReason(), "pensioner");
	}

	@Test
	public void testGetCoefficient() {
		assertEquals(Benefit.values()[0].getCoefficient(), 100);
	}

}
