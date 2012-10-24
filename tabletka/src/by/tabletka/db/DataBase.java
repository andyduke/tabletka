package by.tabletka.db;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import by.tabletka.entities.ApothecaryDetails;
import by.tabletka.entities.ApothecaryDetails;
import by.tabletka.entities.Region;

public class DataBase extends SQLiteOpenHelper {

	final static int DB_VESION = 2;
	final static String DB_NAME = "tabletka.sqlite3";
	public static String TABLE_APTK = "aptks";
	public static String TABLE_REGS = "regions";

	private final static String KEY_ID = "_id";
	public final static int ID_COLUMN = 0;
	public final static int ID_APT_COLUMN = 1;
	public final static int NAME_APT_COLUMN = 2;
	public final static int ADDRESS_APT_COLUMN = 3;
	public final static int PHONES_APT_COLUMN = 4;
	public final static int GEO_X_COLUMN = 5;
	public final static int GEO_Y_COLUMN = 6;
	public final static int REG_NUMBER_COLUMN = 7;
	public final static int REG_NAME_COLUMN = 8;
	public final static int MON_COLUMN = 9;
	public final static int TUE_COLUMN = 10;
	public final static int WED_COLUMN = 11;
	public final static int THU_COLUMN = 12;
	public final static int FRI_COLUMN = 13;
	public final static int SAT_COLUMN = 14;
	public final static int SUN_COLUMN = 15;

	public final static int REGION_ID_COLUMN = 1;
	public final static int REGION_NAME_COLUMN = 2;

	private SQLiteDatabase mDatabase;
//	private Cursor mCursor;
	private Context mContext;

	public DataBase(Context context) {
		super(context, DB_NAME, null, DB_VESION);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		final String CREATE_DB = "CREATE TABLE " + TABLE_APTK + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ ApothecaryDetails.ID_APT + " text, " + ApothecaryDetails.NAME_APT + " text, "
				+ ApothecaryDetails.ADDRESS_APT + " text, " + ApothecaryDetails.PHONES_APT + " text, "
				+ ApothecaryDetails.GEO_X + " text, " + ApothecaryDetails.GEO_Y + " text, "
				+ ApothecaryDetails.REG_NUMBER + " text, " + ApothecaryDetails.REG_NAME + " text, "
				+ ApothecaryDetails.TIME_WORK[0] + " text, " + ApothecaryDetails.TIME_WORK[1] + " text, "
				+ ApothecaryDetails.TIME_WORK[2] + " text, " + ApothecaryDetails.TIME_WORK[3] + " text, "
				+ ApothecaryDetails.TIME_WORK[4] + " text, " + ApothecaryDetails.TIME_WORK[5] + " text, "
				+ ApothecaryDetails.TIME_WORK[6] + " TEXT);";
		db.execSQL(CREATE_DB);

		final String CREATE_REG = "CREATE TABLE " + TABLE_REGS + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Region.ID + " text, " + Region.NAME + " TEXT);";
		db.execSQL(CREATE_REG);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_APTK);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGS);
		onCreate(db);
	}

	public void open() {
		try {

			if (mDatabase != null) {
				mDatabase.close();
			}

			mDatabase = new DataBase(mContext).getWritableDatabase();
		} catch (SQLException e) {
			Log.e(this.toString(), "Error while getting database");
			throw new Error("The end");
		}
	}

	public void close() {
		super.close();
		mDatabase.close();
//		if (mCursor != null && !mCursor.isClosed())
//			mCursor.close();
	}

	public long addApothecary(ApothecaryDetails apothecary) {

		ContentValues cv = new ContentValues();
		cv.put(ApothecaryDetails.ID_APT, apothecary.getIdApt());
		cv.put(ApothecaryDetails.NAME_APT, apothecary.getNameApt());
		cv.put(ApothecaryDetails.ADDRESS_APT, apothecary.getAddressApt());
		cv.put(ApothecaryDetails.PHONES_APT, apothecary.getPhones());
		cv.put(ApothecaryDetails.GEO_X, apothecary.getGeoX());
		cv.put(ApothecaryDetails.GEO_Y, apothecary.getGeoY());
		cv.put(ApothecaryDetails.REG_NUMBER, apothecary.getRegNumber());
		cv.put(ApothecaryDetails.REG_NAME, apothecary.getRegName());
		HashMap<String, String> timeWorks = apothecary.getTimeWork();
		cv.put(ApothecaryDetails.TIME_WORK[0], timeWorks.get(ApothecaryDetails.TIME_WORK[0]));
		cv.put(ApothecaryDetails.TIME_WORK[1], timeWorks.get(ApothecaryDetails.TIME_WORK[1]));
		cv.put(ApothecaryDetails.TIME_WORK[2], timeWorks.get(ApothecaryDetails.TIME_WORK[2]));
		cv.put(ApothecaryDetails.TIME_WORK[3], timeWorks.get(ApothecaryDetails.TIME_WORK[3]));
		cv.put(ApothecaryDetails.TIME_WORK[4], timeWorks.get(ApothecaryDetails.TIME_WORK[4]));
		cv.put(ApothecaryDetails.TIME_WORK[5], timeWorks.get(ApothecaryDetails.TIME_WORK[5]));
		cv.put(ApothecaryDetails.TIME_WORK[6], timeWorks.get(ApothecaryDetails.TIME_WORK[6]));

		long id = mDatabase.insert(TABLE_APTK, null, cv);

		Log.v("DataBase insert", "ApothecaryDetails " + apothecary.getIdApt() + " " + apothecary.getNameApt());
		return id;
	}

	public void updateApothecary(ApothecaryDetails apothecary) {

		ContentValues cv = new ContentValues();
		cv.put(ApothecaryDetails.NAME_APT, apothecary.getNameApt());
		cv.put(ApothecaryDetails.ADDRESS_APT, apothecary.getAddressApt());
		cv.put(ApothecaryDetails.PHONES_APT, apothecary.getPhones());
		cv.put(ApothecaryDetails.GEO_X, apothecary.getGeoX());
		cv.put(ApothecaryDetails.GEO_Y, apothecary.getGeoY());
		cv.put(ApothecaryDetails.REG_NUMBER, apothecary.getRegNumber());
		cv.put(ApothecaryDetails.REG_NAME, apothecary.getRegName());
		HashMap<String, String> timeWorks = apothecary.getTimeWork();
		cv.put(ApothecaryDetails.TIME_WORK[0], timeWorks.get(ApothecaryDetails.TIME_WORK[0]));
		cv.put(ApothecaryDetails.TIME_WORK[1], timeWorks.get(ApothecaryDetails.TIME_WORK[1]));
		cv.put(ApothecaryDetails.TIME_WORK[2], timeWorks.get(ApothecaryDetails.TIME_WORK[2]));
		cv.put(ApothecaryDetails.TIME_WORK[3], timeWorks.get(ApothecaryDetails.TIME_WORK[3]));
		cv.put(ApothecaryDetails.TIME_WORK[4], timeWorks.get(ApothecaryDetails.TIME_WORK[4]));
		cv.put(ApothecaryDetails.TIME_WORK[5], timeWorks.get(ApothecaryDetails.TIME_WORK[5]));
		cv.put(ApothecaryDetails.TIME_WORK[6], timeWorks.get(ApothecaryDetails.TIME_WORK[6]));

		mDatabase.update(TABLE_APTK, cv, ApothecaryDetails.ID_APT + "=?", new String[] { apothecary.getIdApt() });
	}

	public long addRegion(Region region) {
		ContentValues cv = new ContentValues();
		cv.put(Region.ID, region.getId());
		cv.put(Region.NAME, region.getName());

		long id = mDatabase.insert(TABLE_REGS, null, cv);
		Log.v("DataBase insert", "Region " + region.getId() + " " + region.getName());
		return id;
	}

	public ArrayList<String> getRegionsNames() {
		Cursor mCursor = mDatabase.query(TABLE_REGS, new String[] { Region.NAME }, null, null, null, null, KEY_ID);
		ArrayList<String> regs = new ArrayList<String>();
		mCursor.moveToFirst();
		regs.add(mCursor.getString(0));
		while (mCursor.moveToNext()) {
			regs.add(mCursor.getString(0));
		}
		mCursor.close();
		return regs;
	}
}
