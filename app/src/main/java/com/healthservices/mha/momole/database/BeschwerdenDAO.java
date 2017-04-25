package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by manji on 25.04.2017.
 */

public class BeschwerdenDAO {

    public static final String TBL_B = "beschwerden";
    public static final String TBL_B_ID = "id";
    public static final String TBL_B_TIME = "time";
    public static final String TBL_B_DESCRIPTION = "des";
    public static final String TBL_B_DIGESTIVPBL = "dige";
    public static final String TBL_B_HEADACHE = "head";
    public static final String TBL_B_SKINPBL = "skin";
    public static final String TBL_B_RESPIDISTRESS = "resp";
    public static final String TBL_B_FEVER = "fev";

    public static final String CREATE_TBL_B = "CREATE TBL " + TBL_B + "("
            + TBL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_B_TIME + " INTEGER NOT NULL, "
            + TBL_B_DESCRIPTION + " TEXT, "
            + TBL_B_DIGESTIVPBL + " TEXT, "
            + TBL_B_HEADACHE + " TEXT, "
            + TBL_B_SKINPBL + " TEXT, "
            + TBL_B_RESPIDISTRESS + " TEXT, "
            + TBL_B_FEVER + " TEXT, ";


}
