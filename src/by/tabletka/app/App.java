package by.tabletka.app;

import java.util.Date;

import android.app.Application;
import android.content.Context;
import by.tabletka.db.DataBase;
import by.tabletka.network.asynktasks.LoadAllData;

public class App extends Application {

	private static boolean isDataLoad = false;

	@Override
	public void onCreate() {
		super.onCreate();
		insertDB(getApplicationContext());
	}

	public static void insertDB(Context context) {
		DataBase dataBase = new DataBase(context);
		dataBase.open();
		if (!isDataLoad) {
			new LoadAllData(dataBase).execute(null);
			isDataLoad = true;
		}else {
			Date date = new Date();
			 new LoadAllData(dataBase, date.getSeconds()).execute(null);
		}
	}

}
