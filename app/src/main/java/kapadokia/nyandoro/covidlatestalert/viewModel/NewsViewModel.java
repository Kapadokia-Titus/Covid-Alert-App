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
import kapadokia.nyandoro.covidlatestalert.service.model.News;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;
import kapadokia.nyandoro.covidlatestalert.service.repository.CovidRepository;

public class NewsViewModel extends ViewModel {

    private CovidRepository covidRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<News> newsMutableLiveData = new MutableLiveData<>();

    @Inject
    public NewsViewModel(CovidRepository covidRepository){
        this.covidRepository = covidRepository;
    }

    public MutableLiveData<News> getNewsMutableLiveData(){
        loadData();
        return newsMutableLiveData;
    }

    private void loadData() {

        compositeDisposable.add(covidRepository.getTodaysNewsData()
         .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<News>() {
            @Override
            public void onSuccess(News news) {
                getNewsMutableLiveData().setValue(news);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("news", "onError: error fetching news" + e.toString());
            }
        }));
    }
}
