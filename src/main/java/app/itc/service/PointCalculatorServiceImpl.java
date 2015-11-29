package app.itc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.itc.core.Area;
import app.itc.core.Calculator;
import app.itc.core.FigureType;
import app.itc.core.TypeFactory;
import app.itc.exception.ValidationException;
import app.itc.model.AjaxResponse;

/**
 * Class need for work with services
 * 
 * @author ogarkov_sa
 * @since 17.04.2014
 *
 */
@Service
public class PointCalculatorServiceImpl implements PointCalculatorService {

	@Autowired
	private TypeFactory typeFactory;

	@Autowired
	private Calculator calculator;

	@Override
	public AjaxResponse calculatePointArea(FigureType type, String points) {
		Area point = typeFactory.getFigure(type);
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			point.takeFigure(points);
			ajaxResponse.setData(calculator.calculateArea(point));
		} catch (ValidationException e) {
			ajaxResponse.setError(e.getMessage());
		} catch (Exception e) {
			ajaxResponse.setError(e.getMessage());
		}
		return ajaxResponse;
	}
}
