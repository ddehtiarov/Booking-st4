package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Route;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewRoutesListCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewRoutesListCommand extends Command {

	private static final long serialVersionUID = 987654002218452601L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewRoutesListCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<Route> routes = daoFactory.getRouteDAO().findAllRoutes();
		if (routes.isEmpty()) {
			request.setAttribute("error", "Try again later, we have some errors at the server!");
		}
		request.setAttribute("routes", routes);
		LOG.debug("ViewRoutesListCommand ends");
		return Path.PAGE_SHOW_ALL_ROUTES;
	}

}
