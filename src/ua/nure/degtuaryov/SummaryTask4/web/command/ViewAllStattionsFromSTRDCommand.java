package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.bean.RouteStationsBean;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewAllStattionsFromSTRDCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewAllStattionsFromSTRDCommand extends Command {

	private static final long serialVersionUID = 5155133065453452601L;

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewAllStattionsFromSTRDCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		long id = Long.valueOf(request.getParameter("id"));
		RouteStationsBean routeStationsBean = daoFactory.getRouteDAO().getRouteStationsBeanByRouteId(id);
		if (routeStationsBean == null) {
			request.setAttribute("error", "Try again later, we have some errors at the server!");
		}
		request.setAttribute("routeStationsBean", routeStationsBean);
		LOG.debug("ViewAllStattionsFromSTRDCommand ends");
		return Path.PAGE_SHOW_ALL_STATIONSS_BY_ROUTE_ID;
		
	}

}
