package ua.nure.degtuaryov.SummaryTask4.db.dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Fields;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.dao.TripDAO;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Trip;
import ua.nure.degtuaryov.SummaryTask4.web.command.NoCommand;

public class DerbyTripDAO implements TripDAO {

	private static final String SQL_INSERT_TRIP = "INSERT INTO TRIP VALUES (default, ?, ?)";
	private static final String SQL_SELECT_TRIP_BY_STATIONS_ID = "SELECT * from TRIP where station_begin_id=? and station_end_id=?";
	private static final String SQL_SELECT_TRIP_BY_ID = "SELECT * from TRIP where id=?";
	private static final Logger LOG = Logger.getLogger(NoCommand.class);

	@Override
	public boolean addTrip(Trip trip) {
		if (findTripByStations(trip.getStationBegin().getId(), trip.getStationEnd().getId()) == 0) {
			Connection connection = null;
			PreparedStatement statement = null;
			try {
				connection = DerbyDAOFactory.getConnection();
				statement = connection.prepareStatement(SQL_INSERT_TRIP);
				int k = 1;
				statement.setLong(k++, trip.getStationBegin().getId());
				statement.setLong(k++, trip.getStationEnd().getId());
				statement.executeUpdate();
				statement.close();
			} catch (Exception ex) {
				DerbyDAOFactory.rollbackAndCloseConnectionStatment(connection, statement);
				LOG.error(ex.getMessage());
				return false;
			} finally {
				DerbyDAOFactory.commitAndCloseConnectionStatment(connection, statement);
			}
			return true;
		}
		return false;
	}

	@Override
	public Trip findTripById(long id) {
		DAOFactory daoFactory = DAOFactory.getInstance();
		Connection con = null;
		PreparedStatement statement = null;
		Trip trip = null;
		ResultSet rs = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_SELECT_TRIP_BY_ID);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			if (rs.next()) {
				trip = new Trip();
				trip.setId(id);
				trip.setStationBegin(
						daoFactory.getStationDAO().findStationById(rs.getLong(Fields.TRIP_STATION_BEGIN_ID)));
				trip.setStationEnd(daoFactory.getStationDAO().findStationById(rs.getLong(Fields.TRIP_STATION_END_ID)));
			}
		} catch (Exception e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			LOG.error(e.getMessage());
			return null;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(con, statement, rs);
		}
		return trip;
	}

	@Override
	public long findTripByStations(long st1Id, long st2Id) {
		Connection con = null;
		PreparedStatement statement = null;
		long result = 0l;
		ResultSet rs = null;
		try {
			con = DerbyDAOFactory.getConnection();
			statement = con.prepareStatement(SQL_SELECT_TRIP_BY_STATIONS_ID);
			statement.setLong(1, st1Id);
			statement.setLong(2, st2Id);
			rs = statement.executeQuery();
			if (rs.next()) {
				result = rs.getLong(Fields.ENTITY_ID);
			}
		} catch (Exception e) {
			DerbyDAOFactory.rollbackAndCloseConnectionStatment(con, statement);
			LOG.error(e.getMessage());
			return result;
		} finally {
			DerbyDAOFactory.commitAndCloseConnectionStatmentResSet(con, statement, rs);
		}
		return result;
	}

}
