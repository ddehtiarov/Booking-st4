package ua.nure.degtuaryov.SummaryTask4.db.dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Fields;
import ua.nure.degtuaryov.SummaryTask4.db.bean.RouteStationsBean;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.dao.StationDAO;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;
import ua.nure.degtuaryov.SummaryTask4.web.command.NoCommand;

public class DerbyStationDAO implements StationDAO {

	private static final String SQL_SELECT_ALL_STATIONS = "SELECT * from STATION";
	private static final String SQL_SELECT_STATION_BY_TITLE = "SELECT * from STATION where title=?";
	private static final String SQL_SELECT_STATION_BY_ID = "SELECT * from STATION where id=?";
	private static final String SQL_INSERT_STATION = "INSERT INTO STATION VALUES (default, ?)";
	private static final String SQL_UPDATE_RSB = "UPDATE Station_route SET stop_time=?, travel_time=?, position=? "
			+ "WHERE route_id=? and station_id=?";
	private static final String SQL_DELETE_RSB = "DELETE FROM Station_route WHERE route_id=? and station_id=?";
	private static final String SQL_DELETE_STATION_BY_ID = "DELETE FROM STATION WHERE id=?";
	private static final String SQL_SELECT_ALL_ROUTS_BY_STATION_ID_SR = "SELECT * from station_route where station_id=?";
	private static final Logger LOG = Logger.getLogger(NoCommand.class);
	
	@Override
	public Station findStationById(long id) {
		Connection con = null;
		PreparedStatement statement = null;
		Station station = null;
		ResultSet rs = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_SELECT_STATION_BY_ID);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			if (rs.next()) {
				station = obtainStation(rs);
			}
		} catch (Exception e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			LOG.error(e.getMessage());
			return null;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(con, statement, rs);
		}
		return station;
	}

	@Override
	public long findStationByTitle(String title) {
		Connection con = null;
		PreparedStatement statement = null;
		long stationId = 0l;
		ResultSet rs = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_SELECT_STATION_BY_TITLE);
			statement.setString(1, title);
			rs = statement.executeQuery();
			if (rs.next()) {
				stationId = rs.getLong(Fields.ENTITY_ID);
			}
		} catch (Exception e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			LOG.error(e.getMessage());
			return stationId;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(con, statement, rs);
		}
		return stationId;
	}

	@Override
	public List<Long> findRoutesIdsByStationID(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Long> result = new ArrayList<Long>();
		ResultSet rs = null;
		try {
			connection = DerbyDAOFactory.getConnection();
			statement = connection.prepareStatement(SQL_SELECT_ALL_ROUTS_BY_STATION_ID_SR);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				result.add(rs.getLong(2));
			}
		} catch (SQLException e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(connection, statement);
			LOG.error(e.getMessage());
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(connection, statement, rs);
		}
		return result;
	}

	@Override
	public List<Station> findAllStations() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Station> result = new ArrayList<Station>();
		try {
			connection = DerbyDAOFactory.getConnection();
			statement = connection.prepareStatement(SQL_SELECT_ALL_STATIONS);
			rs = statement.executeQuery();
			while (rs.next()) {
				Station station = obtainStation(rs);
				result.add(station);
			}
			Collections.sort(result, new Comparator<Station>() {
				@Override
				public int compare(Station st1, Station st2) {
					return st1.getTitle().compareToIgnoreCase(st2.getTitle());
				}
			});
		} catch (SQLException e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(connection, statement);
			LOG.error(e.getMessage());
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(connection, statement, rs);
		}
		return result;
	}

	@Override
	public boolean addStation(Station station) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_INSERT_STATION);
			int k = 1;
			statement.setString(k++, station.getTitle());
			statement.executeUpdate();
			statement.close();
		} catch (Exception ex) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			LOG.error(ex.getMessage());
			return false;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatment(con, statement);
		}
		return true;
	}

	@Override
	public boolean removeStation(long id) {
		boolean flag = false;
		if (updateRouteStationsByStationIdPr(id)) {
			flag = removeStationPr(id);
		}
		return flag;
	}

	private boolean removeStationPr(long id) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_DELETE_STATION_BY_ID);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			return false;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatment(con, statement);
		}
		return true;
	}

	private boolean updateRouteStationsByStationIdPr(long id) {
		List<RouteStationsBean> beans = getRouteStationsBeanByStationId(id);
		Station station = findStationById(id);
		if (beans != null) {
			for (RouteStationsBean routeStationsBean : beans) {
				int index = 0;
				if (routeStationsBean.getStationTimesList().size() > 2) {
					for (int i = 0; i < routeStationsBean.getStationTimesList().size(); i++) {
						index = i;
						if (station.getTitle()
								.equals(routeStationsBean.getStationTimesList().get(i).getStation().getTitle())) {
							break;
						}
					}
					if (index != routeStationsBean.getStationTimesList().size() && index != 0) {
						routeStationsBean.getStationTimesList().get(index - 1)
								.setTravelTime(routeStationsBean.getStationTimesList().get(index - 1).getTravelTime()
										+ routeStationsBean.getStationTimesList().get(index).getTravelTime());
					}
					routeStationsBean.getStationTimesList().remove(index);

					routeStationsBean.getStationTimesList().get(routeStationsBean.getStationTimesList().size() - 1)
							.setStopTime(0);
					routeStationsBean.getStationTimesList().get(routeStationsBean.getStationTimesList().size() - 1)
							.setTravelTime(0);
					Connection con = null;
					PreparedStatement statement = null;
					try {
						con = DerbyDAOFactory.getConnection();
						statement = con.prepareStatement(SQL_UPDATE_RSB);
						for (int i = 0; i < routeStationsBean.getStationTimesList().size(); i++) {
							int k = 1;
							Station st = routeStationsBean.getStationTimesList().get(i).getStation();
							statement.setInt(k++, routeStationsBean.getStationTimesList().get(i).getStopTime());
							statement.setInt(k++, routeStationsBean.getStationTimesList().get(i).getTravelTime());
							statement.setInt(k++, i);
							statement.setLong(k++, routeStationsBean.getRoute().getId());
							statement.setLong(k, st.getId());
							statement.executeUpdate();
						}
					} catch (Exception e) {
						LOG.error(e.getMessage());
						DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
						return false;
					} finally {
						DerbyDAOFactory.commitAndCloseConnectionStatment(con, statement);
					}
				} else {
					deleteRouteStationBeanPr(routeStationsBean);
					DAOFactory daoFactory = DAOFactory.getInstance();
					daoFactory.getRouteDAO().removeRoute(routeStationsBean.getRoute().getId());
				}
			}
		}
		return true;
	}

	private boolean deleteRouteStationBeanPr(RouteStationsBean routeStationsBean) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = DerbyDAOFactory.getConnection();
			for (int i = 0; i < routeStationsBean.getStationTimesList().size(); i++) {
				statement = con.prepareStatement(SQL_DELETE_RSB);
				statement.setLong(1, routeStationsBean.getRoute().getId());
				statement.setLong(2, routeStationsBean.getStationTimesList().get(i).getStation().getId());
				statement.executeUpdate();
				statement.close();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			return false;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatment(con, statement);
		}
		return true;
	}

	@Override
	public List<RouteStationsBean> getRouteStationsBeanByStationId(long id) {
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<RouteStationsBean> beans = new ArrayList<RouteStationsBean>();
		List<Long> routesId = findRoutesIdsByStationID(id);
		for (long routeId : routesId) {
			beans.add(daoFactory.getRouteDAO().getRouteStationsBeanByRouteId(routeId));
		}

		return beans;
	}

	@Override
	public Boolean existStationByTitle(String title) {
		Boolean result = false;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_SELECT_STATION_BY_TITLE);
			statement.setString(1, title);
			rs = statement.executeQuery();
			if (rs.next() && rs.getLong(Fields.ENTITY_ID) > 0) {
					result = true;
			}
		} catch (Exception e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			LOG.error(e.getMessage());
			result = true;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(con, statement, rs);
		}
		return result;
	}

	private Station obtainStation(ResultSet resultSet) throws SQLException {
		Station station = new Station();
		station.setId(resultSet.getLong(Fields.ENTITY_ID));
		station.setTitle(resultSet.getString(Fields.STATION_TITLE));
		return station;
	}

}
