package ua.nure.degtuaryov.SummaryTask4.db;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;

/**
 * Enum for benefit entity from db to get benefit type and coefficient
 * 
 * @author Degtuaryow
 *
 */
public enum Benefit {
	NONE(100), STUDENT(54), PENSIONER(66), OTHER(85);

	private int coefficient;

	private Benefit(int constant) {
		this.setCoefficient(constant);
	}

	public static Benefit getBenefit(Booking booking) {
		long benefitId = booking.getBenefitId();
		return Benefit.values()[(int) benefitId];
	}

	public String getReason() {
		return name().toLowerCase();
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
}
