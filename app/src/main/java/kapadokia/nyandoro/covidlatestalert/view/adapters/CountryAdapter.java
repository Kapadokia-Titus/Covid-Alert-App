package kapadokia.nyandoro.covidlatestalert.view.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.CountryItemsBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Country;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder>{

    List<? extends Country> countriesList;


    public class MyViewHolder extends RecyclerView.ViewHolder{

        final CountryItemsBinding binding;
        public MyViewHolder(@NonNull CountryItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CountryItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.country_items, parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("loaded", "onBindViewHolder: "+ countriesList);
        holder.binding.setCountries(countriesList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return countriesList==null? 0: countriesList.size();
    }


    public void setCountriesList(final List<?extends Country> countriesList){
        if (this.countriesList == null){
            this.countriesList =countriesList;
            notifyItemRangeInserted(0,countriesList.size());
        }else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return CountryAdapter.this.countriesList.size();
                }

                @Override
                public int getNewListSize() {
                    return countriesList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return CountryAdapter.this.countriesList.get(oldItemPosition).getCountry().equals(countriesList.get(newItemPosition).getCountry());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Country latest = countriesList.get(newItemPosition);
                    Country old = countriesList.get(oldItemPosition);
                    return latest.getCountry().equals(old.getCountry()) && Objects.equals(latest.getUpdated(), old.getContinent());
                }
            });

        this.countriesList =countriesList;
        result.dispatchUpdatesTo(this);
        }
    }


}
