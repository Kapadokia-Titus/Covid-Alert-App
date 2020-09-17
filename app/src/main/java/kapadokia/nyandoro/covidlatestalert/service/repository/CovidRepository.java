package kapadokia.nyandoro.covidlatestalert.service.repository;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;

public class CovidRepository {

    private CovidService covidService;

    @Inject
    public CovidRepository(CovidService covidService){
        this.covidService = covidService;
    }

    public Single<List<Country>> getAllCountriesData(){
        return covidService.getAllCountries();
    }
}
