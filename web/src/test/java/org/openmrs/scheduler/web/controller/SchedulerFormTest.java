package org.openmrs.scheduler.web.controller;

import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.openmrs.web.test.BaseWebContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class SchedulerFormTest extends BaseWebContextSensitiveTest {
	
	@Autowired
	private SchedulerFormController controller;
	
	/**
	 * See TRUNK-3970: Error when adding a task in version 1.9.3
	 * https://tickets.openmrs.org/browse/TRUNK-3970
	 */
	@Test
	public void addANewTaskShouldNotError() throws Exception {
		HttpServletRequest request = new MockHttpServletRequest("GET", "/openmrs/admin/scheduler/scheduler.form");
		ModelAndView mav = controller.handleRequest(request, new MockHttpServletResponse());
		assertNotNull(mav);
	}
	
}