package com.example.expandable.modal;

import com.example.expandable.widget.ExpandableAttribute;

import java.util.ArrayList;

/**
 * Created by stpl on 5/2/2017.
 */

public class ExpandableParent extends ExpandableAttribute {

    private String itemName;
    private String itemCount;

    public ExpandableParent(int resourceId, String itemName, String itemCount) {
        super(resourceId);
        this.itemCount = itemCount;
        this.itemName = itemName;
    }

    protected ExpandableParent(int resourceId, ArrayList<ExpandableAttribute> expandableChildren) {
        super(resourceId, expandableChildren);
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCount() {
        return itemCount;
    }
}
