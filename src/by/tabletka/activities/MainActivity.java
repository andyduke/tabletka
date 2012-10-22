package by.tabletka.activities;

import java.util.ArrayList;

import by.tabletka.R;
import by.tabletka.db.DataBase;
import by.tabletka.network.asynktasks.GetRegionList;
import by.tabletka.network.asynktasks.SearchPreparation;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private ArrayList<String> regionsName;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DataBase dataBase = new DataBase(this);

		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		initSpinner(spinner, dataBase);
		EditText name = (EditText) findViewById(R.id.enter_name);
		Button search = (Button) findViewById(R.id.search);

	}

	private void initSpinner(Spinner spinner, DataBase dataBase) {
		dataBase.open();
		regionsName = dataBase.getRegionsNames();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regionsName);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	}
}
