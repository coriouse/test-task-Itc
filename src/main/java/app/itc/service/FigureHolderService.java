package app.itc.service;

import java.io.InputStream;
import java.util.List;

import app.itc.core.CalculatorArea;
import app.itc.exception.ValidationException;

public interface FigureHolderService {
	
	
	List<CalculatorArea> getFigures();
	
	void addFiguresFromFile(InputStream inputStream)  throws ValidationException ;	
	
	void clean();

}
