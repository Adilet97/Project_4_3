package com.example.project_4_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ViewHolder> {
    private List<String> continents;
    private OnContinentClickListener listener;

    public interface OnContinentClickListener {
        void onContinentClick(String continent);
    }

    public ContinentAdapter(List<String> continents, OnContinentClickListener listener) {
        this.continents = continents;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String continent = continents.get(position);
        holder.textView.setText(continent);
        holder.itemView.setOnClickListener(v -> listener.onContinentClick(continent));
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
