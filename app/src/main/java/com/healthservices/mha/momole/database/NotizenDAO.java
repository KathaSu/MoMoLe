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

public class NotizenDAO {

    public static final String TAG = "NotizenDAO";

    // DB fields
    private SQLiteDatabase mDatabase;
    private DBHelper mDbHelper;
    private Context mcontext;
    private String[] mAllColumns ={DBHelper.TBL_N_ID, DBHelper.TBL_N_TIME,
            DBHelper.TBL_N_DESCRIPTION};


}
