package com.healthservices.mha.momole.database.model;

/**
 * Created by manji on 25.04.2017.
 */

public class Notizen {

    private long id = -1;
    private long tstmp;
    private String des;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getTstmp() { return tstmp; }
    public void setTstmp(long tstmp) { this.tstmp = tstmp; }

    public String getDes() {
        return des;
    }
    public void setDes(String des) { this.des = des; }

}
