package ua.nure.degtuaryov.SummaryTask4.web.command;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import ua.nure.degtuaryov.SummaryTask4.db.dao.DAOFactory;
import ua.nure.degtuaryov.SummaryTask4.db.dao.derby.DerbyDAOFactory;
import ua.nure.degtuaryov.SummaryTask4.utils.Password;

@PrepareForTest({ DerbyDAOFactory.class })
@RunWith(PowerMockRunner.class)
public class CommandsTest {

	@Mock
	DAOFactory mockDAO;

	@Mock
	private HttpServletRequest mockReq;

	@Mock
	private HttpServletResponse mockResp;

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(DerbyDAOFactory.class);
		Mockito.when(DAOFactory.getInstance()).thenReturn(mockDAO);
		Mockito.doNothing().when(mockReq).setAttribute(Mockito.anyString(), Mockito.anyString());
	}

	@Test
	public void testExecutedeleteClientCommand1() throws IOException, ServletException {
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		DeleteClientCommand deleteClientPageCommand = new DeleteClientCommand();
		deleteClientPageCommand.execute(request, response);
	}

//	@Test
//	public void testExecutedeleteClientCommand2() throws IOException, ServletException {
//		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//		Mockito.when(mockReq.getAttribute(Mockito.anyString())).thenReturn("12");
//		DeleteClientCommand deleteClientPageCommand = new DeleteClientCommand();
//		Mockito.when(mockDAO.getClientDAO().removeClient(Mockito.anyLong())).thenReturn(Boolean.FALSE);
//		deleteClientPageCommand.execute(mockReq, mockResp);
//	}

}
