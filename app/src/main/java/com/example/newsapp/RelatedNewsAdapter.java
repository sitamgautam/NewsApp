package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {

    private List<News> relatedNewsList;

    public RelatedNewsAdapter(List<News> relatedNewsList) {
        this.relatedNewsList = relatedNewsList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView relatedTitle;

        public ViewHolder(View view) {
            super(view);
            relatedTitle = view.findViewById(R.id.related_title);
        }
    }

    @Override
    public RelatedNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RelatedNewsAdapter.ViewHolder holder, int position) {
        holder.relatedTitle.setText(relatedNewsList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return relatedNewsList.size();
    }
}
