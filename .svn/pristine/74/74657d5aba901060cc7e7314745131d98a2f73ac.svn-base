package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewAddRoutePageCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewAddRoutePageCommand extends Command {

	private static final long serialVersionUID = 811289606706749040L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewAddRoutePageCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<String> names = new ArrayList<>();
		List<Station> stations = daoFactory.getStationDAO().findAllStations();
		for (Station station : stations) {
			names.add(station.getTitle());
		}
		request.setAttribute("stations", names);
		LOG.debug("ViewAddRoutePageCommand ends");
		return Path.PAGE_ADD_ROUTE;
	}

}
