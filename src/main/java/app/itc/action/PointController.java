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
 * REST service of calculation point area
 * 
 * @author Sergey Ogarkov
 *
 */
@Controller
public class PointController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

	@Autowired
	private PointCalculatorService pointCalculatorService;

	/**
	 * REST distribute method of calculation area point
	 * 
	 * @author Sergey Ogarkov
	 * @param points
	 * @param type
	 */
	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public @ResponseBody AjaxResponse calculateAreaPoint(@RequestParam String points,
			@RequestParam CalculatorType type) {
		LOGGER.info("Method process service");
		return pointCalculatorService.calculatePointArea(type, points);
	}

}
