package app.itc.core;

import org.springframework.stereotype.Component;
import app.itc.calculator.CircleCalculator;
import app.itc.calculator.PointsCalculator;
import app.itc.calculator.SquareCalculator;

/**
 * Factory of calculators
 * 
 * @author Sergey Ogarkov
 * @since 14.04.2014
 */
@Component
public class CalculatorFactory {

	public CalculatorArea getCalculator(CalculatorType calculatorType) {

		switch (calculatorType) {
		case CIRCLE:
			return new CircleCalculator();
		case SQUARE:
			return new SquareCalculator();
		case POINT:
			return new PointsCalculator();
		default:
			return null;
		}
	}
}
