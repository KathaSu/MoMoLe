package com.healthservices.mha.momole.database.model;

/**
 * Created by manji on 25.04.2017.
 */

public class Lebensmittel {

    public class Momole {
        private long id = -1;
        private long tstmp;
        private String des;
        private String lactose;
        private String gluten;
        private String histamin;
        private String fructose;

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

        public String getLactose() {return lactose;}
        public void setLactose (String Lactose) {this.lactose = lactose;}

        public String getGluten() {return gluten;}
        public void setGluten (String gluten) {this.gluten = gluten;}

        public String getHistamin() {return histamin;}
        public void setHistamin(String histamin) {this.histamin = histamin;}

        public String getFructose() {return fructose;}
        public void  setFructose(String fructose) {this.fructose = fructose}

    }
}
