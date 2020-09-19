package kapadokia.nyandoro.covidlatestalert.service.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kapadokia.nyandoro.covidlatestalert.service.di.ViewModelKey;
import kapadokia.nyandoro.covidlatestalert.viewModel.CountriesViewModel;
import kapadokia.nyandoro.covidlatestalert.viewModel.HomeViewModel;
import kapadokia.nyandoro.covidlatestalert.viewModel.NewsViewModel;
import kapadokia.nyandoro.covidlatestalert.viewModel.ViewModelFactory;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel.class)
    abstract ViewModel bindCountriesViewModel(CountriesViewModel countriesViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel.class)
    abstract ViewModel bindNewsViewModel(NewsViewModel newsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);
}
