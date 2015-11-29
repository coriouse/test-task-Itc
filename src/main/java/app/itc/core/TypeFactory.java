package app.itc.core;

import org.springframework.stereotype.Component;
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
@Component
public class TypeFactory {

	/**
	 * Get of figure;
	 * 
	 * @author ogarkov_sa
	 * @since 14.04.2014
	 * @param figure
	 * @return type figure object
	 */
	public Area getFigure(FigureType type) {

		switch (type) {
		case CIRCLE:
			return new Circle();
		case SQUARE:
			return new Square();
		case POINT:
			return new Points();
		default:
			return null;
		}
	}
}
