package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by manji on 25.04.2017.
 */

public class LebensmittelDAO {

    public static final String TAG = "LebensmittelDAO";

    // DB fields
    private SQLiteDatabase mDatabase;
    private DBHelper mDbHelper;
    private Context mcontext;
    private String[] mAllColumns ={DBHelper.TBL_LM_ID, DBHelper.TBL_LM_TIME,
            DBHelper.TBL_LM_DESCRIPTION, DBHelper.TBL_LM_LACTOSE, DBHelper.TBL_LM_GLUTEN,
            DBHelper.TBL_LM_FRUCTOSE, DBHelper.TBL_LM_HISTAMIN};

}


