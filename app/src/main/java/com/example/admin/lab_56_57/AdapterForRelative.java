package com.example.admin.lab_56_57;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.lab_56_57.data.AppInfo;

import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 18.05.2015.
 */

/**
 * Custom adapter, which based on RelativeLayout
 */
public class AdapterForRelative extends ArrayAdapter<AppInfo> {

    private static class ViewHolder_ {
        TextView nameOfCapitalView;
        TextView detailsOfCapitalView;
        ImageView imageView;
        ImageView smallImageView;
    }

    public AdapterForRelative(Context context, List<AppInfo> values) {
        super(context, R.layout.relative_list_item, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder_ viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.relative_list_item, parent, false);
            viewHolder = new ViewHolder_();

            viewHolder.nameOfCapitalView = (TextView) convertView.findViewById(R.id.list_item_title);
            viewHolder.detailsOfCapitalView = (TextView) convertView.findViewById(R.id.list_item_details);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            viewHolder.smallImageView = (ImageView) convertView.findViewById(R.id.list_item_small_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder_) convertView.getTag();
        }

        viewHolder.nameOfCapitalView.setText(getItem(position).getTitle_());
        viewHolder.detailsOfCapitalView.setText(Utils.makeDescription(getItem(position).getTargetSdkVersion_(), getItem(position).getSize_()));
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        viewHolder.smallImageView.setImageDrawable(getItem(position).getIcon_());

        // This code helps hide every second description field
        if (Utils.isItSecondItem(position)) {
            viewHolder.detailsOfCapitalView.setVisibility(View.INVISIBLE);
        }
        // This code helps hide every 3rd image in ListView
        if (Utils.isItThirdItem(position)) {
            viewHolder.smallImageView.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

}
