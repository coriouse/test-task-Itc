package app.itc.core;

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

	public Double calculateArea(Area figure) {
		return figure.calculate();
	}

}
