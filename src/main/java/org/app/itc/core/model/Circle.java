package org.app.itc.core.model;

import java.util.Arrays;

import org.app.itc.core.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class discribe Circle
 * 
 * @author ogarkov_sa
 * @since 14.04.2014
 *
 */
public class Circle extends Figure implements IGetArea {

	private static final Logger logger = LoggerFactory.getLogger(Circle.class);

	private Integer radius;

	private Integer easting;

	private Integer northing;

	/**
	 * fill object Circle
	 * 
	 * @author ogarkov_sa
	 * @throws ValidationException
	 * @since 14.04.2014 example CIRCLE; 4711; BUILDING 1; 7; 30; 50
	 */
	private void fill() throws ValidationException {
		logger.info("fill object Circle");
		try {
			setName(getArrStringElement(0));
			setId(getArrNumberElement(1));
			setDescription(getArrStringElement(2));
			radius = getArrNumberElement(3);
			easting = getArrNumberElement(4);
			northing = getArrNumberElement(5);
		} catch (NumberFormatException e) {
			logger.error("Problem with format : " + Arrays.toString(getArr()));
			throw new ValidationException(
					"Problem with format : " + Arrays.toString(getArr()) + ", " + e.getClass().getName());
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("Problem with format : " + Arrays.toString(getArr()) + ", " + e.getClass().getName());
			throw new ValidationException("Problem with format  : " + Arrays.toString(getArr()));
		}
	}

	@Override
	public void importCulc(String figure) throws ValidationException {
		this.init(figure);
		this.fill();
	}

	@Override
	public Double calculate() {
		double r = this.radius;
		return Math.PI * r * r;
	}

	public Integer getRadius() {
		return radius;
	}

	public Integer getEasting() {
		return easting;
	}

	public Integer getNorthing() {
		return northing;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", easting=" + easting + ", northing=" + northing + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + ", getName()=" + getName() + "]";
	}

}
