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
     * Represent the subitems of menuItem like TextView etc. for ViewHolder pattern
     */
    private static class ViewHolder {
        TextView nameTextView_;
        TextView descriptionTextView_;
        ImageView imageView_;
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

            viewHolder.nameTextView_ = (TextView) convertView.findViewById(R.id.big_list_item_title);
            viewHolder.descriptionTextView_ = (TextView) convertView.findViewById(R.id.big_list_item_details);
            viewHolder.imageView_ = (ImageView) convertView.findViewById(R.id.big_list_item_image_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView_.setText(getItem(position).getTitle_());
        viewHolder.descriptionTextView_.setText(getItem(position).getDescription_());
        setImage(viewHolder, getItem(position).getImageId_());

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
                viewHolder.imageView_.setImageResource(R.mipmap.clear);
                break;
            case 2:
                viewHolder.imageView_.setImageResource(R.mipmap.cloudy);
                break;
            case 3:
                viewHolder.imageView_.setImageResource(R.mipmap.flurries);
                break;
            case 4:
                viewHolder.imageView_.setImageResource(R.mipmap.fog);
        }
    }
}
