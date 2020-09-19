package kapadokia.nyandoro.covidlatestalert;

import android.app.Application;

import kapadokia.nyandoro.covidlatestalert.service.di.components.AppComponent;
import kapadokia.nyandoro.covidlatestalert.service.di.components.DaggerAppComponent;
import kapadokia.nyandoro.covidlatestalert.service.di.components.DaggerNewsComponent;
import kapadokia.nyandoro.covidlatestalert.service.di.components.NewsComponent;

public class BaseApplication extends Application {

    private AppComponent appComponent;
    private NewsComponent newsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.create();
        newsComponent = DaggerNewsComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
    public NewsComponent getNewsComponent() {
        return newsComponent;
    }
}
