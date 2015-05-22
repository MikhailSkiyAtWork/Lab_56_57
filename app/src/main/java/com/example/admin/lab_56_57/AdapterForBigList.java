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

/**
 * Custom adapter for big list
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

    public AdapterForBigList(Context context, List<ItemInfo> values) {
        super(context, R.layout.big_list_item, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.big_list_item, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.nameOfItem = (TextView) convertView.findViewById(R.id.big_list_item_title);
            viewHolder.descriptionOfItem = (TextView) convertView.findViewById(R.id.big_list_item_details);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.big_list_item_image_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameOfItem.setText(getItem(position).title);
        viewHolder.descriptionOfItem.setText(getItem(position).description);
        setImage(viewHolder, getItem(position).imageId);

        return convertView;
    }

    /**
     * Sets the image depends on the position
     *
     * @param viewHolder
     * @param imageId
     */
    private void setImage(ViewHolder viewHolder, int imageId) {

        switch (imageId) {
            case 1:
                viewHolder.image.setImageResource(R.mipmap.clear);
                break;
            case 2:
                viewHolder.image.setImageResource(R.mipmap.cloudy);
                break;
            case 3:
                viewHolder.image.setImageResource(R.mipmap.flurries);
                break;
            case 4:
                viewHolder.image.setImageResource(R.mipmap.fog);
        }
    }
}
