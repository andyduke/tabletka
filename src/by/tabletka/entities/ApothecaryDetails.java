package by.tabletka.entities;

import java.util.HashMap;


public class ApothecaryDetails {
	
	public static final String ID_APT = "USR_NUM";
	public static final String NAME_APT = "USR_NAME";
	public static final String ADDRESS_APT = "USR_ADR";
	public static final String PHONES_APT = "PHONES";
	public static final String GEO_X = "GEO_X";
	public static final String GEO_Y = "GEO_Y";
	public static final String WEB = "WEB";
	public static final String[] TIME_WORK = new String[] {"mon","tue","wed","thu","fri","sat","san"};	
	public static final String REG_NUMBER = "REG_NUM";
	public static final String REG_NAME = "REG_NAME";
	
	private String idApt;
	private String nameApt;
	private String addressApt;
	private String phones;
	private String geoX;
	private String geoY;
	private String web;
	private HashMap<String, String> timeWork;
	private String regName;
	private String regNumber;
	
	
	public ApothecaryDetails() {
		super();
	}

	public ApothecaryDetails(String idApt, String nameApt, String addressApt,
			String phones, String geoX, String geoY, String web,
			HashMap<String, String> timeWork, String regName, String regNumber) {
		super();
		this.idApt = idApt;
		this.nameApt = nameApt;
		this.addressApt = addressApt;
		this.phones = phones;
		this.geoX = geoX;
		this.geoY = geoY;
		this.web = web;
		this.timeWork = timeWork;
		this.regName = regName;
		this.regNumber = regNumber;
	}

	public String getIdApt() {
		return idApt;
	}

	public void setIdApt(String idApt) {
		this.idApt = idApt;
	}

	public String getNameApt() {
		return nameApt;
	}

	public void setNameApt(String nameApt) {
		this.nameApt = nameApt;
	}

	public String getAddressApt() {
		return addressApt;
	}

	public void setAddressApt(String addressApt) {
		this.addressApt = addressApt;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public HashMap<String, String> getTimeWork() {
		return timeWork;
	}

	public void setTimeWork(HashMap<String, String> timeWork) {
		this.timeWork = timeWork;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
}
