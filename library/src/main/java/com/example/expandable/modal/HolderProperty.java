package com.example.expandable.modal;

import android.view.View;

import com.example.expandable.widget.ExpandableAttribute;

/**
 * Created by stpl on 5/2/2017.
 */

public interface HolderProperty {

    void bindIds(View itemView);

    void setData(ExpandableAttribute data);

    void onCollapse(ExpandableAttribute data);

    void onExpand(ExpandableAttribute data);
}
