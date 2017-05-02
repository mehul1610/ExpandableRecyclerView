package com.example.expandable.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.expandable.modal.ExpandableChild;
import com.example.expandable.sample.R;
import com.example.expandable.widget.ExpandableAttribute;

/**
 * Created by stpl on 5/1/2017.
 */

public class SubItemOneHolder extends ExpandableViewHolder {
    private CheckBox checkBox;

    public SubItemOneHolder(@NonNull ViewGroup parent, int resource) {
        super(parent, resource);
    }

    @Override
    public void bindIds(View itemView) {
        checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
    }

    @Override
    public void setData(ExpandableAttribute data) {
        checkBox.setText(((ExpandableChild) data).getValue());
    }

    @Override
    public void onCollapse(ExpandableAttribute data) {

    }

    @Override
    public void onExpand(ExpandableAttribute data) {

    }
}
