package app.itc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.itc.exception.ValidationException;
import app.itc.service.FiguresExporterService;

/**
 * Controller of exporting figures to csv, json
 * 
 * @author Sergey Ogarkov
 *
 */
@Controller
public class ExporterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExporterController.class);

	private FiguresExporterService figuresExporterService;

	/**
	 * Method fo create csv file
	 * 
	 * @param type
	 *            of figure
	 * @throws IOException
	 * @throws ValidationException
	 */
	@RequestMapping(value = "/csv", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getCsvFile(@RequestParam String type) throws IOException, ValidationException {
		LOGGER.info("Method fo create csv file");
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/csv");
		headers.add("Content-disposition", "attachment; filename=figures.csv");
		return new ResponseEntity<byte[]>(figuresExporterService.exportToCsvFile(type), headers, HttpStatus.CREATED);
	}

	/**
	 * Return json file
	 * 
	 * @param type
	 *            of figure	
	 * @throws IOException
	 * @throws ValidationException
	 */
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getJsonFile(@RequestParam String type) throws IOException, ValidationException {
		LOGGER.info("Method fo create json file");
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json");
		headers.add("Content-disposition", "attachment; filename=figures.json");
		return new ResponseEntity<byte[]>(figuresExporterService.exportToJsonFile(type), headers, HttpStatus.CREATED);
	}

}
