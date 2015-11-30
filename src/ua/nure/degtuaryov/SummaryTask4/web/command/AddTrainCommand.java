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
 * AddTrainCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class AddTrainCommand extends Command {

	private static final long serialVersionUID = 21317600039343228L;

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
	
	private static final String WRONG = "wrong";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOGGER.debug("AddTrainCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		String name = request.getParameter("name");
		LOGGER.trace("Request parameter: loging --> " + name);

		int coupeSeat = Integer.valueOf(request.getParameter("coupeSeat"));
		int reservedSeat = Integer.valueOf(request.getParameter("reservedSeat"));
		int generalSeat = Integer.valueOf(request.getParameter("generalSeat"));

		LOGGER.trace("Request parameter: password --> " + coupeSeat);
		LOGGER.trace("Request parameter: email --> " + reservedSeat);
		LOGGER.trace("Request parameter: firstname --> " + generalSeat);

		String forward = Path.PAGE_ERROR_PAGE;
		Train train = new Train();
		train.setName(name);
		train.setCoupeSeat(coupeSeat);
		train.setReservedSeat(reservedSeat);
		train.setGeneralSeat(generalSeat);
		request.setAttribute("train", train);
		if (name == null || name.isEmpty() || coupeSeat < 0 || reservedSeat < 0 || generalSeat < 0
				|| name.length() > 20) {
			request.setAttribute(WRONG, "Please, complete all the fields correctly!");
			forward = Path.COMMAND_VIEW_ADD_TRAIN;
		} else {
			if (daoFactory.getTrainDAO().addTrain(train)) {
				request.setAttribute("success", "You add new train!");
				LOGGER.debug("AddCommand:" + train);
				forward = Path.COMMAND_VIEW_ALL_TRAINS;
			} else {
				request.setAttribute(WRONG, "Error. try later!");
				forward = Path.COMMAND_VIEW_ALL_TRAINS;
			}
		}
		LOGGER.debug("AddTrainCommand ends");
		return forward;
	}

}
