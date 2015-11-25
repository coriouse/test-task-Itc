package app.itc.core;

import static org.junit.Assert.*;

import org.junit.Test;

import app.itc.exception.ValidationException;
import app.itc.model.Circle;

/**
 * Test validation for Circle object
 * 
 * @author ogarkov_sa
 * @since 15.04.2014
 */
public class TestCircle {

	@Test
	public void testFigureCircle() {

		// 1 normal
		String testFigure1 = "CIRCLE; 4711; BUILDING 1; 7; 30; 50";
		Area square1 = new Circle();
		int count = 0;
		try {
			square1.importCulc(testFigure1);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("1 Circle Validation is normal", count == 0);

		// 2 id is not valid
		String testFigure2 = "CIRCLE; 4sw711; BUILDING 1; 7; 30; 50";
		Area square2 = new Circle();
		count = 0;
		try {
			square2.importCulc(testFigure2);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("2 Circle Validation id is not valid", count > 0);

		// 3 id is empty
		String testFigure3 = "CIRCLE;; BUILDING 1; 7; 30; 50";
		Area square3 = new Circle();
		count = 0;
		try {
			square3.importCulc(testFigure3);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("3 Circle Validation  id is empty", count > 0);

		// 4 description is epmty
		String testFigure4 = "CIRCLE; 4711; ; 7; 30; 50";
		Area square4 = new Circle();
		count = 0;
		try {
			square4.importCulc(testFigure4);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("4 Circle Validation description is epmty ", count == 0);

		// 5 description is epmty
		String testFigure5 = "CIRCLE; 4711; BUILDING; 7; 30; 50";
		Area square5 = new Circle();
		count = 0;
		try {
			square5.importCulc(testFigure5);
		} catch (ValidationException e) {
			count++;
		}
		assertTrue("4 Circle Validation description is epmty ", count == 0);

	}

}
