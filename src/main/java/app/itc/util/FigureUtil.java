package app.itc.util;

public class FigureUtil {

	public static Integer getInteger(String[] parsedParams, Integer index) throws NumberFormatException {
		return Integer.valueOf(parsedParams[index].trim());
	}

	public static Float getFloat(String[] parsedParams, Integer index) throws NumberFormatException {
		return Float.valueOf(parsedParams[index].trim());
	}

	public static String getString(String[] parsedParams, Integer index) {
		return parsedParams[index].trim();
	}

}
