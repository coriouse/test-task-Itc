package app.itc.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import app.itc.core.CalculatorType;
import app.itc.exception.ValidationException;
import app.itc.service.FigureHolderService;

/**
 * @author Sergey Ogarkov
 *
 */
@Controller
public class UploadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

	@Autowired
	private FigureHolderService figureHolderService;

	/**
	 * Upload file
	 * 
	 * @param request
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @throws IOException
	 * @throws ValidationException
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String upload(HttpServletRequest request) throws IOException, ValidationException {
		LOGGER.info("Processing of the data file");
		figureHolderService.addFiguresFromFile(request.getInputStream());

		request.setAttribute("figures", figureHolderService.getFigures());
		request.setAttribute("combobox", referenceListTypeFigures());
		return "list";
	}

	private List<CalculatorType> referenceListTypeFigures() {
		return Arrays.asList(CalculatorType.values());
	}

}
