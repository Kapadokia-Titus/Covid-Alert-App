package kapadokia.nyandoro.covidlatestalert.view.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

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
import kapadokia.nyandoro.covidlatestalert.databinding.HomeFragmentBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Continents;
import kapadokia.nyandoro.covidlatestalert.service.model.Today;
import kapadokia.nyandoro.covidlatestalert.view.adapters.ContinentsAdapter;
import kapadokia.nyandoro.covidlatestalert.viewModel.HomeViewModel;

public class HomeFragment extends Fragment {

    HomeFragmentBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    HomeViewModel homeViewModel;
    ContinentsAdapter continentsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater);

        ((BaseApplication) Objects.requireNonNull(getActivity()).getApplication()).getAppComponent().display(this);

        continentsAdapter = new ContinentsAdapter();
        binding.continentRecycler.setAdapter(continentsAdapter);

        homeViewModel = ViewModelProviders.of(this, viewModelProvider).get(HomeViewModel.class);
        homeViewModel.getTodayMutableLiveData().observe(this, new Observer<Today>() {
            @Override
            public void onChanged(Today today) {
                Log.d("data", "onChanged: " +today.getCases());
                binding.setToday(today);
            }
        });

        homeViewModel.getContinentsMutableLiveData().observe(this, new Observer<List<Continents>>() {
            @Override
            public void onChanged(List<Continents> continents) {
                Log.d("continents", "onChanged: " + continents);
                continentsAdapter.setContinentsList(continents);
            }
        });

        return binding.getRoot();
    }
}