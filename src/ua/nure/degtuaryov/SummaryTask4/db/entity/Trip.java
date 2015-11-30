package ua.nure.degtuaryov.SummaryTask4.db.entity;

/**
 * 
 * Trip class entity from database, extends Entity
 * 
 * @author Degtuaryow
 *
 */
public class Trip extends Entity {

	private static final long serialVersionUID = -1846268360052543910L;
	
	private Station stationBegin;
	
	private Station stationEnd;

	public Station getStationBegin() {
		return stationBegin;
	}

	public void setStationBegin(Station stationBegin) {
		this.stationBegin = stationBegin;
	}

	public Station getStationEnd() {
		return stationEnd;
	}

	public void setStationEnd(Station stationEnd) {
		this.stationEnd = stationEnd;
	}

	@Override
	public String toString() {
		return "Trip [stationBegin=" + stationBegin + ", stationEnd=" + stationEnd + "]";
	}
	
}
