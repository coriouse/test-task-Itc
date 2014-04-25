package org.app.itc.core.model;

import java.util.Arrays;

import org.app.itc.core.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class discribe Square
 * @author ogarkov_sa
 * @since 15.04.2014
 *
 */
public class Square extends Figure implements IGetArea  {
	
	private static final Logger logger = LoggerFactory.getLogger(Square.class);
	
	private float[] coordinates = new float[8];
	
	/**
	 * fill object Square
	 * @author ogarkov_sa
	 * @since 14.04.2014
	 * example SQUARE;	4712;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0
	 */
	private void fill() throws ValidationException {
		try {
			setName(getArrStringElement(0));
			setId(getArrNumberElement(1));
			setDescription(getArrStringElement(2));
			int count = 0;
			for(int j = 3;j<getArr().length;j++) {
				coordinates[count] = Float.valueOf(getArr()[j].trim());
				count++;
			}
			if(count != 8) {
				throw new ValidationException("Problem with format is not coordinate : "+Arrays.toString(getArr()));
			}
		} catch(NumberFormatException e) {
			logger.error("Problem with format : "+Arrays.toString(getArr()));
			throw new ValidationException("Problem with format : "+Arrays.toString(getArr()));
		} catch(ArrayIndexOutOfBoundsException e) {
			logger.error("Problem with format : "+Arrays.toString(getArr()));
			throw new ValidationException("Problem with format  : "+Arrays.toString(getArr()));
		}		
	}	
	
	public float[] getCoordinates() {
		return coordinates;
	}
 

	@Override
	public void importCulc(String figure) throws ValidationException  {	
		this.init(figure);
		this.fill();
	}

	@Override
	public Double calculation() {
		double a = Math.sqrt(
				 Math.pow((coordinates[2]-coordinates[0]),2.0)+
				 Math.pow((coordinates[3]-coordinates[1]),2.0)
				);
		double b = Math.sqrt(
	 			Math.pow((coordinates[4]-coordinates[2]),2.0)+
	 			Math.pow((coordinates[5]-coordinates[3]),2.0)
				);
		return a*b;
	}

	@Override
	public String toString() {
		return "Square, coordinates="
				+ Arrays.toString(coordinates) + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + ", getName()="
				+ getName() + "]";
	}
}
