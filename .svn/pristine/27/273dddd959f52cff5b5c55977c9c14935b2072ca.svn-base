package ua.nure.degtuaryov.SummaryTask4.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.nure.degtuaryov.SummaryTask4.db.entity.Client;

public class RoleTest {

	static Role role;

	@Test
	public void testGetRole() {
		Client client = new Client();
		client.setRoleId(1);
		assertEquals(Role.getRole(client), Role.valueOf("CLIENT"));
	}

	@Test
	public void testGetName() {
		assertEquals(Role.values()[0].getName(), "admin");
	}

}
