package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static java.nio.channels.SocketChannel.open;

/**
 * Created by manji on 25.04.2017.
 */

public class LebensmittelDAO {

    public static final String TAG = "LebensmittelDAO";

    // DB fields
    private SQLiteDatabase mDatabase;
    private DBHelper mDbHelper;
    private Context mContext;
    private String[] mAllColumns ={DBHelper.TBL_LM_ID, DBHelper.TBL_LM_TIME,
            DBHelper.TBL_LM_DESCRIPTION, DBHelper.TBL_LM_LACTOSE, DBHelper.TBL_LM_GLUTEN,
            DBHelper.TBL_LM_FRUCTOSE, DBHelper.TBL_LM_HISTAMIN};

    public LebensmittelDAO(Context context){
        this.mContext = context;
        mDbHelper = new DBHelper(context);
        //open the Database
        try{
            open();
        } catch (SQLException e){
            Log.e(TAG, "SQLException on opening database" + e.getMessage());
            o.printStackTrace();
        }
    }
    public void open() throws SQLException{
        mDatabase = mDbHelper.getWritableDatabase();
    }
    public void close() {
        mDbHelper.close();
    }
}