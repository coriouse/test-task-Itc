package org.app.itc.core.model;

import org.app.itc.core.exception.ValidationException;



/**
 * Action under figure
 * @author ogarkov_sa
 * @since 14.04.2014
 *
 */
public interface IGetArea {
	
	/**
	 * Import of calculation in csv
	 * @author ogarkov_sa
	 * @since 14.04.2014
	 * @return byte[] - stream of byte for get file 
	 */
	public void importCulc(String figure) throws ValidationException;
	
	
	/**
	 * Calculate area result to file
	 * @author ogarkov_sa
	 * @since 14.04.2014	 
	 */
	public Double calculation(); 
	
	
}
