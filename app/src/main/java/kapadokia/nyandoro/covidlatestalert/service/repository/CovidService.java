package kapadokia.nyandoro.covidlatestalert.service.repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import kapadokia.nyandoro.covidlatestalert.service.model.Continents;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidService {

    public static final String BASE_URL="https://corona.lmao.ninja/v2/";


    // get all continents
    @GET("continents?yesterday=true&sort=")
    Single<List<Continents>> getAllContinents();

    // get specific continent
    @GET("continents/:query?yesterday=&strict=")
    Single<Continents> getSpecificContinent(@Query("query") String continent);


    // Get All countries
    @GET("countries?yesterday=&sort=")
    Single<List<Country>> getAllCountries();

    // get specific country
    @GET("countries/:query?yesterday=true&strict=true&query=")
    Single<Country> getSpecificCountry(@Query("query") String country);

}
