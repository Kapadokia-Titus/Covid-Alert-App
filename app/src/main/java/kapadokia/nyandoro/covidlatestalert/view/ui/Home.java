package kapadokia.nyandoro.covidlatestalert.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import kapadokia.nyandoro.covidlatestalert.BaseApplication;
import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.ActivityHomeBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;
import kapadokia.nyandoro.covidlatestalert.viewModel.HomeViewModel;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    HomeViewModel homeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home);

        ((BaseApplication)getApplication()).getAppComponent().display(this);

        homeViewModel = ViewModelProviders.of(this, viewModelProvider).get(HomeViewModel.class);
        homeViewModel.getTodayMutableLiveData().observe(this, new Observer<Today>() {
            @Override
            public void onChanged(Today today) {
                Log.d("data", "onChanged: " +today.getCases());
                binding.setToday(today);
            }
        });
    }
}