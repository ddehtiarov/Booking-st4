package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClientTest {
	
	static Client client;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		client = new Client();
	}

	@Test
	public void testGetLogin() {
		client.setLogin("login");
		assertEquals(client.getLogin(), "login");
	}

	@Test
	public void testGetPassword() {
		client.setPassword("pass");
		assertEquals(client.getPassword(), "pass");
	}

	@Test
	public void testGetFirstName() {
		client.setFirstName("fn");
		assertEquals(client.getFirstName(), "fn");
	}

	@Test
	public void testGetSecondName() {
		client.setSecondName("sn");
		assertEquals(client.getSecondName(), "sn");
	}

	@Test
	public void testGetRoleId() {
		long id = 1l;
		client.setRoleId(id);
		assertEquals(Long.valueOf(client.getRoleId()), Long.valueOf(id));
	}

	@Test
	public void testGetEmail() {
		client.setEmail("email");
		assertEquals(client.getEmail(), "email");
	}

	@Test
	public void testGetSurname() {
		client.setSurname("srn");
		assertEquals(client.getSurname(), "srn");
	}

	@Test
	public void testToString() {
		System.out.println(client);
	}

	@Test
	public void testGetId() {
		long id = 1l;
		client.setId(id);
		assertEquals(Long.valueOf(client.getId()), Long.valueOf(id));
	}

}
