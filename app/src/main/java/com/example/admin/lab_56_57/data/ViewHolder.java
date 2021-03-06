package com.example.admin.lab_56_57.data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.lab_56_57.R;

/**
 * Created by Admin on 22.05.2015.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView title_;
    private TextView description_;
    private ImageView image_;

    public ViewHolder(View view){
        super(view);
        this.title_ =  (TextView) view.findViewById(R.id.big_list_item_title);
        this.description_ = (TextView) view.findViewById(R.id.big_list_item_details);
        this.image_ = (ImageView) view.findViewById(R.id.big_list_item_image_view);
    }

    public TextView getTitle() {
        return title_;
    }

    public TextView getDescription() {
        return description_;
    }

    public ImageView getImage() {
        return image_;
    }
}
