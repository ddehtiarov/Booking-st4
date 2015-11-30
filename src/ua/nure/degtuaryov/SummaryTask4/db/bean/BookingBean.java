package ua.nure.degtuaryov.SummaryTask4.db.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import ua.nure.degtuaryov.SummaryTask4.db.Benefit;
import ua.nure.degtuaryov.SummaryTask4.db.Seat;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Client;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Trip;

/**
 * BookingBean is bean for containing all booking data in one object
 * 
 * @author Degtuaryow
 *
 */
public class BookingBean implements Serializable {

	private static final long serialVersionUID = 5876854063178982206L;

	private long id;

	private Client client;

	private Benefit benefit;

	private VoyageBean voyageBean;

	private Timestamp date;

	private Trip trip;

	private Seat seat;

	private Booking booking;

	private StationBE stationBE;

	public BookingBean() {
		stationBE = new StationBE();
	}

	public StationBE getStationBE() {
		return stationBE;
	}

	public void setStationBE(Station station1, Station station2) {
		stationBE.setStation1(station1);
		stationBE.setStation2(station2);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public VoyageBean getVoyageBean() {
		return voyageBean;
	}

	public void setVoyageBean(VoyageBean voyageBean) {
		this.voyageBean = voyageBean;
	}

	public Benefit getBenefit() {
		return benefit;
	}

	public void setBenefit(Benefit benefit) {
		this.benefit = benefit;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "BookingBean [id=" + id + ", client=" + client + ", benefit=" + benefit + ", voyageBean=" + voyageBean
				+ ", date=" + date + ", trip=" + trip + ", seat=" + seat + ", booking=" + booking + "]";
	}

	/**
	 * 
	 * StationBeginEnd is a helpful object for working with BookingBeag, it
	 * contains 2 stations begin and end
	 * 
	 * @author Degtuaryow
	 *
	 */
	public static class StationBE implements Serializable {

		private static final long serialVersionUID = 2496098607645334678L;

		private Station station1;

		private Station station2;

		public Station getStation1() {
			return station1;
		}

		public void setStation1(Station station1) {
			this.station1 = station1;
		}

		public Station getStation2() {
			return station2;
		}

		public void setStation2(Station station2) {
			this.station2 = station2;
		}
	}
}
