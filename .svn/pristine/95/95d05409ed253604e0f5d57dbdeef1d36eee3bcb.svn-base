package ua.nure.degtuaryov.SummaryTask4.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class EncodingFilterTest {

	static EncodingFilter enf;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		enf = new EncodingFilter();
	}
	
	@Test
	public void testMock() throws IOException, ServletException{		
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		FilterChain chain = Mockito.mock(FilterChain.class);
		
		enf.doFilter(request, response, chain);
		
		FilterConfig fConfig = Mockito.mock(FilterConfig.class); 
		enf.init(fConfig);
		enf.destroy();
	}

}
