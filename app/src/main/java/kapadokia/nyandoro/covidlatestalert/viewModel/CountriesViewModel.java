package kapadokia.nyandoro.covidlatestalert.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;
import kapadokia.nyandoro.covidlatestalert.service.repository.CovidRepository;

public class CountriesViewModel extends ViewModel {

    private CovidRepository covidRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Country>> mutableLiveData = new MutableLiveData<>();

    @Inject
    public CountriesViewModel(CovidRepository covidRepository){
        this.covidRepository = covidRepository;
    }

    public MutableLiveData<List<Country>> getCountryMutableLiveData(){
        loadData();
        return mutableLiveData; 
    }

    private void loadData() {
        compositeDisposable.add(covidRepository.getAllCountriesData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<List<Country>>() {
            @Override
            public void onSuccess(List<Country> countries) {
                getCountryMutableLiveData().setValue(countries);
            }

            @Override
            public void onError(Throwable e) {

            }
        })
        );
    }


}
