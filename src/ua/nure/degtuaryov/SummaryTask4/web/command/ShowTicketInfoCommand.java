package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.db.Constants;
import ua.nure.degtuaryov.SummaryTask4.db.bean.BookingBean;
import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Client;
import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ShowTicketInfoCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ShowTicketInfoCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1786023921267400987L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ShowTicketInfoCommand starts");
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		String forward = Path.PAGE_ERROR_PAGE;
		Long id = (Long) (request.getAttribute("id"));
		Client client = daoFactory.getClientDAO()
				.findClientByLogin(((Client) request.getSession().getAttribute("client")).getLogin());
		Booking booking = daoFactory.getBookingDAO().fingBookingByClientId(id, client.getId());
		if (booking != null) {
			BookingBean bookingBean = daoFactory.getBookingDAO().fingBookingBeanByBooking(booking);
			request.setAttribute("bookingBean", bookingBean);
			forward = Path.PAGE_OUN_TICKET;
		}else {
			request.setAttribute("wrong", "invalid parametrs!");
			forward = Path.PAGE_OUN_TICKET;
		}
		LOG.debug("ShowTicketInfoCommand engs");
		return forward;
	}

}
