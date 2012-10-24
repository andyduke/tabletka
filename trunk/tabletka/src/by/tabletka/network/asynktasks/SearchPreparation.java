package by.tabletka.network.asynktasks;

import java.util.ArrayList;

import android.content.Context;
import by.tabletka.entities.BasicResponse;
import by.tabletka.entities.Preparation;
import by.tabletka.network.ApiHelper;

public class SearchPreparation extends BasicAsynkTask<ArrayList<Preparation>> {

	private Context contex;

	public SearchPreparation(Context context, OnSuccessAsyncTask onSuccessAsyncTask, boolean isShow) {
		super(context, onSuccessAsyncTask, isShow);
		this.contex = context;
	}

	@Override
	protected BasicResponse<ArrayList<Preparation>> doInBackground(String... params) {
		return ApiHelper.searchPreparation(params[0], params[1]);
	}

	@Override
	protected void onSuccess(OnSuccessAsyncTask successAsyncTask) {
		// TODO Auto-generated method stub
		
	}

}
