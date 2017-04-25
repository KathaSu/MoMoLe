package com.healthservices.mha.momole.database;

/**
 * Created by manji on 25.04.2017.
 */

public class LebensmittelDAO {

    public static final String TBL_LM = "lebensmittel";
    public static final String TBL_LM_ID = "id";
    public static final String TBL_LM_TIME = "time";
    public static final String TBL_LM_DESCRIPTION = "des";
    public static final String TBL_LM_LACTOSE = "lac";
    public static final String TBL_LM_GLUTEN = "glu";
    public static final String TBL_LM_FRUCTOSE = "fru";
    public static final String TBL_LM_HISTAMIN = "his";

    public static final String CREATE_TBL_LM = "CREATE TBL " + TBL_LM + "("
            + TBL_LM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_LM_TIME + " INTEGER NOT NULL, "
            + TBL_LM_DESCRIPTION + " TEXT, "
            + TBL_LM_LACTOSE + " TEXT, "
            + TBL_LM_GLUTEN + " TEXT, "
            + TBL_LM_FRUCTOSE + " TEXT, "
            + TBL_LM_HISTAMIN + " TEXT, ";


}


