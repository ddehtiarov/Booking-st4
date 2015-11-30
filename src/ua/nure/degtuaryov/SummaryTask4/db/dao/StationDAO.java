package ua.nure.degtuaryov.SummaryTask4.db.dao;

import java.util.List;

import ua.nure.degtuaryov.SummaryTask4.db.bean.RouteStationsBean;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;

/**
 * Interface dao producing implementations StationDAO
 * 
 * @author Degtuaryow
 *
 */
public interface StationDAO {

	Station findStationById(long id);
	
	long findStationByTitle(String title);

	List<Station> findAllStations();

	boolean addStation(Station station);

	boolean removeStation(long id);
	
	Boolean existStationByTitle(String title);
	
	List<Long> findRoutesIdsByStationID(long id);
	
	List<RouteStationsBean> getRouteStationsBeanByStationId(long id);
	
}
