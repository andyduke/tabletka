package by.tabletka.entities;

public class Preparation {
	
	public static final String ID = "ls_num";
	public static final String NAME = "ls_name";
	public static final String FORM = "tar_name";
	public static final String FIRMA = "firm_name";
	public static final String COUNTRY = "country_name";
	public static final String NEED_RECIPE = "otc_rx";
	public static final String MNN_NAME = "nlec_name";
	public static final String MAX_PRICE = "price_max";
	public static final String APT_COUNT = "apt_cnt";
	
	
	private String id;
	private String name;
	private String form;
	private String firma;
	private String country;
	private String needRecipe;
	private String mnnName;
	private String maxPrice;
	private String aptCoont;
	
	
	
	public Preparation() {
		super();
	}

	public Preparation(String id, String name, String form, String firma,
			String country, String needRecipe, String mnnName, String maxPrice,
			String aptCoont) {
		super();
		this.id = id;
		this.name = name;
		this.form = form;
		this.firma = firma;
		this.country = country;
		this.needRecipe = needRecipe;
		this.mnnName = mnnName;
		this.maxPrice = maxPrice;
		this.aptCoont = aptCoont;
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

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNeedRecipe() {
		return needRecipe;
	}

	public void setNeedRecipe(String needRecipe) {
		this.needRecipe = needRecipe;
	}

	public String getMnnName() {
		return mnnName;
	}

	public void setMnnName(String mnnName) {
		this.mnnName = mnnName;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getAptCoont() {
		return aptCoont;
	}

	public void setAptCoont(String aptCoont) {
		this.aptCoont = aptCoont;
	}
	
}
