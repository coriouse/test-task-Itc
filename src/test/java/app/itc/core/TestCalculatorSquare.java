package app.itc.core;

import static org.junit.Assert.*;

import org.junit.Test;

import app.itc.calculator.SquareCalculator;
import app.itc.exception.ValidationException;

/**
 * Test validation for Square object
 * 
 * @author ogarkov_sa
 * @since 15.04.2014
 */
public class TestCalculatorSquare {

	@Test
	public void testFigureSquare() {
		// 1 normal
		String testFigure1 = "SQUARE;	4712;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		CalculatorArea square1 = new SquareCalculator();
		int count = 0;
		try {
			square1.put(testFigure1);
		} catch (ValidationException e) {
			count++;
		}

		assertTrue("1 Square Validation is normal", count == 0);

		// 2 id is not valid
		String testFigure2 = "SQUARE;	471dsd2;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		CalculatorArea square2 = new SquareCalculator();
		count = 0;
		try {
			square2.put(testFigure2);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("2 Square Validation id is not valid", count > 0);

		// 3 id is empty
		String testFigure3 = "SQUARE; ;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		CalculatorArea square3 = new SquareCalculator();
		count = 0;
		try {
			square3.put(testFigure3);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("3 Square Validation  id is empty", count > 0);

		// 4 description is epmty
		String testFigure4 = "SQUARE;	4712; ;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		CalculatorArea square4 = new SquareCalculator();
		count = 0;
		try {
			square4.put(testFigure4);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("4 Square Validation description is epmty ", count == 0);

		// 5 point is not valid
		String testFigure5 = "SQUARE;	4712; BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.sr0;	h0.0";
		CalculatorArea square5 = new SquareCalculator();
		count = 0;
		try {
			square5.put(testFigure5);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("5 Square Validation point is not valid  ", count > 0);

		// 6 data is not full
		String testFigure6 = "SQUARE;	4712";
		CalculatorArea square6 = new SquareCalculator();
		count = 0;
		try {
			square6.put(testFigure6);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("6 Square Validation data is not full", count > 0);

		// 7 is not coordinate
		String testFigure7 = "SQUARE;	4712;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0";
		CalculatorArea square7 = new SquareCalculator();
		count = 0;
		try {
			square6.put(testFigure7);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("7 Square Validation is not coordinate", count > 0);

	}

}
