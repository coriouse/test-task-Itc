package org.app.itc.action;

import org.app.itc.core.exception.ValidationException;
import org.app.itc.core.impl.ProcessorService;
import org.app.itc.core.model.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Web service restfull
 * 
 * @author ogarkov_sa
 * @since 17.04.2014
 *
 */
@Controller
public class RestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

	@Autowired
	private ProcessorService ps;

	/**
	 * Method process service
	 * 
	 * @author ogarkov_sa
	 * @since 17.04.2014
	 * @param points
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public @ResponseBody AjaxResponse getPoint(@RequestParam String points, @RequestParam String type) {
		LOGGER.info("Method process service");
		ps.setType(type);
		AjaxResponse rep = new AjaxResponse();
		try {
			ps.putService(points);
			rep.setData(ps.result());
		} catch (ValidationException e) {
			rep.setError(e.getMessage());
		} catch (Exception e) {
			rep.setError(e.getMessage());
		}
		return rep;
	}

}
