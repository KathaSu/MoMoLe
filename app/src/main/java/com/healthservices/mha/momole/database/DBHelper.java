package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manji on 25.04.2017.
 */

public class DBHelper {

    //columns of the Lebensmittel table
    public static final String TBL_LM = "lebensmittel";
    public static final String TBL_LM_ID = "id";
    public static final String TBL_LM_TIME = "time";
    public static final String TBL_LM_DESCRIPTION = "des";
    public static final String TBL_LM_LACTOSE = "lac";
    public static final String TBL_LM_GLUTEN = "glu";
    public static final String TBL_LM_FRUCTOSE = "fru";
    public static final String TBL_LM_HISTAMIN = "his";

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

    // columns of the Notizen table
    public static final String TBL_N = "notizen";
    public static final String TBL_N_ID = "id";
    public static final String TBL_N_TIME = "time";
    public static final String TBL_N_DESCRIPTION = "des";

    private static final String DATABASE_NAME = "momole.db";
    private static final int DATABASE_VERSION = 1;

    //sql statement of the lebensmittel table
    public static final String CREATE_TBL_LM = "CREATE TBL " + TBL_LM + "("
            + TBL_LM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_LM_TIME + " INTEGER NOT NULL, "
            + TBL_LM_DESCRIPTION + " TEXT, "
            + TBL_LM_LACTOSE + " TEXT, "
            + TBL_LM_GLUTEN + " TEXT, "
            + TBL_LM_FRUCTOSE + " TEXT, "
            + TBL_LM_HISTAMIN + " TEXT "
            +");";

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
            +");";

    //sql statement of the notizen table
    public static final String CREATE_TBL_N = "CREATE TBL " + TBL_N + "("
            + TBL_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_N_TIME + " INTEGER NOT NULL, "
            + TBL_N_DESCRIPTION + " TEXT "
            +");";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_LM);
        db.execSQL(SQL_CREATE_TBL_B);
        db.execSQL(SQL_CREATE_TBL_N);
    }
}
