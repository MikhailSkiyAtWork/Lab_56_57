package com.example.admin.lab_56_57;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.lab_56_57.data.*;

import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 22.05.2015.
 */
public class RecyclerAdapterForBigList extends RecyclerView.Adapter<ViewHolder> {

    private List<ItemInfo> listOfItems_;
    private Context context_;

    public RecyclerAdapterForBigList(Context context, List<ItemInfo> values) {
        this.context_ = context;
        this.listOfItems_ = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_list_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i){
        ItemInfo itemInfo = listOfItems_.get(i);
        holder.getTitle().setText(itemInfo.getTitle());
        holder.getDescription().setText(itemInfo.getDescription());
        setImage(holder, itemInfo.getImageId());
    }

    @Override
    public int getItemCount(){
        return(listOfItems_ != null ? listOfItems_.size() : 0);
    }

    /**
     * Sets the image depends on the position
     */
    private void setImage(ViewHolder holder, int imageId) {

        switch (imageId) {
            case 1:
                holder.getImage().setImageResource(R.mipmap.clear);
                break;
            case 2:
                holder.getImage().setImageResource(R.mipmap.cloudy);
                break;
            case 3:
                holder.getImage().setImageResource(R.mipmap.flurries);
                break;
            case 4:
                holder.getImage().setImageResource(R.mipmap.fog);
        }
    }
}
