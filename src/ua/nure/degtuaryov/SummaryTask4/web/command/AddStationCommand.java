package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * AddStationCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class AddStationCommand extends Command {

	private static final long serialVersionUID = 390361712368533228L;

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
	
	private static final String WRONG = "wrong";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOGGER.debug("AddStationCommand starts");

		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		String title = request.getParameter("title");
		LOGGER.trace("Request parameter: title --> " + title);

		String forward = Path.PAGE_ERROR_PAGE;
		Station station = new Station();
		station.setTitle(title);

		if (title == null || title.isEmpty() || title.length() > 20) {
			request.setAttribute(WRONG, "Please, complete the fields and continue!");
			forward = Path.COMMAND_VIEW_ADD_STATION;
		} else {
			if (daoFactory.getStationDAO().addStation(station)) {
				request.setAttribute("success", "YOu add a station!");
				forward = Path.COMMAND_VIEW_ALL_STATIONS;
			} else {
				Locale local = new Locale(Config.get(request.getSession(), Config.FMT_LOCALE).toString());
				ResourceBundle rb = ResourceBundle.getBundle("resources", local);
				request.setAttribute(WRONG, rb.getString("add_new_station_page.error_message"));
				forward = Path.COMMAND_VIEW_ADD_STATION;
			}
		}
		request.setAttribute("station", station);
		LOGGER.debug("AddStationCommand ends");
		return forward;
	}

}
