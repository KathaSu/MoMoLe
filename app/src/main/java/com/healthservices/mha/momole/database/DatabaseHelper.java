package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manji on 23.04.2017.
 */

public class DatabaseHelper {

    private static final String DATABASE_NAME = "momole.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper instance;

    public DatabaseHelper(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        LebensmittelDAO.exeSQL(SQL_CREATE_TBL_LM);
        BeschwerdenDAO.getInstance(null).onCreate(db);
        NotizenDAO.getInstance(null).onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        LebensmittelDAO.getInstance(null).onUpgrade(db, oldVersion, newVersion);
        BeschwerdenDAO.getInstance(null).onUpgrade(db, oldVersion, newVersion);
        NotizenDAO.getInstance(null).onUpgrade(db, oldVersion, newVersion);
    }
   }


    //public static DatabaseHelper getInstance (Context context){
      //  if (instance == null){instance = new DatabaseHelper(context, null);
        //}
        //return instance;
    //}