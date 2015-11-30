package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.degtuaryov.SummaryTask4.web.Path;

/**
 * ViewAddTrainPageCommand command.
 * 
 * @author Dedtuaryow
 * 
 */
public class ViewAddTrainPageCommand extends Command {

	private static final long serialVersionUID = 84367865921049040L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		LOG.debug("ViewAddTrainPageCommand starts");
		LOG.debug("ViewAddTrainPageCommand ends");
		return Path.PAGE_ADD_TRAIN;
	}

}
