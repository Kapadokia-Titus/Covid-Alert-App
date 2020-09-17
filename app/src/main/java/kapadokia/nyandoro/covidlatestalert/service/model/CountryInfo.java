package kapadokia.nyandoro.covidlatestalert.service.model;

public class CountryInfo {
     private int id;
     private String iso3;
     private String flag;


     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getIso3() {
          return iso3;
     }

     public void setIso3(String iso3) {
          this.iso3 = iso3;
     }

     public String getFlag() {
          return flag;
     }

     public void setFlag(String flag) {
          this.flag = flag;
     }

     @Override
     public String toString() {
          return "CountryInfo{" +
                  "id=" + id +
                  ", iso3='" + iso3 + '\'' +
                  ", flag='" + flag + '\'' +
                  '}';
     }
}
