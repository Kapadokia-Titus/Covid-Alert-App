package kapadokia.nyandoro.covidlatestalert.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.ContinentItemBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Continents;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsAdapter.MyViewHolder> {

    private List<? extends Continents> continentsList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ContinentItemBinding binding;
        public MyViewHolder(@NonNull  ContinentItemBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContinentItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.continent_item, parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.binding.setContinents(continentsList.get(position));
      holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return continentsList==null? 0: continentsList.size();
    }

    public void setContinentsList(final List<? extends Continents> continentsList){
        if (this.continentsList==null){
            this.continentsList =continentsList;
            notifyItemRangeInserted(0,continentsList.size());
        }else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return ContinentsAdapter.this.continentsList.size();
                }

                @Override
                public int getNewListSize() {
                    return continentsList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return ContinentsAdapter.this.continentsList.get(oldItemPosition).getContinent().equals(continentsList.get(newItemPosition).getContinent());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Continents latest = continentsList.get(newItemPosition);
                    Continents old = continentsList.get(oldItemPosition);
                    return latest.getContinent().equals(old.getContinent()) && Objects.equals(latest.getDeaths(), old.getCases());
                }
            });

            this.continentsList = continentsList;
            result.dispatchUpdatesTo(this);
        }
    }


}
