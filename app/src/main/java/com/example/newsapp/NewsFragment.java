package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESC = "desc";
    private static final String ARG_IMAGE = "image";

    public static NewsFragment newInstance(News news) {
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, news.getTitle());
        args.putString(ARG_DESC, news.getDescription());
        args.putInt(ARG_IMAGE, news.getImageResId());

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        TextView title = view.findViewById(R.id.news_detail_title);
        TextView desc = view.findViewById(R.id.news_detail_description);
        ImageView image = view.findViewById(R.id.news_detail_image);
        RecyclerView rvRelated = view.findViewById(R.id.rv_related);

        Bundle args = getArguments();
        if (args != null) {
            title.setText(args.getString(ARG_TITLE));
            desc.setText(args.getString(ARG_DESC));
            image.setImageResource(args.getInt(ARG_IMAGE));
        }

        ArrayList<News> relatedList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            relatedList.add(new News("Related " + i, "Description " + i, R.drawable.sample));
        }

        RelatedNewsAdapter adapter = new RelatedNewsAdapter(relatedList);
        rvRelated.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRelated.setAdapter(adapter);

        return view;
    }
}
