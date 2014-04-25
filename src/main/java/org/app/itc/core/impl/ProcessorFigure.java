package org.app.itc.core.impl;

import org.app.itc.core.model.IGetArea;
import org.springframework.stereotype.Service;
/**
 * Class processor of figures
 * 
 * @author ogarkov_sa
 * @since 16.04.2014
 *
 */
@Service
public class ProcessorFigure {
	
	public Double  calculateArea(IGetArea figure) {
		return figure.calculation();
	}
	
}
