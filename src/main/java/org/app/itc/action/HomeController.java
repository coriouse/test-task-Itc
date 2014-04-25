package org.app.itc.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.app.itc.core.exception.ValidationException;
import org.app.itc.core.impl.FileAgregator;
import org.app.itc.core.model.Figure;
import org.app.itc.core.model.IGetArea;
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

/**
 * Main controller
 * @author ogarkov_sa
 * @since 15.04.2014 
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//list of figures
	private List<IGetArea> figures = null;
	
	@Autowired
	FileAgregator fa;
	
	/**
	 * Start page
	 * @author ogarkov_sa
	 * @since 15.04.2014 
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Start main page");
		//is need for crete new list, cause list of figure stored only in memory
		if(figures != null) {
			figures.clear();
		}	
		return "home";
	}
	
	
	/**
	 * Processing of the data file
	 * @param request
	 * @author ogarkov_sa
	 * @since 16.04.2014 
	 * @throws IOException
	 * @throws ValidationException
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String upload(HttpServletRequest request ) throws IOException, ValidationException {	  
		logger.info("Processing of the data file");
		InputStream inputStream = request.getInputStream();
		fa.readFileFromPage(inputStream);
		figures =  fa.getFigures();	
		inputStream.close();
		request.setAttribute("figures",figures);
		request.setAttribute("combobox", fa.getListTypeFigures());
		return "list";
	}
	
	/**
	 * Method fo create csv file 
	 * @param type of figure
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @return
	 * @throws IOException
	 * @throws ValidationException
	 */
	@RequestMapping(value = "/csv", method = RequestMethod.GET)	
	public ResponseEntity<byte[]>  getCsvFile(@RequestParam String type) throws IOException, ValidationException {
		logger.info("Method fo create csv file");
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/csv");
		headers.add("Content-disposition","attachment; filename=figures.csv");
		
		List<IGetArea>  csvList = new ArrayList<IGetArea>(); 	
		for(IGetArea ig :  figures) {
		  Figure f = (Figure)ig;
		  if(f.getName().equals(type)) {
			  csvList.add(ig);
		  }
		}
		if(csvList.size() == 0) {
			throw new ValidationException("Data is empty "+type);
		}
		return new ResponseEntity<byte[]>(fa.createCsvFile(csvList) , headers, HttpStatus.CREATED);
	}
	
	/**
	 * Method fo create json file 
	 * @param type of figure
	 * @author ogarkov_sa
	 * @since 17.04.2014
	 * @return
	 * @throws IOException
	 * @throws ValidationException
	 */
	@RequestMapping(value = "/json", method = RequestMethod.GET)	
	public ResponseEntity<byte[]>  getJsonFile(@RequestParam String type) throws IOException, ValidationException {
		logger.info("Method fo create json file");
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/json");
		headers.add("Content-disposition","attachment; filename=figures.json");
		
		List<IGetArea>  jsonList = new ArrayList<IGetArea>(); 	
		for(IGetArea ig :  figures) {
		  Figure f = (Figure)ig;
		  if(f.getName().equals(type)) {
			  jsonList.add(ig);
		  }
		}
		if(jsonList.size() == 0) {
			throw new ValidationException("Data is empty "+type);
		}
		return new ResponseEntity<byte[]>(fa.createJsonFile(jsonList) , headers, HttpStatus.CREATED);
	}
	
	/**
	 * Page for test service
	 * @author ogarkov_sa
	 * @since 17.04.2014 
	 * 
	 */
	@RequestMapping(value = "/testService", method = RequestMethod.GET)
	public String serviceTest(Locale locale, Model model) {
		logger.info("Page for test service");
		return "service";
	}
}
