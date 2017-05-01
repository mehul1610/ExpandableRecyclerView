package com.example.expandable.modal;


/**
 * Created by stpl on 4/26/2017.
 */

public interface ExpandableProperty {

    int getResourceId();

    boolean isExpand();

    void setExpand(boolean expand);

    boolean hasChild();

    void setHasChild(boolean hasChild);

    void doNotCollapse();

    boolean isDoNotCollapse();

    void setValue(Object value);

    Object getValue();
}
