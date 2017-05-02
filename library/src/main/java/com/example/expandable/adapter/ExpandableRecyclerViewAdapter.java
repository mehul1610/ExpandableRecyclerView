package com.example.expandable.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.expandable.widget.ExpandableAttribute;
import com.example.expandable.holder.ExpandableViewHolder;
import com.example.expandable.modal.RecyclerItemClickListener;

import java.util.ArrayList;

/**
 * Created by stpl on 3/1/2016.
 */
public abstract class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableViewHolder> {

    private ArrayList<ExpandableAttribute> children;
    private RecyclerItemClickListener itemClickListener;

    public ExpandableRecyclerViewAdapter(ArrayList<ExpandableAttribute> children) {
        this.children = children;
    }

    @Override
    public ExpandableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(viewType, parent);
    }

    @Override
    public void onBindViewHolder(final ExpandableViewHolder holder, int position) {
        if (holder != null) {
            ExpandableAttribute attribute = getViewOnPosition(position);
            holder.setData(attribute);
            holder.itemView.setTag(attribute);
            if (itemClickListener != null) {
                holder.itemView.setClickable(true);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExpandableAttribute attribute = (ExpandableAttribute) v.getTag();
                    if (itemClickListener != null)
                        itemClickListener.onItemClickListener(holder, holder.itemView, holder.getAdapterPosition());
                    if (attribute != null && !attribute.isDoNotCollapse()) {
                        if (attribute.isExpand()) {
                            setCollapse(attribute, holder.getAdapterPosition());
                            attribute.setExpand(false);
                            holder.onCollapse(attribute);
                        } else {
                            attribute.setExpand(true);
                            setExpand(attribute, holder.getAdapterPosition());
                            holder.onExpand(attribute);
                        }
                    }
                }
            });
        }
    }

    private void setExpand(ExpandableAttribute attribute, int position) {
        for (int i = 1; i <= attribute.getCountList(); i++) {
            notifyItemInserted(position + i);
        }
    }

    private void setCollapse(ExpandableAttribute attribute, int position) {
        int count = 0;
        //TODO: need to work on it
        for (int i = attribute.getCountList(); i > 0; i--) {
            Log.d("Collapse", ++count + "");
            notifyItemRemoved(position + i);
        }

//        notifyItemRangeRemoved(position + 1, attribute.getCountList() - 1);
    }

    @Override
    public final int getItemCount() {
        int count = 0;
        for (ExpandableAttribute child : children)
            count += child.getCountList();
        count += children.size();
        System.out.println("TOTAL COUNT ::->" + count);
        return count;
    }

    @Override
    public final int getItemViewType(int position) {
        System.out.println("getITemView Type ::->");
        ExpandableAttribute attribute = getViewOnPosition(position);
        if (attribute != null)
            return attribute.getResourceId();
        return 0;
    }

    public RecyclerItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(RecyclerItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    public void addChild(ExpandableAttribute child) {
        if (children == null)
            children = new ArrayList<>();
        children.add(child);
    }

    public void removeChild(int index) {
        if (children == null)
            return;
        children.remove(index);
    }

    public void removeChild(ExpandableAttribute child) {
        if (children == null)
            return;
        children.remove(child);
    }

    public void addChild(int index, ExpandableAttribute child) {
        children.add(index, child);
    }

    protected final ExpandableAttribute getViewOnPosition(int position) {
        Integer[] count = {-1};
        for (ExpandableAttribute expandableChild : children) {
            if (count[0] == position)
                return expandableChild;
            ExpandableAttribute child = getChild(expandableChild, count, position);
            if (child != null)
                return child;
//            else   // this code working only for one child not for multiple Child and there childs
//                count[0] += expandableChild.getCountList() + 1;
        }
        return null;
    }

    private ExpandableAttribute getChild(ExpandableAttribute child, Integer[] count, int position) {
        count[0]++;
        if (count[0] == position)
            return child;
        if (child.hasChild() && child.isExpand())
            for (ExpandableAttribute expandableChild : child.getChildren()) {
                ExpandableAttribute child1 = getChild(expandableChild, count, position);
                if (child1 != null)
                    return child1;
//                else  // same as above not worked for multiple child and their respective
//                    count[0]++;
            }
        return null;
    }

    protected abstract ExpandableViewHolder getViewHolder(int resource, ViewGroup parent);
}
