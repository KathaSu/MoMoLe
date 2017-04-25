package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manji on 25.04.2017.
 */

public class DBHelper{

    private static final String DATABASE_NAME = "momole.db";
    private static final int DATABASE_VERSION = 1;
    private static DBHelper instance;

    private DBHelper(Context context, SQLiteDatabase.CursorFactory factory){
        super((context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public static DBHelper getInstance(Context context){
        if (instance == null){
            instance = new DBHelper(context, null);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        LebensmittelDAO.getInstance(null).onCreate(database);
        BeschwerdenDAO.getInstance(null).onCreate(database);
        NotizenDAO.getInstance(null).onCreate(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, in newVersion){
        LebensmittelDAO.getInstance(null).onUpgrade(database, oldVersion, newVersion);
        BeschwerdenDAO.getInstance(null).onUpgrade(database, oldVersion, newVersion);
        NotizenDAO.getInstance(null).onUpgrade(database, oldVersion, newVersion);
    }
}
