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

	private void putFigure(String params) throws ValidationException {
		CalculatorArea f = calculatorFactory.getCalculator(getCalculatorType(params));
		f.put(params);
		figuresHolder.addFigure(f);
	}

	private CalculatorType getCalculatorType(String params) throws ValidationException {
		String type = params.split(";")[0];
		try {
			return CalculatorType.valueOf(type);
		} catch (IllegalArgumentException e) {
			throw new ValidationException(String.format("Unknow type figure %", type));
		}
	}
}
