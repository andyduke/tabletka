package by.tabletka.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import by.tabletka.entities.BasicResponse;
import by.tabletka.entities.Region;

import android.util.Log;

public class ApiHelper {

	private static final String NAME_HOST = "http://tabletka.by/api/tab.api.php?";
	
	public static BasicResponse<Region> getRegionList() {
		HashMap<String, String> params = new HashMap<String, String>();
		String actionUrl = NAME_HOST + "regions.reglist";
		
		return null;
	}

	private static String buildUrl(HashMap<String, String> params,
			String urlMethod) {
		StringBuilder sb = new StringBuilder(urlMethod);
		sb.append("={");
		Iterator<String> keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			sb.append('"' + key).append('"' + ':' + '"')
					.append(params.get(key));
			if (keys.hasNext())
				sb.append('"' + ',');
		}
		Log.v("buildurl", sb.toString());
		return sb.toString();
	}

	// GET
	private static JSONObject sendRequest(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse httpresp = null;
		InputStream is = null;
		try {
			httpresp = httpClient.execute(httpget);
			is = httpresp.getEntity().getContent();
			String st = convertStreamToString(is);
			JSONObject root = new JSONObject(st);
			return root;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

	}

	private static String convertStreamToString(InputStream is) {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			Log.v("streamstring", sb.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Log.v("streamstring", sb.toString());
		return sb.toString();
	}

}
