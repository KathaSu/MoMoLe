package com.healthservices.mha.momole.database.model;

/**
 * Created by manji on 25.04.2017.
 */

public class Beschwerden {

    private long id = -1;
    private long time;
    private String des;
    private String dige;
    private String head;
    private String skin;
    private String resp;
    private String fev;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }

    public String getDes() {
        return des;
    }
    public void setDes(String des) { this.des = des; }

    public String getDige() { return dige; }
    public void setDige(String dige) { this.dige = dige; }

    public String getHead() { return head; }
    public void setHead(String glu) { this.head = head; }

    public String getSkin() { return skin; }
    public void  setSkin(String skin) { this.skin = skin; }

    public String getResp() { return resp; }
    public void setResp(String resp) { this.resp = resp; }

    public String getFev() { return fev; }
    public void setFev(String fev) { this.fev = fev; }
}
