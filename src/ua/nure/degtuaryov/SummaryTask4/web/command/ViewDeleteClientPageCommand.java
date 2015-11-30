package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Client;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewDeleteClientPageCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewDeleteClientPageCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -82786713433246711L;

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewDeleteClientPageCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		String forward = Path.PAGE_ERROR_PAGE;
		if (request.getAttribute("id") == null || request.getAttribute("id").toString().isEmpty()) {
			return forward;
		} else {
			Long id = (Long) (request.getAttribute("id"));
			Client client = daoFactory.getClientDAO().findClientById(id);
			if (client != null) {
				request.setAttribute("client", client);
				forward = Path.PAGE_DELETE_CLIENT;
			} 
			LOG.debug("ViewDeleteClientPageCommand ends");
		}
		return forward;
	}

}
