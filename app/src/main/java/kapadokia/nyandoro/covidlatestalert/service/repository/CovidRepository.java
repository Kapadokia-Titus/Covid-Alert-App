package kapadokia.nyandoro.covidlatestalert.service.repository;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import kapadokia.nyandoro.covidlatestalert.service.model.Continents;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;
import kapadokia.nyandoro.covidlatestalert.service.model.News;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;

public class CovidRepository {

    private CovidService covidService;

    @Inject
    public CovidRepository(CovidService covidService){
        this.covidService = covidService;
    }

    public Single<List<Country>> getAllCountriesData(){
        return covidService.getAllCountries();
    }

    public Single<Today> getAllTodayCases(){
        return covidService.getTodaysCases();
    }
    public Single<List<Continents>> getAllContinentsData(){
        return covidService.getAllContinents();
    }
    public Single<News> getTodaysNewsData(){
        return covidService.getTodaysNews();
    }
}
