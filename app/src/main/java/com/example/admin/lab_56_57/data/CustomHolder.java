package com.example.admin.lab_56_57.data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.lab_56_57.R;

/**
 * Created by Admin on 22.05.2015.
 */
public class CustomHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView description;
    private ImageView image;

    public TextView getTitle(){
        return title;
    }

    public TextView getDescription(){
        return description;
    }

    public ImageView getImage(){
        return image;
    }

    public CustomHolder(View view){
        super(view);
        this.title =  (TextView) view.findViewById(R.id.big_list_item_title);
        this.description = (TextView) view.findViewById(R.id.big_list_item_details);
        this.image = (ImageView) view.findViewById(R.id.big_list_item_image_view);
    }
}
