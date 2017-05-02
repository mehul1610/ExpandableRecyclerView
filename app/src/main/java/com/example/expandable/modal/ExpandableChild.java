package com.example.expandable.modal;


import com.example.expandable.widget.ExpandableAttribute;

/**
 * Created by stpl on 4/25/2017.
 */

public class ExpandableChild extends ExpandableAttribute {
    private String name;

    public ExpandableChild(int resourceId) {
        super(resourceId);
    }

    public void setValue(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
