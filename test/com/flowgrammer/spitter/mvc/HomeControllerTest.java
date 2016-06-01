package com.flowgrammer.spitter.mvc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.flowgrammer.spitter.domain.Spittle;
import com.flowgrammer.spitter.service.SpitterService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static com.flowgrammer.spitter.mvc.HomeController.*;

public class HomeControllerTest {
	@Test
	public void shouldDisplayRecentSpittles() {
		List<Spittle> exptedtedSpittles = Arrays.asList(new Spittle(), new Spittle(), new Spittle());
		SpitterService spitterService = mock(SpitterService.class);
		
		when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(exptedtedSpittles);
		
		HomeController controller = new HomeController(spitterService);
		HashMap<String, Object> model = new HashMap<String, Object>();
		String viewName = controller.showHomePage(model);
		assertEquals("home", viewName);
		assertSame(exptedtedSpittles, model.get("spittles"));
		verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
	}

}
