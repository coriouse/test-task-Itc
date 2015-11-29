package app.itc.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Class processor of figures
 * 
 * @author ogarkov_sa
 * @since 16.04.2014
 *
 */
@Component
public class Calculator {

	public Double calculateArea(Area figure) {
		return figure.calculate();
	}

}
