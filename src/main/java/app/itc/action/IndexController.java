package app.itc.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.itc.core.Area;
import app.itc.exception.ValidationException;
import app.itc.model.Figure;
import app.itc.service.FigureHolderService;

/**
 * Main controller
 * 
 * @author ogarkov_sa
 * @since 15.04.2014
 */
@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private FigureHolderService figureHolderService;

	/**
	 * Start page
	 * 
	 * @author ogarkov_sa
	 * @since 15.04.2014
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Start main page");
		figureHolderService.clean();
		return "home";
	}

	/**
	 * Page for test service
	 * 
	 * @author ogarkov_sa
	 * @since 17.04.2014
	 * 
	 */
	@RequestMapping(value = "/testService", method = RequestMethod.GET)
	public String serviceTest(Locale locale, Model model) {
		LOGGER.info("Page for test service");
		return "service";
	}
}
