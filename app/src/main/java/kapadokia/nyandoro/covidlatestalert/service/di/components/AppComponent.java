package kapadokia.nyandoro.covidlatestalert.service.di.components;

import javax.inject.Singleton;

import dagger.Component;
import kapadokia.nyandoro.covidlatestalert.view.ui.Home;
import kapadokia.nyandoro.covidlatestalert.view.ui.MainActivity;
import kapadokia.nyandoro.covidlatestalert.service.di.modules.ContextModule;
import kapadokia.nyandoro.covidlatestalert.service.di.modules.NetworkModule;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void display(Home home);
}
