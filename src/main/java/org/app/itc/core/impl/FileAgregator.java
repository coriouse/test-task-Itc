package org.app.itc.core.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.app.itc.core.exception.ValidationException;
import org.app.itc.core.model.Figure;
import org.app.itc.core.model.FigureType;
import org.app.itc.core.model.IGetArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * Class handle of data file
 * 
 * @author ogarkov_sa
 * @since 14.04.2014
 * 
 */
@Service
public class FileAgregator {

	private static final Logger logger = LoggerFactory.getLogger(FileAgregator.class);

	private List<IGetArea> figures;

	@Autowired
	private TypeFactory typeFactory;

	@Autowired
	private ProcessorFigure pf;

	/**
	 * Init FileAgregator class
	 * 
	 */
	public FileAgregator() {
		figures = new LinkedList<IGetArea>();
	}

	/**
	 * Method get stream from clients
	 * 
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @param is
	 * @throws ValidationException
	 * @throws IOException
	 */
	public void readFileFromPage(InputStream is) throws ValidationException, IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				putFigure(line);
			}
		} finally {
			try {
				reader.close();
				is.close();
			} catch (IOException ex) {
				logger.error("Erroe of closing");
			}
		}
	}

	/**
	 * Method read file
	 * 
	 * @author ogarkov_sa
	 * @since 14.04.2014
	 * 
	 * @throws ValidationException
	 */
	public void readFileData() throws ValidationException {
		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			fis = new FileInputStream("c:\\geo\\data.txt");
			reader = new BufferedReader(new InputStreamReader(fis));

			String line;
			while ((line = reader.readLine()) != null) {
				putFigure(line);
			}

		} catch (FileNotFoundException ex) {
			logger.error("File nor found");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				logger.error("Erroe of closing");
			}
		}
	}

	/**
	 * Method put figure to structure
	 * 
	 * @author ogarkov_as
	 * @since 14.04.2014
	 * @param figure
	 * @throws ValidationException
	 */
	public void putFigure(String figure) throws ValidationException {
		String type = figure.split(";")[0];
		if (isFigure(type)) {
			IGetArea f = typeFactory.getFigure(type);
			f.importCulc(figure);
			figures.add(f);
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
			FigureType.valueOf(figure);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public List<FigureType> getListTypeFigures() {
		return Arrays.asList(FigureType.values());
	}

	/**
	 * Method return list of objects
	 * 
	 * @author ogarkov_sa
	 * @since 15.04.2014
	 * @return
	 */
	public List<IGetArea> getFigures() {
		return figures;
	}

	public TypeFactory getTypeFactory() {
		return typeFactory;
	}

	/**
	 * Method return сsv fiile
	 * 
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @param figures
	 * @return
	 */
	public byte[] createCsvFile(List<IGetArea> figures) {
		StringBuffer sb = null;
		if (figures != null) {
			sb = new StringBuffer();
			for (IGetArea ga : figures) {
				Figure f = (Figure) ga;
				sb.append(f.getName());
				sb.append(";");
				sb.append(f.getId());
				sb.append(";");
				sb.append(pf.calculateArea(ga));
				sb.append("\r\n");
			}
		} else {
			logger.error("Figures is not found");
			throw new IllegalArgumentException("Figures is not found");
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
	 */
	public byte[] createJsonFile(List<IGetArea> figures) {
		String strJson = null;
		if (figures != null) {
			Gson json = new Gson();
			strJson = json.toJson(figures);
		} else {
			logger.error("Figures is not found");
			throw new IllegalArgumentException("Figures is not found");
		}
		return strJson.getBytes();
	}
}
