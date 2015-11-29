package app.itc.model;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import app.itc.core.Area;
import app.itc.exception.ValidationException;
import app.itc.validator.PointValidator;

public class Points implements Area {

	private static final Logger LOGGER = LoggerFactory.getLogger(Points.class);

	private double p1x;
	private double p1y;
	private double p1z;

	private double p2x;
	private double p2y;
	private double p2z;



	@Override
	public void takeFigure(String xml) throws ValidationException {
		PointValidator.validate(xml);
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				factory.setNamespaceAware(true);
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
				XPathExpression expr = null;
				XPathFactory xFactory = XPathFactory.newInstance();
				XPath xpath = xFactory.newXPath();
	
				expr = xpath.compile("//point[@id='a']/x/text()");
				this.p1x = Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
	
				expr = xpath.compile("//point[@id='a']/y/text()");
				this.p1y = Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
	
				expr = xpath.compile("//point[@id='a']/z/text()");
				this.p1z = Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
	
				expr = xpath.compile("//point[@id='b']/x/text()");
				this.p2x = Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
	
				expr = xpath.compile("//point[@id='b']/y/text()");
				this.p2y = Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
	
				expr = xpath.compile("//point[@id='b']/z/text()");
				this.p2z = Double.valueOf((String) expr.evaluate(doc, XPathConstants.STRING));
	
			} catch (Exception e) {
				LOGGER.error("xml parse points", e);
			}
	
	}

	@Override
	public Double calculate() {	
		return Math.sqrt(Math.pow((p2x - p1x), 2.0) + Math.pow((p2y - p1y), 2.0) + Math.pow((p2z - p1z), 2.0));
	}

	@Override
	public String toString() {
		return "Points [p1x=" + p1x + ", p1y=" + p1y + ", p1z=" + p1z + ", p2x=" + p2x + ", p2y=" + p2y + ", p2z=" + p2z
				+ "]";
	}

}
