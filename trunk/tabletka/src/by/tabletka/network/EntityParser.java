package by.tabletka.network;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import by.tabletka.db.DataBase;
import by.tabletka.entities.ApothecaryDetails;
import by.tabletka.entities.BasicResponse;
import by.tabletka.entities.Preparation;
import by.tabletka.entities.Region;

public class EntityParser {

	private final static String RESPONSE = "response";
	private final static String APT_LIST = "aptlist";
	private final static String REG_LIST = "reglist";

	public static BasicResponse<ArrayList<Region>> getRegionList(JSONObject object) {
		BasicResponse<ArrayList<Region>> response = new BasicResponse<ArrayList<Region>>();
		JSONArray result;
		try {
			result = object.getJSONArray(RESPONSE);
			response.setResulData(getRegions(result));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response;
	}

	private static ArrayList<Region> getRegions(JSONArray result) throws JSONException {
		ArrayList<Region> regions = new ArrayList<Region>();

		for (int i = 0; i < result.length(); i++) {
			JSONObject msg = result.getJSONObject(i);
			regions.add(getRegion(msg));
		}
		return regions;
	}

	private static Region getRegion(JSONObject msg) throws JSONException {
		Region region = new Region();
		region.setId(msg.getString(Region.ID));
		region.setName(msg.getString(Region.NAME));
		return region;
	}

	public static BasicResponse<ArrayList<Preparation>> searchDrugs(JSONObject object) {
		BasicResponse<ArrayList<Preparation>> response = new BasicResponse<ArrayList<Preparation>>();
		JSONArray result;
		try {
			result = object.getJSONArray(RESPONSE);
			if (result != null && result.length() != 0) {
				response.setCodeResult(result.getInt(0));
				response.setResulData(getPreparations(result));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response;
	}

	private static ArrayList<Preparation> getPreparations(JSONArray result) throws JSONException {
		ArrayList<Preparation> preparations = new ArrayList<Preparation>();
		for (int i = 1; i < result.length(); i++) {
			JSONObject msg = result.getJSONObject(i);
			preparations.add(getPreparation(msg));
		}
		return preparations;
	}

	private static Preparation getPreparation(JSONObject msg) throws JSONException {
		Preparation preparation = new Preparation();
		preparation.setAptCoont(msg.getString(Preparation.APT_COUNT));
		preparation.setCountry(msg.getString(Preparation.COUNTRY));
		preparation.setFirma(msg.getString(Preparation.FIRMA));
		preparation.setForm(msg.getString(Preparation.FORM));
		preparation.setId(msg.getString(Preparation.ID));
		preparation.setMaxPrice(msg.getString(Preparation.MAX_PRICE));
		preparation.setMnnName(msg.getString(Preparation.MNN_NAME));
		preparation.setName(msg.getString(Preparation.NAME));
		preparation.setNeedRecipe(msg.getString(Preparation.NEED_RECIPE));
		return preparation;
	}

	public static void loadAll(JSONObject object, Context context) {
		DataBase dataBase = new DataBase(context);
		dataBase.open();
		try {
			JSONArray all = object.getJSONArray(RESPONSE);
			if (all.getJSONObject(0).get(APT_LIST).getClass() != Integer.class) {
				JSONArray aptks = all.getJSONObject(0).getJSONArray(APT_LIST);
				for (int i = 0; i < aptks.length(); i++) {
					ApothecaryDetails apothecaryDetails = getAptkDetails(aptks.getJSONObject(i));
					dataBase.addApothecary(apothecaryDetails);
				}
			}
			if (all.getJSONObject(1).get(REG_LIST).getClass() != Integer.class) {
				JSONArray regs = all.getJSONObject(1).getJSONArray(REG_LIST);
				for (int i = 0; i < regs.length(); i++) {
					Region region = getRegion(regs.getJSONObject(i));
					dataBase.addRegion(region);
				}
			}

			dataBase.close();
		} catch (JSONException e) {
			e.printStackTrace();
			dataBase.close();
		}
	}

	private static ApothecaryDetails getAptkDetails(JSONObject object) {
		ApothecaryDetails apothecaryDetails = new ApothecaryDetails();
		try {
			apothecaryDetails.setAddressApt(object.getString(ApothecaryDetails.ADDRESS_APT));
			apothecaryDetails.setGeoX(object.getString(ApothecaryDetails.GEO_X));
			apothecaryDetails.setGeoY(object.getString(ApothecaryDetails.GEO_Y));
			apothecaryDetails.setIdApt(object.getString(ApothecaryDetails.ID_APT));
			apothecaryDetails.setNameApt(object.getString(ApothecaryDetails.NAME_APT));
			apothecaryDetails.setPhones(object.getString(ApothecaryDetails.PHONES_APT));
			apothecaryDetails.setRegName(object.getString(ApothecaryDetails.REG_NAME));
			apothecaryDetails.setRegNumber(object.getString(ApothecaryDetails.REG_NUMBER));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(ApothecaryDetails.TIME_WORK[0], object.getString(ApothecaryDetails.TIME_WORK[0]));
			map.put(ApothecaryDetails.TIME_WORK[1], object.getString(ApothecaryDetails.TIME_WORK[1]));
			map.put(ApothecaryDetails.TIME_WORK[2], object.getString(ApothecaryDetails.TIME_WORK[2]));
			map.put(ApothecaryDetails.TIME_WORK[3], object.getString(ApothecaryDetails.TIME_WORK[3]));
			map.put(ApothecaryDetails.TIME_WORK[4], object.getString(ApothecaryDetails.TIME_WORK[4]));
			map.put(ApothecaryDetails.TIME_WORK[5], object.getString(ApothecaryDetails.TIME_WORK[5]));
			map.put(ApothecaryDetails.TIME_WORK[6], object.getString(ApothecaryDetails.TIME_WORK[6]));
			apothecaryDetails.setTimeWork(map);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return apothecaryDetails;
	}

}
