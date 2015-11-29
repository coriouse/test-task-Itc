package app.itc.service;

import java.io.InputStream;
import java.util.List;

import app.itc.core.Area;
import app.itc.exception.ValidationException;

public interface FigureHolderService {
	
	
	List<Area> getFigures();
	
	void addFiguresFromFile(InputStream inputStream)  throws ValidationException ;	
	
	void clean();

}
