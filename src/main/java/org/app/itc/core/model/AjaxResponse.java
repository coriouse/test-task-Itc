package org.app.itc.core.model;


/**
 * Class for answer ajax and services
 * 
 * @author ogarkov_sa
 * @since 17.04.2014
 *
 */
public class AjaxResponse {

	private Object data;

	private String[] errors;

	public AjaxResponse() {
		super();
	}

	public AjaxResponse(Object data, String[] errors) {
		super();
		this.data = data;
		this.errors = errors;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setErrors(String[] errors) {
		this.errors = errors;
	}

	public String[] getErrors() {
		return errors;
	}

	public void setError(String error) {
		this.errors = new String[]{error};
	}
}
