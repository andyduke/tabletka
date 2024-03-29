package by.tabletka.network.asynktasks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.util.Log;
import by.tabletka.dialogs.DialogForAsyncTask;
import by.tabletka.entities.BasicResponse;

public class BasicAsynkTask<T> extends
		AsyncTask<String, Void, BasicResponse<T>> {

	private Context mContext;
	private boolean isDialogShow;
	private DialogForAsyncTask dialog;

	public BasicAsynkTask(Context context, boolean isShow) {
		mContext = context;
		isDialogShow = isShow;
	}

	@Override
	protected void onPreExecute() {
		dialog = new DialogForAsyncTask(mContext);
		if (!isInternetConnection()) {
			dialog.showServerMessage("Internet connection not available");
		} else if (isDialogShow) {
			dialog.show();
			super.onPreExecute();
		} else {
			super.onPreExecute();
		}
	}

	@Override
	protected BasicResponse<T> doInBackground(String... params) {
		return null;
	}

	@Override
	protected void onPostExecute(BasicResponse<T> result) {
		if (isDialogShow)
			dialog.dismiss();
		chekProcessError(result);
	}

	protected void chekProcessError(BasicResponse<T> result) {
		if (result.getCodeResult() != 0) {
			switch (result.getCodeResult()) {
			case 500:
				Log.v("Response", "500 ok");
				break;
			case 550:
				dialog.showServerMessage("��������! ����� �� �������� ������������� �� ��� �����������, ��� ���������� ����� �� ���");
				Log.v("Response", "550 MNN");
				break;
			case 501:
				dialog.showServerMessage("Me���� 3� ����");
				Log.v("Response", "501 < 3 ��������");
				break;
			case 504:
				dialog.showServerMessage("� ����������� �� ������� ������������ (������ �� �������).");
				Log.v("Response", "504 not found");
				break;
			case 505:
				dialog.showServerMessage("��� ��������� � ��������� �������.������ � ������?");
				Log.v("Response", "505 not found in region");
				break;
			case 555:
				dialog.showServerMessage("���������� ����� �� ��� (�������), ����� �������������, �� � ������ ������� ���������� � �������� ��� (��������) ���. ������ � ������ ��������?");
				Log.v("Response", "555 not found in region");
				break;
			case 100:
				dialog.showServerMessage("������ �������. ���������� ��� ���");
				Log.v("Response", "100 other error");
				break;

			default:
				break;
			}
		}
	}

	public boolean isInternetConnection() {
		ConnectivityManager conMgr = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conMgr.getActiveNetworkInfo() != null
				&& conMgr.getActiveNetworkInfo().isAvailable()
				&& conMgr.getActiveNetworkInfo().isConnected()) {
			return true;
		} else {
			Log.v("ic", "Internet connection not present");
			return false;
		}
	}

}
