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

    public static final String TBL_N = "notizen";
    public static final String TBL_N_ID = "id";
    public static final String TBL_N_TIME = "time";
    public static final String TBL_N_DESCRIPTION = "des";

    public static final String CREATE_TBL_N = "CREATE TBL " + TBL_N + "("
            + TBL_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_N_TIME + " INTEGER NOT NULL, "
            + TBL_N_DESCRIPTION + " TEXT, ";


}
