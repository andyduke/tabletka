package by.tabletka.dialogs;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class DialogForAsyncTask {

	private Context mContext;
	private ProgressDialog progressDialog;
	private AlertDialog alertDialog;

	public DialogForAsyncTask(Context context) {
		mContext = context;
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage("Please wait.....");
		progressDialog.setTitle("Loading...");
		progressDialog.setCancelable(false);
	}

	public void show() {
		progressDialog.show();
	}

	public void dismiss() {
		progressDialog.dismiss();
	}

	public void showServerMessage(String error) {

		progressDialog.dismiss();
		Builder dialog = new AlertDialog.Builder(mContext).setCancelable(false)
				.setMessage(error)
				.setPositiveButton("Ok", new OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		dialog.create().show();

	}

}
