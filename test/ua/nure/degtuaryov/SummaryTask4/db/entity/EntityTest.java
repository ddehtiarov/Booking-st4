package ua.nure.degtuaryov.SummaryTask4.db.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EntityTest {

	@Test
	public void testGetId() {
		Entity entity = new Entity();
		entity.setId(1L);
		assertEquals(Long.valueOf(entity.getId()), Long.valueOf(1l));
	}

}
