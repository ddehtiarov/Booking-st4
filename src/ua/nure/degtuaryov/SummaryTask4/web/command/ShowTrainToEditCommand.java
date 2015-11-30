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
 * ShowTrainToEditCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ShowTrainToEditCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -178600002126745912L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ShowTrainToEditCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		String forward = Path.PAGE_ERROR_PAGE;
		Long id = (Long) (request.getAttribute("id"));
		Train train = daoFactory.getTrainDAO().findTrainById(id);
		if (train != null) {
			request.setAttribute("train", train);
			forward = Path.PAGE_EDIT_TRAIN;
		}
		LOG.debug("ShowTrainToEditCommand ends");
		return forward;
	}

}
