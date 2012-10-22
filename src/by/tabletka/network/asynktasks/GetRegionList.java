package by.tabletka.network.asynktasks;

import java.util.ArrayList;

import android.content.Context;
import by.tabletka.entities.BasicResponse;
import by.tabletka.entities.Region;
import by.tabletka.network.ApiHelper;

public class GetRegionList extends BasicAsynkTask<ArrayList<Region>> {

	private Context contex;

	public GetRegionList(Context context, boolean isShow) {
		super(context, isShow);
		this.contex = context;
	}
	
	@Override
	protected BasicResponse<ArrayList<Region>> doInBackground(String... params) {
		return ApiHelper.getRegionList();
	}
	
	@Override
	protected void onPostExecute(BasicResponse<ArrayList<Region>> result) {
		super.onPostExecute(result);
	}

}
