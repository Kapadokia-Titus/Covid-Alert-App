package kapadokia.nyandoro.covidlatestalert.service.model;

public class Today {
     private long updated; //": 1600377410459,
     private  long cases;
     private  long todayCases;
     private  long deaths;
     private  long todayDeaths;
     private  long recovered;
     private  long todayRecovered;
     private  long affectedCountries;
     private  long tests;


    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(long todayCases) {
        this.todayCases = todayCases;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public long getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(long affectedCountries) {
        this.affectedCountries = affectedCountries;
    }

    public long getTests() {
        return tests;
    }

    public void setTests(long tests) {
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
