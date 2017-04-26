package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import com.healthservices.mha.momole.database.model.Beschwerden;
import com.healthservices.mha.momole.database.model.Lebensmittel;
import com.healthservices.mha.momole.database.model.Notizen;

/**
 * Created by manji on 25.04.2017.
 */

public class BeschwerdenDAO {

    // columns of the Beschwerden table
    public static final String TBL_B = "beschwerden";
    public static final String TBL_B_ID = "id";
    public static final String TBL_B_TIME = "time";
    public static final String TBL_B_DESCRIPTION = "des";
    public static final String TBL_B_DIGESTIVPBL = "dige";
    public static final String TBL_B_HEADACHE = "head";
    public static final String TBL_B_SKINPBL = "skin";
    public static final String TBL_B_RESPIDISTRESS = "resp";
    public static final String TBL_B_FEVER = "fev";

    //sql statement of the beschwerden table
    public static final String CREATE_TBL_B = "CREATE TBL " + TBL_B + "("
            + TBL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_B_TIME + " INTEGER NOT NULL, "
            + TBL_B_DESCRIPTION + " TEXT, "
            + TBL_B_DIGESTIVPBL + " TEXT, "
            + TBL_B_HEADACHE + " TEXT, "
            + TBL_B_SKINPBL + " TEXT, "
            + TBL_B_RESPIDISTRESS + " TEXT, "
            + TBL_B_FEVER + " TEXT "
            + ");";

    private static BeschwerdenDAO instance;
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static BeschwerdenDAO getInstance(Context context){
        if (instance == null){
            instance = new BeschwerdenDAO(context);
        }
        return instance;
    }

    private BeschwerdenDAO(Context context){
        dbHelper = DBHelper.getInstance(context);
    }

    public void open() throws SQLException {
         database = dbHelper.getWritableDatabase();

    }

    public void close(){
        dbHelper.close();
    }

    public void onCreate(SQLiteDatabase database){
        database.execSQL(CREATE_TBL_B);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

    }

    public Beschwerden getBeschwerden(long id) {
        open();
        Cursor cursor = database.query(TBL_B, //Table
                null, //null returns all columns / fields
                TBL_B_ID + "=?", //Selection (WHERE [field]=?)
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

    public List<Beschwerden> getAllBeschwerdenAfter(long timestamp) {
        open();
        Cursor cursor = database.query(TBL_B, //Table
                new String[] {TBL_B_ID, TBL_B_DESCRIPTION, TBL_B_DIGESTIVPBL, TBL_B_HEADACHE, TBL_B_SKINPBL, TBL_B_RESPIDISTRESS, TBL_B_FEVER, TBL_B_TIME}, //Fields, null would also return all columns / fields
                TBL_B_TIME + ">=" + timestamp, //Selection, can't do >= with selection arguments
                null, //Selection arguments (replaces ? in Selection)
                null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                null, //Having, Selection on Group By fields (HAVING [field]=1)
                null, //Limit, limits the selection, e. g. 10 for 10 entries
                TBL_B_TIME + " ASC"); //Order by timestamp, ascending
        List<Beschwerden> beschwerden = new LinkedList<>();
        if (cursor.moveToFirst()) { // read in the the result row by row, if data available
            while (!cursor.isAfterLast()) {
                beschwerden.add(readFromCursor(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return beschwerden;
    }

    public List<Beschwerden> getAllBeschwerden() {
        open();

        Cursor cursor = database.query(TBL_B, //Table
                new String[] {TBL_B_ID, TBL_B_TIME, TBL_B_DESCRIPTION, TBL_B_DIGESTIVPBL, TBL_B_HEADACHE, TBL_B_SKINPBL, TBL_B_RESPIDISTRESS, TBL_B_FEVER}, //Fields, null would also return all columns / fields
                null, //Selection (WHERE [field]=?)
                null, //Selection arguments (replaces ? in Selection)
                null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                null, //Having, Selection on Group By fields (HAVING [field]=1)
                null, //Limit, limits the selection, e. g. 10 for 10 entries
                null); //CancelationSignal

        List<Beschwerden> beschwerden = new LinkedList<>();
        if (cursor.moveToFirst()) { // read in the the result row by row, if data available
            while (!cursor.isAfterLast()) {
                beschwerden.add(readFromCursor(cursor));
                cursor.moveToNext();
            }
        }

        public long addBeschwerden(Beschwerden beschwerden) {
            open();
            long ret = database.insert(TBL_B, null, prepareValues(beschwerden));
            if (ret > 0) {
                beschwerden.setId(ret);
            }
            close();
            return ret;
        }

        public int updateBeschwerden(Beschwerden beschwerden) {
            open();
            int ret = database.update(TBL_B, //Table
                    prepareValues(beschwerden), //Values
                    TBL_B_ID + "=?", //Selection (what data to update)
                    new String[]{String.valueOf(beschwerden.getId())}); // selection by id
            close();
            return ret;
        }

        public int deleteBeschwerden(Beschwerden beschwerden) {
            open();
            int ret = database.delete(TBL_B,
                    TBL_B_ID + "=?", //Selection (what data to delete)
                    new String[]{String.valueOf(beschwerden.getId())}); // selection by id
            close();
            return ret;
        }

        private ContentValues prepareValues(Beschwerden beschwerden) {
            ContentValues contentValues = new ContentValues();

            if (beschwerden.getId() > 0)
                contentValues.put(TBL_B_ID, beschwerden.getId());

            contentValues.put(TBL_B_DESCRIPTION, beschwerden.getDes());
            contentValues.put(TBL_B_TIME, beschwerden.getTime());
            contentValues.put(TBL_B_DIGESTIVPBL, beschwerden.getDige());
            contentValues.put(TBL_B_HEADACHE, beschwerden.getHead());
            contentValues.put(TBL_B_SKINPBL, beschwerden.getSkin());
            contentValues.put(TBL_B_RESPIDISTRESS, beschwerden.getResp());
            contentValues.put(TBL_B_FEVER, beschwerden.getFev());

            return contentValues;
        }

        private Beschwerden readFromCursor(Cursor cursor) {
            Beschwerden beschwerden = new Beschwerden();

            int index = cursor.getColumnIndex(TBL_B_ID);
            beschwerden.setId(cursor.getLong(index));

            index = cursor.getColumnIndex(TBL_B_TIME);
            beschwerden.setTime(cursor.getLong(index));

            index = cursor.getColumnIndex(TBL_B_DESCRIPTION);
            beschwerden.setDes(cursor.getString(index));

            index = cursor.getColumnIndex(TBL_B_DIGESTIVPBL);
            beschwerden.setDige(cursor.getString(index));

            index = cursor.getColumnIndex(TBL_B_HEADACHE);
            beschwerden.setHead(cursor.getString(index));

            index = cursor.getColumnIndex(TBL_B_SKINPBL);
            beschwerden.setSkin(cursor.getString(index));

            index = cursor.getColumnIndex(TBL_B_RESPIDISTRESS);
            beschwerden.setResp(cursor.getString(index));

            index = cursor.getColumnIndex(TBL_B_FEVER);
            beschwerden.setFev(cursor.getString(index));

            return beschwerden;
        }
}
