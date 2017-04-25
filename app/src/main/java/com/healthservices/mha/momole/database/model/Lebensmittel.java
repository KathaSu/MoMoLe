package com.healthservices.mha.momole.database.model;

/**
 * Created by manji on 25.04.2017.
 */

public class Lebensmittel {

    public class Momole {
        private long id = -1;
        private long tstmp;
        private String des;
        private String lac;
        private String glu;
        private String his;
        private String fru;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        public long getTstmp() { return tstmp;}
        public void setTstmp(long tstmp) {this.tstmp = tstmp;}

        public String getDes() {
            return des;
        }
        public void setDes(String des) {
            this.des = des;
        }

        public String getLac() {return lac;}
        public void setLac (String lac) {this.lac = lac;}

        public String getGlu() {return glu;}
        public void setGlu (String glu) {this.glu = glu;}

        public String getFru() {return fru;}
        public void  setFru(String fru) {this.fru = fru;}

        public String getHis() {return his;}
        public void setHis(String his) {this.his = his;}


    }
}
