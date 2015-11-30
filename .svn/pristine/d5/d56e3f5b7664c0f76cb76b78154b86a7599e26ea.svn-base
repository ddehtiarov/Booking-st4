package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Train;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewTrainsListCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewTrainsListCommand extends Command {

	private static final long serialVersionUID = 5155139876518452601L;

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewTrainsListCommand starts");
		String forward = Path.PAGE_ERROR_PAGE;
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<Train> trains = daoFactory.getTrainDAO().findAllTrains();
		if (trains.isEmpty()) {
			request.setAttribute("error", "Try again later, we have some errors at the server!");
		}
		request.setAttribute("trains", trains);
		forward = Path.PAGE_SHOW_ALL_TRAINS;
		LOG.debug("ViewTrainsListCommand ends");
		return forward;
	}

}
