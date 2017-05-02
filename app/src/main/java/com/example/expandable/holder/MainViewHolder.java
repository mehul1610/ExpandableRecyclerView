package com.example.expandable.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.expandable.modal.ExpandableParent;
import com.example.expandable.sample.R;
import com.example.expandable.widget.ExpandableAttribute;

/**
 * Created by stpl on 5/2/2017.
 */

public class MainViewHolder extends ExpandableViewHolder {
    private TextView itemName;
    private TextView itemCount;

    public MainViewHolder(@NonNull ViewGroup parent, int resource) {
        super(parent, resource);
    }

    @Override
    public void bindIds(View itemView) {
        itemName = (TextView) itemView.findViewById(R.id.item_name);
        itemCount = (TextView) itemView.findViewById(R.id.item_count);
    }

    @Override
    public void setData(ExpandableAttribute data) {
        itemName.setText(((ExpandableParent) data).getItemName());
        itemCount.setText(((ExpandableParent) data).getItemCount());
    }

    @Override
    public void onCollapse(ExpandableAttribute data) {
        // do on Collapse the view
    }

    @Override
    public void onExpand(ExpandableAttribute data) {

    }
}
