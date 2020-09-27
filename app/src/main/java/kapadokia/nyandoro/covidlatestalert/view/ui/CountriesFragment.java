package kapadokia.nyandoro.covidlatestalert.view.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import kapadokia.nyandoro.covidlatestalert.BaseApplication;
import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.CountriesFragmentBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;
import kapadokia.nyandoro.covidlatestalert.view.adapters.CountryAdapter;
import kapadokia.nyandoro.covidlatestalert.viewModel.CountriesViewModel;

public class CountriesFragment extends Fragment {

    CountriesFragmentBinding binding;


    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private CountryAdapter countryAdapter;
    private CountriesViewModel countriesViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = CountriesFragmentBinding.inflate(inflater);

        ((BaseApplication) Objects.requireNonNull(getActivity()).getApplication()).getAppComponent().inject(this);


        binding.recyclerView.setAdapter(countryAdapter);
        countryAdapter = new CountryAdapter();


        countriesViewModel = ViewModelProviders.of(this, viewModelProvider).get(CountriesViewModel.class);
        countriesViewModel.getCountryMutableLiveData().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                Log.d("data", "onChanged: "+ countries);
                countryAdapter.setCountriesList(countries);
            }
        });

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = binding.searchView;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                countryAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // filter recycler view when query submitted
                countryAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return binding.getRoot();
    }
}