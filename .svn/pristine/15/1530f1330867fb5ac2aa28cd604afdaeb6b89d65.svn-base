package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * ViewAllTicketsListCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewAllTicketsListCommand extends Command {

	private static final long serialVersionUID = 4352465768434L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewAllTicketsListCommand starts");
		String forward = Path.PAGE_ERROR_PAGE;
		DAOFactory.setDaoFactoryFCN(Constants.DAO_FACTORY);
		DAOFactory daoFactory = DAOFactory.getInstance();
		Client client = daoFactory.getClientDAO()
				.findClientByLogin(((Client) request.getSession().getAttribute("client")).getLogin());
		List<Booking> bookings = daoFactory.getBookingDAO().fingAllBookingByClientId(client.getId());
		if (bookings.isEmpty()) {
			request.setAttribute("wrong", "YOu have not any tickets!!!");
		}else{
			List<BookingBean> bookingBeans = new ArrayList<>();
			for(Booking booking : bookings){
				bookingBeans.add(daoFactory.getBookingDAO().fingBookingBeanByBooking(booking));
			}
			request.setAttribute("bookingBeans", bookingBeans);
		}
		LOG.debug("ViewAllTicketsListCommand ends");
		forward = Path.PAGE_ALL_TICKETS;
		return forward;
	}

}
