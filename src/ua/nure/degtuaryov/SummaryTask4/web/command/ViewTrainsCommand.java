package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.bean.RouteStationsBean;
import ua.nure.degtuaryov.SummaryTask4.db.bean.RouteStationsBean.StationTime;
import ua.nure.degtuaryov.SummaryTask4.db.bean.VoyageBean;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Station;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewTrainsCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewTrainsCommand extends Command {

	private static final long serialVersionUID = 515511232218452601L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewTrainsCommand starts");
		String forward = Path.PAGE_TRAINS;
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<Station> stationsList = daoFactory.getStationDAO().findAllStations();
		if (stationsList.isEmpty()) {
			request.setAttribute("error", "Try again later, we have some errors at the server!");
		}
		List<String> stationNames = new ArrayList<>();
		for (Station st : stationsList) {
			stationNames.add(st.getTitle());
		}
		request.setAttribute("stations", stationNames);
		String station1 = request.getParameter("station1");
		String station2 = request.getParameter("station2");
		String date = request.getParameter("date");
		Locale local = new Locale(Config.get(request.getSession(), Config.FMT_LOCALE).toString());
		ResourceBundle rb = ResourceBundle.getBundle("resources", local);
		if (station1 != null && station2 != null && !station1.isEmpty() && !station2.isEmpty() && date != null) {
			long stId1 = daoFactory.getStationDAO().findStationByTitle(station1);
			long stId2 = daoFactory.getStationDAO().findStationByTitle(station2);
			if (stId1 != 0 && stId2 != 0) {
				List<RouteStationsBean> routeStationsBeans = daoFactory.getStationDAO()
						.getRouteStationsBeanByStationId(stId2);
				List<RouteStationsBean> resultRouteStationsBeans = new ArrayList<>();
				for (RouteStationsBean bean : routeStationsBeans) {
					for (StationTime stationTime : bean.getStationTimesList()) {
						if (stationTime.getStation().getTitle().equals(station2)) {
							break;
						}
						if (stationTime.getStation().getTitle().equals(station1)) {
							resultRouteStationsBeans.add(bean);
							break;
						}
					}
				}
				List<VoyageBean> voyageBeans = new ArrayList<>();
				for (RouteStationsBean bean : resultRouteStationsBeans) {
					voyageBeans
							.addAll(daoFactory.getVoyageDAO().findVoyageBeanByRouteId(bean.getRoute().getId(), date));
				}
				request.setAttribute("voyageBeans", voyageBeans);
				request.setAttribute("st1", stId1);
				request.setAttribute("st2", stId2);
				if (voyageBeans.size() < 1) {
					request.setAttribute("wrong", rb.getString("find_train_main_page.nothing_found"));
				}
			} else {
				request.setAttribute("wrong", rb.getString("find_train_main_page.error_in_st_name"));
			}
		}
		LOG.debug("ViewTrainsCommand ends");
		request.setAttribute("station1", station1);
		request.setAttribute("station2", station2);
		request.setAttribute("date", date);
		return forward;
	}

}
