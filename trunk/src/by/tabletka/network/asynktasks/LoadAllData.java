package by.tabletka.network.asynktasks;

import by.tabletka.db.DataBase;
import by.tabletka.network.ApiHelper;
import android.os.AsyncTask;

public class LoadAllData extends AsyncTask<Void, Void, Void> {

	private DataBase dataBase;
	private long time;

	public LoadAllData(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	public LoadAllData(DataBase dataBase, long seconds) {
		this.dataBase = dataBase;
		time = seconds;
	}

	@Override
	protected Void doInBackground(Void... params) {
		ApiHelper.loadData(dataBase, time);
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		dataBase.close();
	}

}
