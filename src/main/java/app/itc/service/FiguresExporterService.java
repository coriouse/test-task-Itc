package app.itc.service;

import app.itc.exception.ValidationException;

public interface FiguresExporterService {

	/**
	 * Method return CSV file
	 * 
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @param figures
	 * @return
	 * @throws ValidationException
	 */
	public byte[] exportToCsvFile(String type) throws ValidationException;

	/**
	 * Method return json file
	 * 
	 * @author ogarkov_sa
	 * @since 16.04.2014
	 * @param figures
	 * @return
	 * @throws ValidationException
	 */
	public byte[] exportToJsonFile(String type) throws ValidationException;

}
