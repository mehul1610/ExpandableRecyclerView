package com.example.expandable;


import com.example.expandable.widget.ExpandableAttribute;

/**
 * Created by stpl on 4/25/2017.
 */

public class ExpandableChild extends ExpandableAttribute {

    public ExpandableChild(int resourceId) {
        super(resourceId);
    }


    public void setValue(Object object) {
        this.object = object;
    }

    public Object getValue() {
        return object;
    }
}
