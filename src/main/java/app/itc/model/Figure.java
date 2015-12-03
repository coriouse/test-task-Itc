package app.itc.model;

/**
 * Base class for all figures
 * 
 * @author ogarkov_sa
 * @since 14.04.2014
 *
 */
abstract public class Figure {

	private Integer id;

	private String name;
	
	private String description;

	private static String[] parsedParams;

	public void parse(String textParams) {
		if (textParams != null) {
			parsedParams = textParams.split(";");
		}
	}

	public String[] getParsedParams() {
		return parsedParams;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
