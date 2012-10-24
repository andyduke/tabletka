package by.tabletka.network.asynktasks;

import by.tabletka.db.DataBase;
import by.tabletka.entities.BasicResponse;
import by.tabletka.network.ApiHelper;
import android.content.Context;
import android.os.AsyncTask;

public class LoadAllData extends BasicAsynkTask<Object> {
	private DataBase dataBase;
	private long time;
	private Context context;

	public LoadAllData(Context context, OnSuccessAsyncTask onSuccessAsyncTask, boolean isShow, DataBase dataBase,
			long seconds) {
		super(context, onSuccessAsyncTask, isShow);
		this.context = context;
		time = seconds;
	}

	@Override
	protected BasicResponse<Object> doInBackground(String... params) {
		ApiHelper.loadData(time, context);
		return null;
	}

	@Override
	protected void onPostExecute(BasicResponse<Object> result) {
		super.onPostExecute(result);
	}

	@Override
	protected void onSuccess(OnSuccessAsyncTask successAsyncTask) {
		successAsyncTask.onSuccessAsyncTask(null);
	}

}
