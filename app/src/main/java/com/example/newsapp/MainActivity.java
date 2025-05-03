package com.example.newsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnNewsClickListener {

    private RecyclerView rvTopStories, rvNews;
    private ArrayList<News> topStories, newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTopStories = findViewById(R.id.rvTopStories);
        rvNews = findViewById(R.id.rvNews);

        // Sample data
        topStories = getSampleNews("Top Story");
        newsList = getSampleNews("News");

        // Top Stories Adapter
        NewsAdapter topAdapter = new NewsAdapter(topStories, this);
        rvTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTopStories.setAdapter(topAdapter);

        // News Adapter
        NewsAdapter newsAdapter = new NewsAdapter(newsList, this);
        rvNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNews.setAdapter(newsAdapter);
    }

    // Sample Data Generator
    private ArrayList<News> getSampleNews(String prefix) {
        ArrayList<News> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(new News(prefix + " " + i, "Description for " + prefix + " " + i, R.drawable.sample));
        }
        return list;
    }

    // Handle click from adapter
    @Override
    public void onNewsClick(News news) {
        NewsFragment fragment = NewsFragment.newInstance(news);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
