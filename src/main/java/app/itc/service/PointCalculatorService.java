package app.itc.service;

import app.itc.core.FigureType;
import app.itc.model.AjaxResponse;

public interface PointCalculatorService {

	public AjaxResponse calculatePointArea(FigureType type, String points);

}
