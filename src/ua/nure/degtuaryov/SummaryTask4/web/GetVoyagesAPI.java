package ua.nure.degtuaryov.SummaryTask4.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.bean.VoyageBean;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.web.command.LoginCommand;

/**
 * API for getting all the voyages from my data base
 * 
 * @author Degtuaryow
 *
 */
@WebServlet("/getVoyages")
public class GetVoyagesAPI extends HttpServlet {

	private static final long serialVersionUID = 3903617600039343228L;

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LOGGER.debug("GetVoyagesAPI starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<VoyageBean> voyageBeans = daoFactory.getVoyageDAO().findAllVoyageBeans();
		String json = new Gson().toJson(voyageBeans);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		LOGGER.debug("GetVoyagesAPI ends");
	}

}
