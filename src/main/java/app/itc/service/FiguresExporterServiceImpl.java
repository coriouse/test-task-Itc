package app.itc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import app.itc.core.CalculatorArea;
import app.itc.core.Calculator;
import app.itc.core.FiguresHolder;
import app.itc.exception.ValidationException;
import app.itc.model.Figure;

@Service
public class FiguresExporterServiceImpl implements FiguresExporterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FiguresExporterServiceImpl.class);

	@Autowired
	private FiguresHolder figuresHolder;


	/**
	 * Method return CSV file
	 * 
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @param figures
	 * @return
	 * @throws ValidationException
	 */
	@Override
	public byte[] exportToCsvFile(String type) throws ValidationException {

		List<CalculatorArea> csvList = new ArrayList<CalculatorArea>();
		for (CalculatorArea ig : figuresHolder.getFigures()) {
			Figure f = (Figure) ig;
			if (f.getName().equals(type)) {
				csvList.add(ig);
			}
		}
		if (csvList.size() == 0) {
			throw new ValidationException("Data is empty " + type);
		}

		StringBuffer sb = null;
		if (csvList != null) {
			sb = new StringBuffer();
			for (CalculatorArea ga : csvList) {
				Figure f = (Figure) ga;
				sb.append(f.getName());
				sb.append(";");
				sb.append(f.getId());
				sb.append(";");
				sb.append(ga.calculate());
				sb.append("\r\n");
			}
		}
		return sb.toString().getBytes();
	}

	/**
	 * Method return json file
	 * 
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @param figures
	 * @return
	 * @throws ValidationException
	 */
	public byte[] exportToJsonFile(String type) throws ValidationException {

		List<CalculatorArea> jsonList = new ArrayList<CalculatorArea>();
		for (CalculatorArea ig : figuresHolder.getFigures()) {
			Figure f = (Figure) ig;
			if (f.getName().equals(type)) {
				jsonList.add(ig);
			}
		}
		if (jsonList.size() == 0) {
			throw new ValidationException("Data is empty " + type);
		}

		String strJson = null;
		if (jsonList != null) {
			Gson json = new Gson();
			strJson = json.toJson(jsonList);
		}
		return strJson.getBytes();
	}
}
