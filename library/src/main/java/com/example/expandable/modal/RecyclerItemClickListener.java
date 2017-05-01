package com.example.expandable.modal;

import android.view.View;

import com.example.expandable.holder.ExpandableViewHolder;

/**
 * Created by stpl on 4/27/2017.
 */

public interface RecyclerItemClickListener {
    void onItemClickListener(ExpandableViewHolder viewHolder, View view, int position);
}
