package app.itc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.itc.core.CalculatorArea;
import app.itc.core.Calculator;
import app.itc.core.CalculatorType;
import app.itc.core.CalculatorFactory;
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
	private CalculatorFactory calculatorFactory;

	@Override
	public AjaxResponse calculatePointArea(CalculatorType type, String points) {
		CalculatorArea point = calculatorFactory.getCalculator(type);
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			point.put(points);
			ajaxResponse.setData(point.calculate());
		} catch (ValidationException e) {
			ajaxResponse.setError(e.getMessage());
		} catch (Exception e) {
			ajaxResponse.setError(e.getMessage());
		}
		return ajaxResponse;
	}
}
