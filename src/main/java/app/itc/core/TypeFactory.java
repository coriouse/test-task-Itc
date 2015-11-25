package app.itc.core;

import org.springframework.stereotype.Service;

import app.itc.model.Circle;
import app.itc.model.Points;
import app.itc.model.Square;

/**
 * Fabric of figure
 * 
 * @author ogarkov_sa
 * @since 14.04.2014
 */
@Service
public class TypeFactory {

	/**
	 * Get of figure;
	 * 
	 * @author ogarkov_sa
	 * @since 14.04.2014
	 * @param figure
	 * @return type figure object
	 */
	public Area getFigure(String type) {
		if (type == null) {
			return null;
		}
		if ("CIRCLE".equals(type)) {
			return new Circle();
		} else if ("SQUARE".equals(type)) {
			return new Square();
		} else if ("POINT".equals(type)) {
			return new Points();
		} else {
			return null;
		}
	}
}
