package app.itc.core;

import static org.junit.Assert.*;

import org.junit.Test;

import app.itc.exception.ValidationException;
import app.itc.model.Square;

/**
 * Test validation for Square object
 * 
 * @author ogarkov_sa
 * @since 15.04.2014
 */
public class TestSquare {

	@Test
	public void testFigureSquare() {
		// 1 normal
		String testFigure1 = "SQUARE;	4712;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		Area square1 = new Square();
		int count = 0;
		try {
			square1.takeFigure(testFigure1);
		} catch (ValidationException e) {
			count++;
		}

		assertTrue("1 Square Validation is normal", count == 0);

		// 2 id is not valid
		String testFigure2 = "SQUARE;	471dsd2;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		Area square2 = new Square();
		count = 0;
		try {
			square2.takeFigure(testFigure2);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("2 Square Validation id is not valid", count > 0);

		// 3 id is empty
		String testFigure3 = "SQUARE; ;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		Area square3 = new Square();
		count = 0;
		try {
			square3.takeFigure(testFigure3);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("3 Square Validation  id is empty", count > 0);

		// 4 description is epmty
		String testFigure4 = "SQUARE;	4712; ;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0;	0.0";
		Area square4 = new Square();
		count = 0;
		try {
			square4.takeFigure(testFigure4);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("4 Square Validation description is epmty ", count == 0);

		// 5 point is not valid
		String testFigure5 = "SQUARE;	4712; BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.sr0;	h0.0";
		Area square5 = new Square();
		count = 0;
		try {
			square5.takeFigure(testFigure5);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("5 Square Validation point is not valid  ", count > 0);

		// 6 data is not full
		String testFigure6 = "SQUARE;	4712";
		Area square6 = new Square();
		count = 0;
		try {
			square6.takeFigure(testFigure6);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("6 Square Validation data is not full", count > 0);

		// 7 is not coordinate
		String testFigure7 = "SQUARE;	4712;	BUILDING 3;	0.0;	0.0;	0.0;	10.0;	10.0;	10.0;	10.0";
		Area square7 = new Square();
		count = 0;
		try {
			square6.takeFigure(testFigure7);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("7 Square Validation is not coordinate", count > 0);

	}

}
