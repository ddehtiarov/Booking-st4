package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * DeleteRouteCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class DeleteRouteCommand extends Command {

	private static final long serialVersionUID = 96128238678036708L;

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOGGER.debug("DeleteRouteCommand starts");
		String forward = Path.COMMAND_VIEW_ALL_ROUTES;
		Long id = (Long) request.getAttribute("id");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		if (daoFactory.getRouteDAO().removeRoute(id)) {
			forward = Path.COMMAND_VIEW_ALL_ROUTES;
			request.setAttribute("success", "You delete train!");
		}
		LOGGER.debug("DeleteRouteCommand ends");
		return forward;
	}

}
