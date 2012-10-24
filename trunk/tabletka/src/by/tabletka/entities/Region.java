package by.tabletka.entities;

public class Region {

	public static final String ID = "reg_num";
	public static final String NAME = "region";

	private String id;
	private String name;

	public Region() {
		super();
	}

	public Region(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
