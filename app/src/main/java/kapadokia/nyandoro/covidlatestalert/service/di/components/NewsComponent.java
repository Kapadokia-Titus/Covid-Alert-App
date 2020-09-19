package kapadokia.nyandoro.covidlatestalert.service.di.components;

import javax.inject.Singleton;

import dagger.Component;
import kapadokia.nyandoro.covidlatestalert.service.di.modules.ContextModule;
import kapadokia.nyandoro.covidlatestalert.service.di.modules.NetworkModule;
import kapadokia.nyandoro.covidlatestalert.view.ui.NewsFragment;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface NewsComponent {
    void setNews(NewsFragment newsFragment);
}
