package app.itc.action;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import app.itc.service.FigureHolderService;

/**
 * Main controller
 * 
 * @author Sergey Ogarkov
 */
@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private FigureHolderService figureHolderService;

	/**
	 * Show main page and clean list of figures
	 * 
	 * @author Sergey Ogarkov
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMain(Locale locale, Model model) {
		LOGGER.info("Start main page");
		figureHolderService.clean();
		return "index";
	}

	/**
	 * Page for test service
	 * 
	 * @author Sergey Ogarkov
	 * 
	 */
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String getService(Locale locale, Model model) {
		LOGGER.info("Open page for test service");
		return "service";
	}
}
