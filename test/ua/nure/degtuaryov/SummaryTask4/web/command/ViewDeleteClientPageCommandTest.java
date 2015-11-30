package ua.nure.degtuaryov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class ViewDeleteClientPageCommandTest {

	static ViewAddRoutePageCommand viewDelete;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		viewDelete = new ViewAddRoutePageCommand();
	}

	@Test
	public void testExecute() throws IOException, ServletException {
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		ViewDeleteClientPageCommand deleteClientPageCommand = Mockito.mock(ViewDeleteClientPageCommand.class);
		deleteClientPageCommand.execute(request, response);
	}

}
