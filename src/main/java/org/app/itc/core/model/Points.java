package org.app.itc.core.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;






import org.app.itc.core.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Points implements IGetArea  {
	
	private static final Logger logger =  LoggerFactory.getLogger(Points.class);
	
	private double p1x;
	private double p1y;
	private double p1z;
	
	private double p2x;
	private double p2y;
	private double p2z;
	
	private Boolean validation(String xml) throws ValidationException {
		Boolean result = true;
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
		} catch (SAXParseException e) {
			result = false;
		} catch (SAXException e) {
			result = false;
		}
		return result;
	}

	@Override
	public void importCulc(String xml) throws ValidationException {
		validation(xml);
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder  = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
			XPathExpression expr = null;
			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();
		
			expr =  xpath.compile("//point[@id='a']/x/text()");		
			this.p1x =  Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
		
			expr =  xpath.compile("//point[@id='a']/y/text()");		
			this.p1y =  Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
		
			expr =  xpath.compile("//point[@id='a']/z/text()");		
			this.p1z =  Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
		
			expr =  xpath.compile("//point[@id='b']/x/text()");		
			this.p2x =  Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
		
			expr =  xpath.compile("//point[@id='b']/y/text()");		
			this.p2y =  Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
			
			expr =  xpath.compile("//point[@id='b']/z/text()");		
			this.p2z =  Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
		
		} catch (Exception e) {
			logger.error("xml parse points", e);
		}
	}

	@Override
	public Double calculation() {
		//logger.info(toString());
		return Math.sqrt(
				 Math.pow((p2x-p1x),2.0)+
				 Math.pow((p2y-p1y),2.0)+
				 Math.pow((p2z-p1z),2.0)
				);
	}

	@Override
	public String toString() {
		return "Points [p1x=" + p1x + ", p1y=" + p1y + ", p1z=" + p1z
				+ ", p2x=" + p2x + ", p2y=" + p2y + ", p2z=" + p2z + "]";
	}
	
	
}
