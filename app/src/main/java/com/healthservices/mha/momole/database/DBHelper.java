package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manji on 25.04.2017.
 */

public class DBHelper {

    public static final String TAG = "DBHelper";

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

}
