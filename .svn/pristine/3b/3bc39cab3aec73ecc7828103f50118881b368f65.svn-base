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
 * DeleteStationCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class DeleteStationCommand extends Command {

	private static final long serialVersionUID = 2089718238671208978L;

	private static final Logger LOGER = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = Path.PAGE_ERROR_PAGE;
		LOGER.debug("DeleteStationCommand starts");
		if (request.getAttribute("id") == null || request.getAttribute("id").toString().isEmpty()) {
			return forward;
		} else {
			Long id = (Long) request.getAttribute("id");
			DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
			DAOFactory daoFactory = DAOFactory.getInstance();
			if (daoFactory.getStationDAO().removeStation(id)) {
				forward = Path.COMMAND_VIEW_ALL_STATIONS;
				request.setAttribute("success", "You delete station!");
			}
		}
		LOGER.debug("DeleteStationCommand starts");
		return forward;
	}

}
