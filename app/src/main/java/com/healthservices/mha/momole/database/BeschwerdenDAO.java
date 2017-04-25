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

    public static final String TAG = "BeschwerdenDAO";

    // DB fields
    private SQLiteDatabase mDatabase;
    private DBHelper mDbHelper;
    private Context mcontext;
    private String[] mAllColumns ={DBHelper.TBL_B_ID, DBHelper.TBL_B_TIME,
            DBHelper.TBL_B_DESCRIPTION, DBHelper.TBL_B_DIGESTIVPBL, DBHelper.TBL_B_HEADACHE,
            DBHelper.TBL_B_SKINPBL, DBHelper.TBL_B_RESPIDISTRESS, DBHelper.TBL_B_FEVER};


}
