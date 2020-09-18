package kapadokia.nyandoro.covidlatestalert.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kapadokia.nyandoro.covidlatestalert.service.model.Continents;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;
import kapadokia.nyandoro.covidlatestalert.service.repository.CovidRepository;

public class HomeViewModel extends ViewModel {

    private CovidRepository covidRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Today> todayMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Continents>> continentsMutableLiveData = new MutableLiveData<>();

    @Inject
    public HomeViewModel(CovidRepository covidRepository){
        this.covidRepository = covidRepository;
    }

    public MutableLiveData<Today> getTodayMutableLiveData(){
        loadData();
        return todayMutableLiveData;
    }

    private void loadData() {

        compositeDisposable.add(covidRepository.getAllTodayCases()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<Today>() {
            @Override
            public void onSuccess(Today today) {
                Log.d("data", "onSuccess: today " +today.getCases());
                getTodayMutableLiveData().setValue(today);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("error", "onError: failed to load data"+ e.toString() );
            }
        })
        );
    }

    // loading continent's data
    public MutableLiveData<List<Continents>> getContinentsMutableLiveData(){
        loadContinentsData();
        return continentsMutableLiveData;
    }

    private void loadContinentsData() {
        compositeDisposable.add(covidRepository.getAllContinentsData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Continents>>() {
                    @Override
                    public void onSuccess(List<Continents> continents) {
                        getContinentsMutableLiveData().setValue(continents);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("continents", "error loading data  " + e.toString());
                    }
                })
        );
    }
}
