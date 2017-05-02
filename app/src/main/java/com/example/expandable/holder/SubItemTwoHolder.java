package com.example.expandable.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.expandable.modal.ExpandableChild;
import com.example.expandable.sample.R;
import com.example.expandable.widget.ExpandableAttribute;

/**
 * Created by stpl on 5/1/2017.
 */

public class SubItemTwoHolder extends ExpandableViewHolder {
    private RadioButton radioButton;

    public SubItemTwoHolder(@NonNull ViewGroup parent, int resource) {
        super(parent, resource);
    }

    @Override
    public void bindIds(View itemView) {
        radioButton = (RadioButton) itemView.findViewById(R.id.radio_btn);
    }

    @Override
    public void setData(ExpandableAttribute data) {
        radioButton.setText(((ExpandableChild) data).getValue());
    }

    @Override
    public void onCollapse(ExpandableAttribute data) {

    }

    @Override
    public void onExpand(ExpandableAttribute data) {

    }
}
