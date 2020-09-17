package kapadokia.nyandoro.covidlatestalert.service.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kapadokia.nyandoro.covidlatestalert.service.repository.CovidService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public abstract class NetworkModule {

    @Provides
    @Singleton
    static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(CovidService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static CovidService providerCovidService(Retrofit retrofit){
        return retrofit.create(CovidService.class);
    }
}
