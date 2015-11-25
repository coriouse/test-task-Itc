package app.itc.model;

/**
 * Base class for all figures
 * 
 * @author ogarkov_sa
 * @since 14.04.2014
 *
 */
abstract public class Figure {

	private String description;

	private Integer id;

	private String name;

	private String[] arr;

	public void init(String params) {
		if (params != null) {
			arr = params.split(";");
		}
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

	public String[] getArr() {
		return arr;
	}

	public Integer getArrNumberElement(Integer index) throws NumberFormatException {
		return Integer.valueOf(arr[index].trim());
	}

	public String getArrStringElement(Integer index) {
		return arr[index].trim();
	}
}
