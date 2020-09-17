package kapadokia.nyandoro.covidlatestalert.service.model;

public class Today {
     private int updated; //": 1600377410459,
     private  int cases;
     private  int todayCases;
     private  int deaths;
     private  int todayDeaths;
     private  int recovered;
     private  int todayRecovered;
     private  int affectedCountries;
     private  int tests;


    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public int getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(int affectedCountries) {
        this.affectedCountries = affectedCountries;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }


    @Override
    public String toString() {
        return "Today{" +
                "updated=" + updated +
                ", cases=" + cases +
                ", todayCases=" + todayCases +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", recovered=" + recovered +
                ", todayRecovered=" + todayRecovered +
                ", affectedCountries=" + affectedCountries +
                ", tests=" + tests +
                '}';
    }
}
