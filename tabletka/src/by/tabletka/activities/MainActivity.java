package by.tabletka.activities;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import by.tabletka.R;
import by.tabletka.app.App;
import by.tabletka.db.DataBase;
import by.tabletka.entities.Region;
import by.tabletka.network.asynktasks.LoadAllData;
import by.tabletka.network.asynktasks.OnSuccessAsyncTask;
import by.tabletka.network.asynktasks.SearchPreparation;

public class MainActivity extends Activity implements OnSuccessAsyncTask {

	private ArrayList<String> regionsName;
	private boolean isSelect;

	private Spinner spinner;
	private DataBase dataBase = new DataBase(this);
	private OnSuccessAsyncTask onSuccessAsyncTask = this;
	private String currentRegion;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		insertDB();
		setContentView(R.layout.activity_main);

		spinner = (Spinner) findViewById(R.id.spinner);
		final EditText name = (EditText) findViewById(R.id.enter_name);
		Button search = (Button) findViewById(R.id.search);
		search.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				String text = name.getText().toString();
				if (text.length() < 3)
					Toast.makeText(MainActivity.this, "Слишком короткий запрос. Введите не менее трех символов",
							Toast.LENGTH_LONG).show();
				else
					new SearchPreparation(MainActivity.this, onSuccessAsyncTask, true).execute(text,
							String.valueOf(DataBase.getRegionForName(currentRegion).getId()));

			}
		});

	}

	private void initSpinner() {
		int defNumb = getSelection();
		currentRegion = regionsName.get(defNumb);
		regionsName.add(0, currentRegion);
		regionsName.remove(defNumb + 1);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
				regionsName);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setPrompt("Ваш регион");
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

				if (isSelect) {
					currentRegion = adapter.getItem(position);
					App.saveIntoShared(currentRegion, MainActivity.this);
				} else {
					currentRegion = regionsName.get(getSelection());

					isSelect = true;
				}
			}

			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

	private int getSelection() {
		regionsName = dataBase.getRegionsNames();
		SharedPreferences prefs = getSharedPreferences(App.PREFS_NAME, 0);
		String name = prefs.getString(Region.NAME, "Минск");
		return regionsName.indexOf(name);
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
		initSpinner();
	}
}
