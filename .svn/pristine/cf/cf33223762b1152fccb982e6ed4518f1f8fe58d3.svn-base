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
 * DeleteVoyageCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class DeleteVoyageCommand extends Command {

	private static final long serialVersionUID = 90902386036708L;

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = Path.PAGE_ERROR_PAGE;
		LOGGER.debug("DeleteVoyageCommand starts");
		if (request.getAttribute("id") == null || request.getAttribute("id").toString().isEmpty()) {
			return forward;
		} else {
			Long id = (Long) request.getAttribute("id");
			DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
			DAOFactory daoFactory = DAOFactory.getInstance();
			if (daoFactory.getVoyageDAO().removeVoyage(id)) {
				forward = Path.COMMAND_VIEW_ALL_VOYAGES;
				request.setAttribute("success", "You delete station!");
			}
		}
		LOGGER.debug("DeleteVoyageCommand starts");
		return forward;
	}

}
