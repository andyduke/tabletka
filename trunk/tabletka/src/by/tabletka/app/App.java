package by.tabletka.app;

import java.util.Date;

import android.app.Application;
import android.content.Context;
import by.tabletka.db.DataBase;
import by.tabletka.network.asynktasks.LoadAllData;

public class App extends Application {

//	public static boolean isDataLoad = false;
	public static final String PREFS_NAME = "TABLETKA";

	@Override
	public void onCreate() {
		super.onCreate();
	}


}
