package ua.nure.degtuaryov.SummaryTask4.web.command;

import static org.junit.Assert.*;

import org.apache.derby.tools.sysinfo;
import org.junit.Before;
import org.junit.Test;

public class CommandContainerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() {
		CommandContainer commandContainer = new CommandContainer();
		System.out.println(commandContainer.get("ddd"));
	}

}
