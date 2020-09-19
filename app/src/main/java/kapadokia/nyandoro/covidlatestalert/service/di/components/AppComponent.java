package kapadokia.nyandoro.covidlatestalert.service.di.components;

import javax.inject.Singleton;

import dagger.Component;
import kapadokia.nyandoro.covidlatestalert.view.ui.CountriesFragment;
import kapadokia.nyandoro.covidlatestalert.view.ui.HomeFragment;
import kapadokia.nyandoro.covidlatestalert.service.di.modules.ContextModule;
import kapadokia.nyandoro.covidlatestalert.service.di.modules.NetworkModule;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {

    void inject(CountriesFragment countriesFragment);
    void display(HomeFragment homeFragment);
}
