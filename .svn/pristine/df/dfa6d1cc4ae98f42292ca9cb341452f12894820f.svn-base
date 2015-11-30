package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.bean.VoyageBean;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewVoyagesListCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewVoyagesListCommand extends Command {

	private static final long serialVersionUID = 515513307548452601L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewVoyagesListCommand starts");
		String forward = Path.PAGE_ERROR_PAGE;
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<VoyageBean> voyageBeans = daoFactory.getVoyageDAO().findAllVoyageBeans();
		if (voyageBeans.isEmpty()) {
			request.setAttribute("error", "Try again later, we have some errors at the server!");
		}
		String type = request.getParameter("type");
		if (type != null && !type.isEmpty()) {
			switch (type) {
			case "GET_BY_DATE": {
				String date = request.getParameter("date");
				if (date != null && !date.isEmpty() && date.matches("(\\d{4})-(\\d{2})-(\\d{2})")) {
					ArrayList<VoyageBean> ar = new ArrayList<>();
					for (int i = 0; i < voyageBeans.size(); i++) {
						if (voyageBeans.get(i).getArrivalTime().toString().substring(0, 10).equals(date)) {
							ar.add(voyageBeans.get(i));
						}
					}
					voyageBeans = ar;
					request.setAttribute("date", date);
				}
			}
				break;
			case "SORT_BY_DATE":
				Collections.reverse(voyageBeans);
				break;
			default:
				break;
			}
			request.setAttribute("type", type);
		}
		request.setAttribute("voyageBeans", voyageBeans);
		forward = Path.PAGE_SHOW_ALL_VOYAGES;
		LOG.debug("ViewVoyagesListCommand ends");
		return forward;
	}

}
