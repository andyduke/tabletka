package by.tabletka.entities;

import java.util.ArrayList;

public class Apothecary {

	public static final String ID_REGION = "REG_NUM";
	public static final String NAME_REGION = "REG_NAME";
	public static final String ID = "USR_NUM";
	public static final String NAME = "USR_NAME";
	public static final String ADDRESS = "USR_ADR";
	public static final String PHONES = "PHONES";
	public static final String GEO_X = "GEO_X";
	public static final String GEO_Y = "GEO_Y";
	public static final String ID_PREP = "LS_NUM";
	public static final String PRICE_PREP = "LS_PRICE";
	public static final String COUNT_PREP = "LS_CNT";
	public static final String DATE = "LS_DATE";
	public static final String TIME = "LS_TIME";
	
	private String idRegion;
	private String nameRegion;
	private String id;
	private String name;
	private String address;
	private ArrayList<String> phones;
	private String geoX;
	private String geoY;
	private String idPreparation;
	private String pricePreparation;
	private String countPreparation;
	private String date;
	private String time;

	public Apothecary() {
		super();
	}

	public Apothecary(String idRegion, String nameRegion, String id,
			String name, String address, ArrayList<String> phones, String geoX,
			String geoY, String idPreparation, String pricePreparation,
			String countPreparation, String date, String time) {
		super();
		this.idRegion = idRegion;
		this.nameRegion = nameRegion;
		this.id = id;
		this.name = name;
		this.address = address;
		this.phones = phones;
		this.geoX = geoX;
		this.geoY = geoY;
		this.idPreparation = idPreparation;
		this.pricePreparation = pricePreparation;
		this.countPreparation = countPreparation;
		this.date = date;
		this.time = time;
	}

	public String getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<String> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<String> phones) {
		this.phones = phones;
	}

	public String getGeoX() {
		return geoX;
	}

	public void setGeoX(String geoX) {
		this.geoX = geoX;
	}

	public String getGeoY() {
		return geoY;
	}

	public void setGeoY(String geoY) {
		this.geoY = geoY;
	}

	public String getIdPreparation() {
		return idPreparation;
	}

	public void setIdPreparation(String idPreparation) {
		this.idPreparation = idPreparation;
	}

	public String getPricePreparation() {
		return pricePreparation;
	}

	public void setPricePreparation(String pricePreparation) {
		this.pricePreparation = pricePreparation;
	}

	public String getCountPreparation() {
		return countPreparation;
	}

	public void setCountPreparation(String countPreparation) {
		this.countPreparation = countPreparation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
