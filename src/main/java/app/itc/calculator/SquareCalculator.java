package app.itc.calculator;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.itc.core.CalculatorArea;
import app.itc.exception.ValidationException;
import app.itc.model.Figure;
import app.itc.util.FigureUtil;

/**
 * Calculator of square figure
 * 
 * @author Sergey Ogarkov
 * @since 15.04.2014
 *
 */
public class SquareCalculator extends Figure implements CalculatorArea {

	private static final Logger LOGGER = LoggerFactory.getLogger(SquareCalculator.class);

	private float[] coordinates = new float[8];

	/**
	 * fill object Square
	 * 
	 * @author Sergey Ogarkov
	 * @since 14.04.2014 example SQUARE; 4712; BUILDING 3; 0.0; 0.0; 0.0; 10.0;
	 *        10.0; 10.0; 10.0; 0.0
	 */
	private void fill() throws ValidationException {
		try {
			setName(FigureUtil.getString(getParsedParams(), 0));
			setId(FigureUtil.getInteger(getParsedParams(), 1));
			setDescription(FigureUtil.getString(getParsedParams(), 2));
			int count = 0;
			for (int j = 3; j < getParsedParams().length; j++) {
				coordinates[count] = FigureUtil.getFloat(getParsedParams(), j);
				count++;
			}
			if (count != 8) {
				throw new ValidationException(
						String.format("Invalid format %s figure Square : ", Arrays.toString(getParsedParams())));
			}
		} catch (NumberFormatException e) {
			LOGGER.error(String.format("Invalid format %s figure Square : ", Arrays.toString(getParsedParams())));
			throw new ValidationException(
					String.format("Invalid format %s figure Square : ", Arrays.toString(getParsedParams())));
		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error(String.format("Invalid format %s figure Square : ", Arrays.toString(getParsedParams())));
			throw new ValidationException(
					String.format("Invalid format %s figure Square : ", Arrays.toString(getParsedParams())));
		}
	}

	public float[] getCoordinates() {
		return coordinates;
	}

	@Override
	public void put(String figure) throws ValidationException {
		this.parse(figure);
		this.fill();
	}

	@Override
	public Double calculate() {
		double a = Math.sqrt(
				Math.pow((coordinates[2] - coordinates[0]), 2.0) + Math.pow((coordinates[3] - coordinates[1]), 2.0));
		double b = Math.sqrt(
				Math.pow((coordinates[4] - coordinates[2]), 2.0) + Math.pow((coordinates[5] - coordinates[3]), 2.0));
		return a * b;
	}

	@Override
	public String toString() {
		return "Square, coordinates=" + Arrays.toString(coordinates) + ", getId()=" + getId() + ", getDescription()="
				+ getDescription() + ", getName()=" + getName() + "]";
	}
}
