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

        public long getUhrzeit() { return tstmp;}
        public void setUhrzeit(long tstmp) {this.tstmp = tstmp;}

        public String getBezeichnung() {
            return des;
        }
        public void setBezeichnung(String des) {
            this.des = des;
        }

        public String getKategorie() {
            return category;
        }
        public void setKategorie(String category) {
            this.category = category;
        }

    }
}
