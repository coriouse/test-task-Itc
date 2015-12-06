package app.itc.service;

import app.itc.core.CalculatorType;
import app.itc.model.AjaxResponse;
/**
 * Service calculate point area
 * 
 * @author Sergey Ogarkov
 *
 */
public interface PointCalculatorService {

	public AjaxResponse calculatePointArea(CalculatorType type, String points);

}
