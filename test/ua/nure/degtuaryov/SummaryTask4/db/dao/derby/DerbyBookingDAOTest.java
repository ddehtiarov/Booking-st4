package ua.nure.degtuaryov.SummaryTask4.db.dao.derby;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ua.nure.degtuaryov.SummaryTask4.db.dao.BookingDAO;
import ua.nure.degtuaryov.SummaryTask4.db.entity.Booking;

public class DerbyBookingDAOTest {

	static BookingDAO derbyBooningDao;
	
	@Mock
	DataSource mockitoDataSourse;
	@Mock
	DerbyDAOFactory mockDbConnection;
	@Mock
	PreparedStatement mockPreparedStatement;
	@Mock
	ResultSet mockResultSet;

	@BeforeClass
	public	 void setUpBeforeClass() throws Exception {
		derbyBooningDao = new DerbyBookingDAO();
	}

	@Test
	public void testAddBooking() {
		Booking booking = Mockito.mock(Booking.class);
		derbyBooningDao.addBooking(booking);
		
		

		//Mockito.when(DerbyDAOFactory.class).thenReturn((DerbyDAOFactory)mockDbConnection);
	}

	@Test
	public void testRemoveBooking() {
		// fail("Not yet implemented");
	}

	@Test
	public void testFingAllBookingByClientId() {
		// fail("Not yet implemented");
	}

	@Test
	public void testFingBookingById() {
		// fail("Not yet implemented");
	}

	@Test
	public void testFingBookingBeanByBooking() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetMaxseatNumber() {
		// fail("Not yet implemented");
	}

	@Test
	public void testFingBookingByClientId() {
		// fail("Not yet implemented");
	}

}
