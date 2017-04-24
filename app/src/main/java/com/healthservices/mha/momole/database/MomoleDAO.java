package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import com.healthservices.mha.momole.database.model.Momole;

/**
 * Created by manji on 23.04.2017.
 */

public class MomoleDAO {
    public static final String TBL_LM = "lebensmittel";
    public static final String TBL_LM_ID = "id";
    public static final String TBL_LM_TSTMP = "tstmp";
    public static final String TBL_LM_DESCRIPTION = "des";
    public static final String TBL_LM_LACTOSE = " lactose";
    public static final String TBL_LM_GLUTEN = "gluten";
    public static final String TBL_LM_FRUCTOSE = "fructose";
    public static final String TBL_LM_HISTAMIN = "histamin";



    public static final String TBL_B = "beschwerden";
    public static final String TBL_B_ID = "id";
    public static final String TBL_B_TSTMP = "tstmp";
    public static final String TBL_B_DESCRIPTION = "des";
    public static final String TBL_B_DIGESTIVPBL = "digestivpbl";
    public static final String TBL_B_HEADACHE = "headache";
    public static final String TBL_B_SKINPBL = "skinpbl";
    public static final String TBL_B_RESPIDISTRESS = "respidistress";
    public static final String TBL_B_FEVER = "fever";

    public static final String TBL_N = "notizen";
    public static final String TBL_N_ID = "id";
    public static final String TBL_N_TSTMP = "tspmp";
    public static final String TBL_N_DESCRIPTION = "des";

    public static final String CREATE_TBL_LM = "CREATE TBL " + TBL_LM + "("
            + TBL_LM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_LM_TSTMP + " INTEGER NOT NULL, "
            + TBL_LM_DESCRIPTION + " TEXT, "
            + TBL_LM_LACTOSE + " TEXT, "
            + TBL_LM_GLUTEN + " TEXT, "
            + TBL_LM_FRUCTOSE + " TEXT, "
            + TBL_LM_HISTAMIN + " TEXT, ";

    public static final String CREATE_TBL_B = "CREATE TBL " + TBL_B + "("
            + TBL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_B_TSTMP + " INTEGER NOT NULL, "
            + TBL_B_DESCRIPTION + " TEXT, "
            + TBL_B_DIGESTIVPBL + " TEXT, "
            + TBL_B_HEADACHE + " TEXT, "
            + TBL_B_SKINPBL + " TEXT, "
            + TBL_B_RESPIDISTRESS + " TEXT, "
            + TBL_B_FEVER + " TEXT";

    public static final String CREATE_TBL_N = "CREATE TBL " + TBL_N + "("
            + TBL_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_N_TSTMP + " INTEGER NOT NULL, "
            + TBL_N_DESCRIPTION + " TEXT";

    private static MomoleDAO instance;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static MomoleDAO getInstance(Context context){
        if (instance == null) {
            instance = new MomoleDAO(context);
        }
        return instance;
    }

    private MomoleDAO(Context context){
        dbHelper = DatabaseHelper.getInstance(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TBL_LM);
        db.execSQL(CREATE_TBL_B);
        db.execSQL(CREATE_TBL_N);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public Momole getMomole(long id){
        open();
        Cursor cursor = db.query(TBL_LM,  //TBL
                null, //null returns all columns /fields
                TBL_LM_ID + "=?", // Selection (WHERE [field]=?)
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()){
            return readFromCursor(cursor);
        }
        cursor.close();
        close();
        return null;
    }

    public List<Momole> getAllMomoleAfter (long timestamp){
        open();
        Cursor cursor = db.query(TBL_LM,
                new String [] {TBL_LM_ID, TBL_LM_TSTMP, TBL_LM_DESCRIPTION, TBL_LM_LACTOSE, TBL_LM_GLUTEN, TBL_LM_FRUCTOSE, TBL_LM_HISTAMIN},
                TBL_LM_TSTMP + ">=" + timestamp,
                null,
                null,
                null,
                null,
                TBL_LM_TSTMP + " ASC");
        List<Momole> momole = new LinkedList<>();
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                momole.add (readFromCursor (cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return momole;
    }
    // 103 bis 158 nicht umgesetzt

    private ContentValues prepareValues (Momole momole) {
        ContentValues contentValues = new ContentValues();

        if (momole.getId() > 0)
            contentValues.put(TBL_LM_ID, momole.getId());
        contentValues.put(TBL_LM_TSTMP, momole.getUhrzeit());
        contentValues.put(TBL_LM_DESCRIPTION, momole.getBezeichnung());
        contentValues.put(TBL_LM_LACTOSE, momole.getKategorie());
        contentValues.put(TBL_LM_GLUTEN, momole.getKategorie());
        contentValues.put(TBL_LM_HISTAMIN, momole.getKategorie());
        contentValues.put(TBL_LM_FRUCTOSE, momole.getKategorie());

        return contentValues;
    }

    private Momole readFromCursor (Cursor cursor) {
        Momole momole = new Momole();

        int index = cursor.getColumnIndex(TBL_LM_ID);
        momole.setId(cursor.getLong(index));

        index = cursor.getColumnIndex(TBL_LM_TSTMP);
        momole.setUhrzeit(cursor.getString(index)); // get.Long weisst error auf

        index = cursor.getColumnIndex(TBL_LM_DESCRIPTION);
        momole.setBezeichnung(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_LACTOSE);
        momole.setKategorie(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_GLUTEN);
        momole.setKategorie(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_HISTAMIN);
        momole.setKategorie(cursor.getString(index));

        index = cursor.getColumnIndex(TBL_LM_FRUCTOSE);
        momole.setKategorie(cursor.getString(index));

        return momole;
    }

}
