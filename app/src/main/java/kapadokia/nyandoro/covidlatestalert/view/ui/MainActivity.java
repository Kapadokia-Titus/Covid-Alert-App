package kapadokia.nyandoro.covidlatestalert.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import kapadokia.nyandoro.covidlatestalert.BaseApplication;
import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.ActivityMainBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;
import kapadokia.nyandoro.covidlatestalert.view.adapters.CountryAdapter;
import kapadokia.nyandoro.covidlatestalert.viewModel.CountriesViewModel;
import kapadokia.nyandoro.covidlatestalert.viewModel.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private CountryAdapter countryAdapter;
    private CountriesViewModel countriesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        countryAdapter = new CountryAdapter();
        binding.recyclerView.setAdapter(countryAdapter);



        countriesViewModel = ViewModelProviders.of(this, viewModelProvider).get(CountriesViewModel.class);
        countriesViewModel.getCountryMutableLiveData().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                Log.d("data", "onChanged: "+ countries);
                countryAdapter.setCountriesList(countries);
            }
        });
    }
}