package com.example.admin.lab_56_57;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.lab_56_57.data.ItemInfo;

import java.util.List;

/**
 * Created by Mikhail Skiy on 20.05.2015.
 */
public class AdapterForBigList extends ArrayAdapter<ItemInfo> {

    /**
     * Represent the subitems of menuItem like TextView etc. for ViewHolder patern
     */
    static class ViewHolder {
        TextView nameOfItem;
        TextView descriptionOfItem;
        ImageView image;
    }

    public AdapterForBigList (Context context,List<ItemInfo> values){
        super(context,R.layout.big_list_item,values);
    }

    @Override
    public View getView (int position,View convertView,ViewGroup parent){

        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.big_list_item,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameOfItem = (TextView)convertView.findViewById(R.id.big_list_item_title);
            viewHolder.descriptionOfItem = (TextView)convertView.findViewById(R.id.big_list_item_details);
            viewHolder.image = (ImageView)convertView.findViewById(R.id.big_list_item_image_view);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.nameOfItem.setText(getItem(position).title);
        viewHolder.descriptionOfItem.setText(getItem(position).description);
        setImage(viewHolder,position);

        return convertView;
    }

    /**
     * Sets the image depends on the position
     * @param viewHolder
     * @param position
     */
    private void setImage(ViewHolder viewHolder, int position){

        if ((position + 1) % 4 == 0) {
            viewHolder.image.setImageResource(R.mipmap.fog);
        }
        else if ((position + 1) % 2 == 0) {
            viewHolder.image.setImageResource(R.mipmap.cloudy);
        }
        else if ((position + 1) % 3 == 0) {
            viewHolder.image.setImageResource(R.mipmap.flurries);
        }
        else {
             viewHolder.image.setImageResource(R.mipmap.clear);
        }
    }
}
