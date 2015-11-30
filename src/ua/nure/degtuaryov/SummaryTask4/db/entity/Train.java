package ua.nure.degtuaryov.SummaryTask4.db.entity;

/**
 * 
 * Train class entity from database, extends Entity
 * 
 * @author Degtuaryow
 *
 */
public class Train extends Entity {

	private static final long serialVersionUID = -6459862327219535077L;
	
	private String name;
	
	private int coupeSeat;
	
	private int reservedSeat;
	
	private int generalSeat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoupeSeat() {
		return coupeSeat;
	}

	public void setCoupeSeat(int coupeSeat) {
		this.coupeSeat = coupeSeat;
	}

	public int getReservedSeat() {
		return reservedSeat;
	}

	public void setReservedSeat(int reservedSeat) {
		this.reservedSeat = reservedSeat;
	}

	public int getGeneralSeat() {
		return generalSeat;
	}

	public void setGeneralSeat(int generalSeat) {
		this.generalSeat = generalSeat;
	}

	@Override
	public String toString() {
		return "Train [name=" + name + ", coupe_seat=" + coupeSeat + ", reserved_seat=" + reservedSeat
				+ ", general_seat=" + generalSeat + "]";
	}
	
	

}
