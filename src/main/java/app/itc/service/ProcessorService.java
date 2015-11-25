package app.itc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.itc.core.Area;
import app.itc.core.ProcessorFigure;
import app.itc.core.TypeFactory;
import app.itc.exception.ValidationException;

/**
 * Class need for work with services
 * 
 * @author ogarkov_sa
 * @since 17.04.2014
 *
 */
@Service
public class ProcessorService {

	private String type;

	@Autowired
	private TypeFactory typeFactory;

	@Autowired
	private ProcessorFigure pf;

	private Area point;

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method get xml params
	 * 
	 * @author ogarkov_sa
	 * @since 17.04.2014
	 * @param xml
	 * @throws ValidationException
	 */
	public void putService(String xml) throws ValidationException {
		point = typeFactory.getFigure(type);
		point.importCulc(xml);
	}

	/**
	 * Method return result after calculation
	 * 
	 * @author ogarkov_sa
	 * @since 17.04.2014
	 * @return
	 */
	public double result() {
		return pf.calculateArea(point);
	}
}
