package com.healthservices.mha.momole.database;

/**
 * Created by manji on 25.04.2017.
 */

public class BeschwerdenDAO {

    public static final String TBL_B = "beschwerden";
    public static final String TBL_B_ID = "id";
    public static final String TBL_B_TSTMP= "tstmp";
    public static final String TBL_B_DESCRIPTION = "des";
    public static final String TBL_B_DIGESTIVPBL = "dige";
    public static final String TBL_B_HEADACHE = "head";
    public static final String TBL_B_SKINPBL = "skin";
    public static final String TBL_B_RESPIDISTRESS = "resp";
    public static final String TBL_B_FEVER = "fev";

    public static final String CREATE_TBL_B = "CREATE TBL " + TBL_B + "("
            + TBL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_B_TSTMP + " INTEGER NOT NULL, "
            + TBL_B_DESCRIPTION + " TEXT, "
            + TBL_B_DIGESTIVPBL + " TEXT, "
            + TBL_B_HEADACHE + " TEXT, "
            + TBL_B_SKINPBL + " TEXT, "
            + TBL_B_RESPIDISTRESS + " TEXT, "
            + TBL_B_FEVER + " TEXT, ";


}
