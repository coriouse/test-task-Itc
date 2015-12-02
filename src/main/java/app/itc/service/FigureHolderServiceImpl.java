package app.itc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.itc.core.CalculatorArea;
import app.itc.core.CalculatorType;
import app.itc.core.FiguresHolder;
import app.itc.core.CalculatorFactory;
import app.itc.exception.ValidationException;

@Service
public class FigureHolderServiceImpl implements FigureHolderService {

	@Autowired
	private FiguresHolder figuresHolder;

	private static final Logger LOGGER = LoggerFactory.getLogger(FigureHolderServiceImpl.class);

	@Autowired
	private CalculatorFactory calculatorFactory;

	@Override
	public List<CalculatorArea> getFigures() {
		return figuresHolder.getFigures();
	}

	@Override
	public void clean() {
		figuresHolder.clean();

	}

	@Override
	public void addFiguresFromFile(InputStream inputStream) throws ValidationException {
		readFileFromPage(inputStream);

	}

	private void readFileFromPage(InputStream is) throws ValidationException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			String line;
			try {
				while ((line = reader.readLine()) != null) {
					putFigure(line);
				}
			} catch (IOException e) {				
				
			}
		} finally {
			try {
				reader.close();
				is.close();
			} catch (IOException ex) {
				LOGGER.error("Erroe of closing");
			}
		}
	}

	private void putFigure(String figure) throws ValidationException {
		String type = figure.split(";")[0];
		if (isFigure(type)) {
			CalculatorArea f = calculatorFactory.getCalculator(CalculatorType.valueOf(type));
			f.put(figure);
			figuresHolder.addFigure(f);
		}
	}

	/**
	 * Method check type of figure
	 * 
	 * @author ogarkov_sa
	 * @since 15.04.2014
	 * @param figure
	 * @return
	 */
	private Boolean isFigure(String figure) {
		try {
			CalculatorType.valueOf(figure);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

}
