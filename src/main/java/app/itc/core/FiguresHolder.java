package app.itc.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FiguresHolder {

	private static final Logger LOGGER = LoggerFactory.getLogger(FiguresHolder.class);

	private static final List<CalculatorArea> FIGURES = new ArrayList<CalculatorArea>();

	public List<CalculatorArea> getFigures() {
		return FIGURES;
	}

	public void addFigure(CalculatorArea area) {
		FIGURES.add(area);

	}

	public void clean() {
		FIGURES.clear();

	}

}
