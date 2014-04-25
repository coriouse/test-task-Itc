package org.app.itc.core.impl;

import org.app.itc.core.model.Circle;
import org.app.itc.core.model.IGetArea;
import org.app.itc.core.model.Points;
import org.app.itc.core.model.Square;
import org.springframework.stereotype.Service;


/**
 * Fabric of figure
 * @author ogarkov_sa
 * @since 14.04.2014
 */
@Service
public class TypeFactory {
	
	/**
	 * Get of figure;
	 * @author ogarkov_sa
	 * @since 14.04.2014
	 * @param figure
	 * @return type figure object
	 */
	public IGetArea getFigure(String type) {
		if(type == null) {
			return null;
		}
		if("CIRCLE".equals(type)) {
			return new Circle();
		} else if("SQUARE".equals(type)) {		
			return new Square();
		} else if("POINT".equals(type)) {
			return new Points();
		} else {
			return null;
		}
	}
}
