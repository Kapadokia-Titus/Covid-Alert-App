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
import kapadokia.nyandoro.covidlatestalert.databinding.NewsItemsBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.Article;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<? extends Article> articleLists;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        NewsItemsBinding binding;
        public MyViewHolder(@NonNull  NewsItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.news_items, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setArticles(articleLists.get(position));

    }

    @Override
    public int getItemCount() {
        return articleLists==null?0 : articleLists.size();
    }


    public void setArticleLists(final List<Article> articleLists){

        if (articleLists==null){
            this.articleLists=articleLists;
            notifyItemRangeInserted(0,articleLists.size());
        }else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return NewsAdapter.this.articleLists.size();
                }

                @Override
                public int getNewListSize() {
                    return articleLists.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return NewsAdapter.this.articleLists.get(oldItemPosition).getTitle().equals(articleLists.get(newItemPosition).getTitle());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    Article latest = articleLists.get(newItemPosition);
                    Article old = articleLists.get(oldItemPosition);
                    return latest.getTitle().equals(old.getTitle()) && Objects.equals(latest.getUrl(), old.getContent());
                }
            });

            this.articleLists =articleLists;
            result.dispatchUpdatesTo(this);
        }
    }

}
