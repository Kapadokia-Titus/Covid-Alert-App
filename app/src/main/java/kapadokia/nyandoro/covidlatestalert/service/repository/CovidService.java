package kapadokia.nyandoro.covidlatestalert.service.repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import kapadokia.nyandoro.covidlatestalert.service.model.Continents;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;
import kapadokia.nyandoro.covidlatestalert.service.model.News;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidService {

    public static final String BASE_URL="https://corona.lmao.ninja/v2/";
    public static final String NEWS_API="https://newsapi.org/v2/";


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

    //get today's cases
    @GET("all")
    Single<Today> getTodaysCases();

    // news endpoint
    @GET("everything?q=COVID&from=2020-08-20&sortBy=publishedAt&apiKey=e5033003cfed4a49901db4b0749c4ef1&pageSize=100&page=1")
    Single<News> getTodaysNews();

}
