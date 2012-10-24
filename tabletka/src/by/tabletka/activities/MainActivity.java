package by.tabletka.activities;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import by.tabletka.R;
import by.tabletka.app.App;
import by.tabletka.db.DataBase;
import by.tabletka.network.asynktasks.LoadAllData;
import by.tabletka.network.asynktasks.OnSuccessAsyncTask;

public class MainActivity extends Activity implements OnSuccessAsyncTask {

	private ArrayList<String> regionsName;

	private Spinner spinner;
	private DataBase dataBase = new DataBase(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		insertDB();
		setContentView(R.layout.activity_main);

		spinner = (Spinner) findViewById(R.id.spinner);
		EditText name = (EditText) findViewById(R.id.enter_name);
		Button search = (Button) findViewById(R.id.search);

	}

	private void initSpinner() {
		dataBase.open();
		regionsName = dataBase.getRegionsNames();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regionsName);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setPrompt("Ваш регион");
		dataBase.close();
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				
			}

			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
	}

	public void insertDB() {
		SharedPreferences prefs = getSharedPreferences(App.PREFS_NAME, 0);
		SharedPreferences.Editor editor = prefs.edit();
		if (!prefs.getBoolean("isLoad", false)) {
			new LoadAllData(this, (OnSuccessAsyncTask) this, true, dataBase, 0).execute(null);
			editor.putBoolean("isLoad", true);
			editor.commit();
		} else {
			Date date = new Date();
			new LoadAllData(this, (OnSuccessAsyncTask) this, false, dataBase, date.getTime()).execute(null);
		}
	}

	public void onSuccessAsyncTask(Object resultObject) {
//		dataBase.close();
		initSpinner();
	}
}
