package ua.nure.degtuaryov.SummaryTask4.db.bean;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Route;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Train;

public class VoyageBeanTest {
	
	static VoyageBean voyageBean;
 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		voyageBean = new VoyageBean();
	}

	@Test
	public void testGetId() {
		voyageBean.setId(1l);
		assertEquals(Long.valueOf(voyageBean.getId()), Long.valueOf(1l));
	}

	@Test
	public void testGetArrivalTime() {
		Date d = new Date();
		voyageBean.setDepartureTime(new Timestamp(d.getTime()));
		assertEquals(voyageBean.getDepartureTime(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetDepartureTime() {
		Date d = new Date();
		voyageBean.setArrivalTime(new Timestamp(d.getTime()));
		assertEquals(voyageBean.getArrivalTime(), new Timestamp(d.getTime()));
	}

	@Test
	public void testGetCoupeSeat() {
		voyageBean.setCoupeSeat(1);
		assertEquals(voyageBean.getCoupeSeat(), 1);
	}

	@Test
	public void testGetReservedSeat() {
		voyageBean.setReservedSeat(1);
		assertEquals(voyageBean.getReservedSeat(), 1);
	}

	@Test
	public void testGetGeneralSeat() {
		voyageBean.setGeneralSeat(1);
		assertEquals(voyageBean.getGeneralSeat(), 1);
	}

	@Test
	public void testGetTrain() {
		Train train = new Train();
		train.setName("tname");
		voyageBean.setTrain(train);
		assertEquals(voyageBean.getTrain().getName(), "tname");
	}

	@Test
	public void testGetRouteStationsBean() {
		RouteStationsBean routeStationsBean = new RouteStationsBean();
		Route route = new Route();
		route.setName("name");
		routeStationsBean.setRoute(route);
		voyageBean.setRouteStationsBean(routeStationsBean);
		assertEquals(voyageBean.getRouteStationsBean().getRoute().getName(), "name");
	}

	@Test
	public void testToString() {
		System.out.println(voyageBean);
	}

}
