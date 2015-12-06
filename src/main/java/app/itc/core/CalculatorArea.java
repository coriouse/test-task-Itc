package app.itc.core;

import app.itc.exception.ValidationException;

/**
 * Calculator figures, take figure and  calculate area
 * 
 * @author Sergey Ogarkov
 * @since 14.04.2014
 *
 */
public interface CalculatorArea {

	/**
	 * Method put figure for calculation 
	 * 
	 * @param figure
	 * @throws ValidationException
	 */
	public void put(String figure) throws ValidationException;

	/**
	 * Calculate area figure
	 * 
	 * @return calculated area
	 */
	public Double calculate();

}
