package kapadokia.nyandoro.covidlatestalert.view.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import kapadokia.nyandoro.covidlatestalert.BaseApplication;
import kapadokia.nyandoro.covidlatestalert.R;
import kapadokia.nyandoro.covidlatestalert.databinding.FragmentNewsBinding;
import kapadokia.nyandoro.covidlatestalert.service.model.News;
import kapadokia.nyandoro.covidlatestalert.view.adapters.NewsAdapter;
import kapadokia.nyandoro.covidlatestalert.viewModel.NewsViewModel;


public class NewsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private NewsAdapter newsAdapter;
    private NewsViewModel newsViewModel;

    private FragmentNewsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater);
        ((BaseApplication) Objects.requireNonNull(getActivity()).getApplication()).getNewsComponent().setNews(this);

        newsAdapter = new NewsAdapter();
        binding.newsRecycler.setAdapter(newsAdapter);

        newsViewModel = ViewModelProviders.of(this, viewModelProvider).get(NewsViewModel.class);
        newsViewModel.getNewsMutableLiveData().observe(this, new Observer<News>() {
            @Override
            public void onChanged(News news) {
                newsAdapter.setArticleLists(news.getArticles());
            }
        });
        return binding.getRoot();
    }
}