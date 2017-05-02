# ExpandableRecyclerView
Use recycler view to create expandable List View.

To complete solution of Expandable list View and Section View.</BR>
Multiple View attach in single recycler view.

# How to use it

## Step 1

### Extends ExpandableRecyclerViewAdapter

Make adapter class and extends ExpandableRecyclerViewAdapter to Override getViewHolder method that returns the object of ExpandableViewHolder.

##### here the example of adapter:-

```java
    ExpandableRecyclerViewAdapter adapter = new ExpandableRecyclerViewAdapter(addChild()) {
         @Override
         protected ExpandableViewHolder getViewHolder(int resource, ViewGroup parent) {
            switch (resource) {
                 case R.layout.list_item:
                     return new MainViewHolder(parent, resource);
                 case R.layout.sub_list1:
                     return new SubItemOneHolder(parent, resource);
                 case R.layout.sub_list2:
                     return new SubItemTwoHolder(parent, resource);
               }
            return null;
            }
        };
```
## Step 2

### Make Multiple Holder for Multiple Layouts 

##### Extends the ExpandableViewHolder and override methods

###### MainViewHolder

```java
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

```
###### SubItemOneHolder
```java
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

```
###### SubItemTwoHolder
```java
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
```

## Step 3

### Make Model According to layouts.

#### Extend ExpandableAttribute and store data as need.

Use following method to handle RecyclerView

1. setExpand(boolean isExpand)</BR>
  to define for expand or collapse the child views.</BR>
  if isExpand == true then its need to expand childs.</BR>
  
2. hasChild(bolean hasChild)</BR>
    to define if ExpandableAttribute has any Child. </BR>
    
3. doNotCollapse()</BR>
    to define if parent or child doesn't need to collapse on click.    </BR>


##### ExpandableParent

```java
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
```

##### ExpandableChild

```java
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
```


