package app.itc.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.itc.core.CalculatorType;
import app.itc.model.AjaxResponse;
import app.itc.service.PointCalculatorService;

/**
 * Web service restfull
 * 
 * @author ogarkov_sa
 * @since 17.04.2014
 *
 */
@Controller
public class PointController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

	@Autowired
	private PointCalculatorService pointCalculatorService;

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
	public @ResponseBody AjaxResponse calculateAreaPoint(@RequestParam String points, @RequestParam CalculatorType type) {
		LOGGER.info("Method process service");
		return pointCalculatorService.calculatePointArea(type, points);
	}

}
