package ua.nure.degtuaryov.SummaryTask4.db.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Route;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;

public class RouteStationsBeanTest {

	static RouteStationsBean routeStationBean;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		routeStationBean = new RouteStationsBean();
	}

	@Test
	public void testGetRoute() {
		long id = 1l;
		Route route = new Route();
		route.setId(id);
		routeStationBean.setRoute(route);
		assertEquals(Long.valueOf(routeStationBean.getRoute().getId()), Long.valueOf(id));
	}

	@Test
	public void testGetStationTimesList() {
		Station station = new Station();
		station.setTitle("t1");
		routeStationBean.setStationTimesList(station, 1, 1);
		String stl = routeStationBean.getStationTimesList().get(0).getStation().getTitle()
				+ routeStationBean.getStationTimesList().get(0).getStopTime()
				+ routeStationBean.getStationTimesList().get(0).getTravelTime()
				+ routeStationBean.getStationTimesList().get(0);
		assertEquals(stl, "t111" + routeStationBean.getStationTimesList().get(0));
	}

	@Test
	public void testToString() {
		System.out.println(routeStationBean);
	}

}
