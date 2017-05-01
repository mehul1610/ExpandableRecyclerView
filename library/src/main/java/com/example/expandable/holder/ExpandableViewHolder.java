package com.example.expandable.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.expandable.widget.ExpandableAttribute;


public abstract class ExpandableViewHolder extends RecyclerView.ViewHolder {

    public ExpandableViewHolder(@NonNull ViewGroup parent, int resource) {
        super(LayoutInflater.from(parent.getContext()).inflate(resource, parent, false));
        bindIds(itemView);
    }

    public abstract void bindIds(View itemView);

    public abstract void setData(ExpandableAttribute data);
}