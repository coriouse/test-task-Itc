package app.itc.validator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import app.itc.exception.ValidationException;

public class PointValidator {

	public static void validate(String xml) throws ValidationException {

		Source xmlFile = null;
		try {
			xmlFile = new StreamSource(new ByteArrayInputStream(xml.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Source schemaLocation = new StreamSource(new File("points.xsd"));
		try {
			Schema schema = schemaFactory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			try {
				validator.validate(xmlFile);
			} catch (IOException e) {
				throw new ValidationException("Problem with read xsd");
			}
		} catch (IllegalArgumentException e) {
			throw new ValidationException("XML is no valid:", e);
		} catch (SAXParseException e) {
			throw new ValidationException("Problem with parse xml", e);
		} catch (SAXException e) {
			throw new ValidationException("Problem with parse xml", e);
		}

	}

}
