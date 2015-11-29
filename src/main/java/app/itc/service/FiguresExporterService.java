package app.itc.service;

import app.itc.exception.ValidationException;

public interface FiguresExporterService {

	public byte[] exportToCsvFile(String type) throws ValidationException;

	public byte[] exportToJsonFile(String type) throws ValidationException;

}
