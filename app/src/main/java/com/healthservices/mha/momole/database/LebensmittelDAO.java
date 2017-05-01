package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.healthservices.mha.momole.database.model.Lebensmittel;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by manji on 26.04.2017.
 */

public class LebensmittelDAO {

    // columns of the lebensmittel table
    public static final String TBL_LM = "lebensmittel";
    public static final String TBL_LM_ID = "id";
    public static final String TBL_LM_TIME = "time";
    public static final String TBL_LM_DESCRIPTION = "des";
    public static final String TBL_LM_LACTOSE = "lac";
    public static final String TBL_LM_GLUTEN = "glu";
    public static final String TBL_LM_FRUCTOSE = "fru";
    public static final String TBL_LM_HISTAMIN = "his";

    //sql statement of the lebensmittel table
    public static final String CREATE_TBL_LM = "CREATE TBL " + TBL_LM + "("
            + TBL_LM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_LM_TIME + " INTEGER NOT NULL, "
            + TBL_LM_DESCRIPTION + " TEXT, "
            + TBL_LM_LACTOSE + " TEXT, "
            + TBL_LM_GLUTEN + " TEXT, "
            + TBL_LM_FRUCTOSE + " TEXT, "
            + TBL_LM_HISTAMIN + " TEXT "
            + ");";

    private static LebensmittelDAO instance;
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static LebensmittelDAO getInstance(Context context){
        if (instance == null){
            instance = new LebensmittelDAO(context);
        }
        return instance;
    }

    private LebensmittelDAO(Context context){

        dbHelper = DBHelper.getInstance(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){

        dbHelper.close();
    }

    public void onCreate(SQLiteDatabase database){

        database.execSQL(CREATE_TBL_LM);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

    }

    public List<Lebensmittel> getAllLebensmittelAfter(long timestamp) {
        open();
        Cursor cursor = database.query(TBL_LM, //Table
                new String[] {TBL_LM_ID, TBL_LM_DESCRIPTION, TBL_LM_LACTOSE, TBL_LM_GLUTEN, TBL_LM_FRUCTOSE, TBL_LM_HISTAMIN, TBL_LM_TIME}, //Fields, null would also return all columns / fields
                TBL_LM_TIME + ">=" + timestamp, //Selection, can't do >= with selection arguments
                null, //Selection arguments (replaces ? in Selection)
                null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                null, //Having, Selection on Group By fields (HAVING [field]=1)
                null, //Limit, limits the selection, e. g. 10 for 10 entries
                TBL_LM_TIME + " ASC"); //Order by timestamp, ascending
        List<Lebensmittel> lebensmittel = new LinkedList<>();
        if (cursor.moveToFirst()) { // read in the the result row by row, if data available
            while (!cursor.isAfterLast()) {
                lebensmittel.add(readFromCursor(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return lebensmittel;
    }

    public Lebensmittel getLebensmittel(long id) {
        open();
        Cursor cursor = database.query(TBL_LM, //Table
                null, //null returns all columns / fields
                TBL_LM_ID + "=?", //Selection (WHERE [field]=?)
                new String[]{String.valueOf(id)}, //Selection arguments (selection by id)
                null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                null, //Having, Selection on Group By fields (HAVING [field]=1)
                null, //Limit, limits the selection, e. g. 10 for 10 entries
                null); //CancelationSignal
        if (cursor.moveToFirst()) { //if data is available
            return readFromCursor(cursor); //read the data
        }
        cursor.close();
        close();
        return null;
    }

    public List<Lebensmittel> getAllLebensmittel() {
        open();

        Cursor cursor = database.query(TBL_LM, //Table
                new String[]{TBL_LM_ID, TBL_LM_TIME, TBL_LM_DESCRIPTION, TBL_LM_LACTOSE, TBL_LM_GLUTEN, TBL_LM_FRUCTOSE, TBL_LM_HISTAMIN}, //Fields, null would also return all columns / fields
                null, //Selection (WHERE [field]=?)
                null, //Selection arguments (replaces ? in Selection)
                null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                null, //Having, Selection on Group By fields (HAVING [field]=1)
                null, //Limit, limits the selection, e. g. 10 for 10 entries
                null); //CancelationSignal

        List<Lebensmittel> lebensmittel = new LinkedList<>();
        if (cursor.moveToFirst()) { // read in the the result row by row, if data available
            while (!cursor.isAfterLast()) {
                lebensmittel.add(readFromCursor(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return lebensmittel;
    }


    public long addLebensmittel(Lebensmittel lebensmittel) {
        open();
        long ret = database.insert(TBL_LM, null, prepareValues(lebensmittel));
        if (ret > 0) {
            lebensmittel.setId(ret);
        }
        close();
        return ret;
    }

    public int updateLebensmittel(Lebensmittel lebensmittel) {
        open();
        int ret = database.update(TBL_LM, //Table
                prepareValues(lebensmittel), //Values
                TBL_LM_ID + "=?", //Selection (what data to update)
                new String[]{String.valueOf(lebensmittel.getId())}); // selection by id
        close();
        return ret;
    }

    public int deleteLebensmittel(Lebensmittel lebensmittel) {
        open();
        int ret = database.delete(TBL_LM,
                TBL_LM_ID + "=?", //Selection (what data to delete)
                new String[]{String.valueOf(lebensmittel.getId())}); // selection by id
        close();
        return ret;
    }

    private ContentValues prepareValues(Lebensmittel lebensmittel) {
        ContentValues contentValues = new ContentValues();

        if (lebensmittel.getId() > 0)
            contentValues.put(TBL_LM_ID, lebensmittel.getId());

        contentValues.put(TBL_LM_DESCRIPTION, lebensmittel.getDes());
        contentValues.put(TBL_LM_TIME, lebensmittel.getTime());
        contentValues.put(TBL_LM_LACTOSE, lebensmittel.getLac());
        contentValues.put(TBL_LM_GLUTEN, lebensmittel.getGlu());
        contentValues.put(TBL_LM_FRUCTOSE, lebensmittel.getFru());
        contentValues.put(TBL_LM_HISTAMIN, lebensmittel.getHis());

        return contentValues;
    }

    private Lebensmittel readFromCursor(Cursor cursor) {
        Lebensmittel lebensmittel = new Lebensmittel();

        int index = cursor.getColumnIndex(TBL_LM_ID);
        lebensmittel.setId(cursor.getLong(index));

        index = cursor.getColumnIndex(TBL_LM_TIME);
        lebensmittel.setTime(cursor.getLong(index));

        index = cursor.getColumnIndex(TBL_LM_DESCRIPTION);
        lebensmittel.setDes(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_LACTOSE);
        lebensmittel.setLac(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_GLUTEN);
        lebensmittel.setGlu(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_FRUCTOSE);
        lebensmittel.setFru(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_HISTAMIN);
        lebensmittel.setHis(cursor.getString(index));

        return lebensmittel;
    }
}
