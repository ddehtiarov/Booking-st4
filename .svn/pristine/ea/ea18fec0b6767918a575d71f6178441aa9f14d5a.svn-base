package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Train;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewDeleteTrainPageCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewDeleteTrainPageCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 71343376711L;

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		LOG.debug("ViewDeleteTrainPageCommand starts");
		String forward = Path.PAGE_ERROR_PAGE;
		if (request.getAttribute("id") == null || request.getAttribute("id").toString().isEmpty()) {
			return forward;
		} else {
			Long id = (Long) (request.getAttribute("id"));
			Train train = daoFactory.getTrainDAO().findTrainById(id);
			if (train != null) {
				request.setAttribute("train", train);
				forward = Path.PAGE_DELETE_TRAIN;
			}
		}
		LOG.debug("ViewDeleteTrainPageCommand ends");
		return forward;
	}

}
