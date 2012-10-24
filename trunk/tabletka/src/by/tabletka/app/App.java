package by.tabletka.app;

import java.util.Date;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import by.tabletka.db.DataBase;
import by.tabletka.entities.Region;
import by.tabletka.network.asynktasks.LoadAllData;

public class App extends Application {

	// public static boolean isDataLoad = false;
	public static final String PREFS_NAME = "TABLETKA";

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public static void saveIntoShared(String selecting, Context context) {
//		Region region = DataBase.getRegionForName(selecting);
		SharedPreferences prefs = context.getSharedPreferences(App.PREFS_NAME, 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(Region.NAME, selecting);
		editor.commit();
	}

}
