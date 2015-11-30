package ua.nure.degtuaryov.SummaryTask4.web.command;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class CommandTest {
	
	static Command com;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		com = new LogoutCommand();
	}

	@Test
	public void testExecute() throws IOException, ServletException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		com.execute(request, response);
	}

	@Test
	public void testToString() {
		System.out.println(com);
	}

}
