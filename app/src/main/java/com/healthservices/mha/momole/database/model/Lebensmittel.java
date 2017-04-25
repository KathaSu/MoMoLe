package com.healthservices.mha.momole.database.model;

/**
 * Created by manji on 25.04.2017.
 */

public class Lebensmittel {

    public class Momole {
        private long id = -1;
        private long time;
        private String des;
        private String lac;
        private String glu;
        private String fru;
        private String his;

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

        public String getLac() { return lac; }
        public void setLac (String lac) { this.lac = lac; }

        public String getGlu() { return glu; }
        public void setGlu (String glu) { this.glu = glu; }

        public String getFru() { return fru; }
        public void  setFru(String fru) { this.fru = fru; }

        public String getHis() { return his; }
        public void setHis(String his) { this.his = his; }
    }
}
