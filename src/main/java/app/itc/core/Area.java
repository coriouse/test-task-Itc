package app.itc.core;

import app.itc.exception.ValidationException;

/**
 * Action under figure
 * 
 * @author ogarkov_sa
 * @since 14.04.2014
 *
 */
public interface Area {

	public void takeFigure(String figure) throws ValidationException;

	public Double calculate();

}
