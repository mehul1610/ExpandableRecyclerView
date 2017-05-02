package com.example.expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.expandable.adapter.ExpandableRecyclerViewAdapter;
import com.example.expandable.holder.MainViewHolder;
import com.example.expandable.holder.SubItemOneHolder;
import com.example.expandable.holder.ExpandableViewHolder;
import com.example.expandable.holder.SubItemTwoHolder;
import com.example.expandable.modal.ExpandableChild;
import com.example.expandable.modal.ExpandableParent;
import com.example.expandable.widget.ExpandableAttribute;
import com.example.expandable.sample.R;

import java.util.ArrayList;
import java.util.Random;

public class ActivityExpandableListView extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        recyclerView = (RecyclerView) findViewById(R.id.activity_expandable_list_view);
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.swapAdapter(adapter, false);
    }

    private ArrayList<ExpandableAttribute> addChild() {
        ArrayList<ExpandableAttribute> children = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            ExpandableParent parent = new ExpandableParent(R.layout.list_item, "Parent item", (i + 1) + "");
            Random random = new Random();
            for (int j = 0; j < random.nextInt(6) + 2; j++) {
                ExpandableChild child1 = getChild(R.layout.sub_list1, (j + 1));
                parent.addChild(child1);
                child1.setExpand(random.nextBoolean());
                for (int k = 0; k < random.nextInt(8) + 4; k++)
                    child1.addChild(getChild(R.layout.sub_list2, k + 1));
            }
            parent.setExpand(random.nextBoolean());
            children.add(parent);
        }
        return children;
    }

    private ExpandableChild getChild(int resource, int value) {
        ExpandableChild child = new ExpandableChild(resource);
        child.setValue("Sub Item " + value);
        return child;
    }
}
