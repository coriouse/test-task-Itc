package org.app.itc.core.impl;

import org.app.itc.core.exception.ValidationException;
import org.app.itc.core.model.IGetArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	private IGetArea point;
	
	public void setType(String type) {
		this.type = type;
	}
	
	/**Method get xml params
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
	 * Metho return result after calcilation
	 * @author ogarkov_sa
	 * @since 17.04.2014 
	 * @return
	 */
	public double result() {
		return  pf.calculateArea(point);
	}
}
