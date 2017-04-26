package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.healthservices.mha.momole.database.model.Notizen;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by manji on 25.04.2017.
 */

public class NotizenDAO {

    // columns of the Notizen table
    public static final String TBL_N = "notizen";
    public static final String TBL_N_ID = "id";
    public static final String TBL_N_TIME = "time";
    public static final String TBL_N_DESCRIPTION = "des";

    //sql statement of the notizen table
    public static final String CREATE_TBL_N = "CREATE TBL " + TBL_N + "("
            + TBL_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_N_TIME + " INTEGER NOT NULL, "
            + TBL_N_DESCRIPTION + " TEXT "
            + ");";

        private static NotizenDAO instance;
        private DBHelper dbHelper;
        private SQLiteDatabase database;

        public static NotizenDAO getInstance(Context context){
            if (instance == null){
                instance = new NotizenDAO(context);
            }
            return instance;
        }

        private NotizenDAO(Context context){
            dbHelper = DBHelper.getInstance(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close(){
            dbHelper.close();
        }

        public void onCreate(SQLiteDatabase database){
            database.execSQL(CREATE_TBL_N);
        }

        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

        }

        public Notizen getNotizen(long id) {
            open();
            Cursor cursor = database.query(TBL_N, //Table
                    null, //null returns all columns / fields
                    TBL_N_ID + "=?", //Selection (WHERE [field]=?)
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

    public List<Notizen> getAllNotizenAfter(long timestamp) {
        open();
        Cursor cursor = database.query(TBL_N, //Table
                new String[] {TBL_N_ID, TBL_N_DESCRIPTION, TBL_N_TIME}, //Fields, null would also return all columns / fields
                TBL_N_TIME + ">=" + timestamp, //Selection, can't do >= with selection arguments
                null, //Selection arguments (replaces ? in Selection)
                null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                null, //Having, Selection on Group By fields (HAVING [field]=1)
                null, //Limit, limits the selection, e. g. 10 for 10 entries
                TBL_N_TIME + " ASC"); //Order by timestamp, ascending
        List<Notizen> notizen = new LinkedList<>();
        if (cursor.moveToFirst()) { // read in the the result row by row, if data available
            while (!cursor.isAfterLast()) {
                notizen.add(readFromCursor(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return notizen;
    }

        public List<Notizen> getAllNotizen() {
            open();

            Cursor cursor = database.query(TBL_N, //Table
                    new String[] {TBL_N_ID, TBL_N_TIME, TBL_N_DESCRIPTION}, //Fields, null would also return all columns / fields
                    null, //Selection (WHERE [field]=?)
                    null, //Selection arguments (replaces ? in Selection)
                    null, //GroupBy (GROUPY BY [field], e. g. in case of sum([field]))
                    null, //Having, Selection on Group By fields (HAVING [field]=1)
                    null, //Limit, limits the selection, e. g. 10 for 10 entries
                    null); //CancelationSignal

            List<Notizen> notizen = new LinkedList<>();
            if (cursor.moveToFirst()) { // read in the the result row by row, if data available
                while (!cursor.isAfterLast()) {
                    notizen.add(readFromCursor(cursor));
                    cursor.moveToNext();
                }
            }

        public long addNotizen(Notizen notizen) {
            open();
            long ret = database.insert(TBL_N, null, prepareValues(notizen));
            if (ret > 0) {
                notizen.setId(ret);
            }
            close();
            return ret;
        }

        public int updateNotizen(Notizen notizen) {
            open();
            int ret = database.update(TBL_N, //Table
                    prepareValues(notizen), //Values
                    TBL_N_ID + "=?", //Selection (what data to update)
                    new String[]{String.valueOf(notizen.getId())}); // selection by id
            close();
            return ret;
        }

        public int deleteNotizen(Notizen notizen) {
            open();
            int ret = database.delete(TBL_N,
                    TBL_N_ID + "=?", //Selection (what data to delete)
                    new String[]{String.valueOf(notizen.getId())}); // selection by id
            close();
            return ret;
        }

        private ContentValues prepareValues(Notizen notizen) {
            ContentValues contentValues = new ContentValues();

            if (notizen.getId() > 0)
                contentValues.put(TBL_N_ID, notizen.getId());

            contentValues.put(TBL_N_DESCRIPTION, notizen.getDes());
            contentValues.put(TBL_N_TIME, notizen.getTime());

            return contentValues;
        }

        private Notizen readFromCursor(Cursor cursor) {
            Notizen notizen = new Notizen();

            int index = cursor.getColumnIndex(TBL_N_ID);
            notizen.setId(cursor.getLong(index));

            index = cursor.getColumnIndex(TBL_N_TIME);
            notizen.setTime(cursor.getLong(index));

            index = cursor.getColumnIndex(TBL_N_DESCRIPTION);
            notizen.setDes(cursor.getString(index));

            return notizen;
        }
    }