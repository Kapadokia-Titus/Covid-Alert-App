package kapadokia.nyandoro.covidlatestalert.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;
import kapadokia.nyandoro.covidlatestalert.service.repository.CovidRepository;

public class HomeViewModel extends ViewModel {

    private CovidRepository covidRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Today> todayMutableLiveData = new MutableLiveData<>();

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
                getTodayMutableLiveData().setValue(today);
            }

            @Override
            public void onError(Throwable e) {

            }
        })
        );
    }
}
