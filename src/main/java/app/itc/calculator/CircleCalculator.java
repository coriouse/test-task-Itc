package app.itc.calculator;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.itc.core.CalculatorArea;
import app.itc.exception.ValidationException;
import app.itc.model.Figure;
import app.itc.util.FigureUtil;

/**
 * Class discribe Circle
 * 
 * @author Sergey Ogarkov
 * @since 14.04.2014
 *
 */
public class CircleCalculator extends Figure implements CalculatorArea {

	private static final Logger LOGGER = LoggerFactory.getLogger(CircleCalculator.class);

	private Integer radius;

	private Integer easting;

	private Integer northing;

	/**
	 * fill object Circle
	 * 
	 * @author Sergey Ogarkov
	 * @throws ValidationException
	 * @since 14.04.2014 example CIRCLE; 4711; BUILDING 1; 7; 30; 50
	 */
	private void fill() throws ValidationException {
		LOGGER.debug("Fill object Circle");
		try {
			setName(FigureUtil.getString(getParsedParams(), 0));
			setId(FigureUtil.getInteger(getParsedParams(), 1));
			setDescription(FigureUtil.getString(getParsedParams(), 2));
			radius = FigureUtil.getInteger(getParsedParams(), 3);
			easting = FigureUtil.getInteger(getParsedParams(), 4);
			northing = FigureUtil.getInteger(getParsedParams(), 5);
		} catch (NumberFormatException e) {
			LOGGER.error(String.format("Illegal argument : %s", Arrays.toString(getParsedParams())));
			throw new ValidationException(String.format("Illegal argument : %s", Arrays.toString(getParsedParams())),
					e);
		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error(String.format("Invalid format %s figure Circle : ", Arrays.toString(getParsedParams())));
			throw new ValidationException(
					String.format("Invalid format %s figure Circle : ", Arrays.toString(getParsedParams())));
		}
	}

	@Override
	public void put(String figure) throws ValidationException {
		this.parse(figure);
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
