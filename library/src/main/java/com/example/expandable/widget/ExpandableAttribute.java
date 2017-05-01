package com.example.expandable.widget;

import com.example.expandable.modal.ExpandableProperty;

import java.util.ArrayList;

/**
 * Created by stpl on 4/25/2017.
 */

public abstract class ExpandableAttribute implements ExpandableProperty {
    protected Object object;
    private boolean isExpand = true;
    private boolean hasChild;
    private boolean doNotCollapse = false;
    private int resourceId;

    private ArrayList<ExpandableAttribute> expandableChildren;

    protected ExpandableAttribute(int resourceId) {
        this.resourceId = resourceId;
    }

    protected ExpandableAttribute(int resourceId, ArrayList<ExpandableAttribute> expandableChildren) {
        this(resourceId);
        this.expandableChildren = expandableChildren;
        if (expandableChildren != null && expandableChildren.size() > 0)
            hasChild = true;
    }

    @Override
    public boolean isExpand() {
        return isExpand;
    }

    @Override
    public boolean hasChild() {
        return hasChild;
    }

    @Override
    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    @Override
    public void doNotCollapse() {
        doNotCollapse = false;
    }

    @Override
    public boolean isDoNotCollapse() {
        return doNotCollapse;
    }

    @Override
    public void setExpand(boolean expand) {
        this.isExpand = expand;
        if (!isExpand)
            setExpandALL(false);
    }

    @Override
    public int getResourceId() {
        return resourceId;
    }

    public ArrayList<ExpandableAttribute> getChildren() {
        return expandableChildren;
    }

    public void addChild(ExpandableAttribute child) {
        hasChild = true;
        if (expandableChildren == null)
            expandableChildren = new ArrayList<>();
        expandableChildren.add(child);
    }

    private int getCount(ExpandableAttribute child) {
        int i = 0;
        if (child.hasChild && child.isExpand) {
            for (ExpandableAttribute expandableChild : child.getChildren())
                i += getCount(expandableChild);
            return i + child.getChildren().size();
        }
        return i;
    }

    public void setExpandALL(boolean isExpand) {
        getChild(this, isExpand);
    }

    private void getChild(ExpandableAttribute attribute, boolean isExpand) {
        if (attribute.hasChild) {
            for (ExpandableAttribute child : attribute.getChildren()) {
                getChild(child, isExpand);
            }
        }
        attribute.isExpand = isExpand;
    }


    public final int getCountList() {
        return getCount(this);
    }
}
