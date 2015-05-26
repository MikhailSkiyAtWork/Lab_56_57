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

    private static class ViewHolder {
        TextView nameTextView_;
        TextView detailsTextView_;
        ImageView imageView_;
        ImageView smallImageView_;
    }

    public AdapterForRelative(Context context, List<AppInfo> values) {
        super(context, R.layout.relative_list_item, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.relative_list_item, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView_ = (TextView) convertView.findViewById(R.id.list_item_title);
            viewHolder.detailsTextView_ = (TextView) convertView.findViewById(R.id.list_item_details);
            viewHolder.imageView_ = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            viewHolder.smallImageView_ = (ImageView) convertView.findViewById(R.id.list_item_small_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView_.setText(getItem(position).getTitle_());
        viewHolder.detailsTextView_.setText(Utils.makeDescription(getItem(position).getTargetSdkVersion_(), getItem(position).getSize_()));
        viewHolder.imageView_.setImageResource(R.mipmap.ic_launcher);
        viewHolder.smallImageView_.setImageDrawable(getItem(position).getIcon_());

        // This code helps hide every second description field
        if (Utils.isItSecondItem(position)) {
            viewHolder.detailsTextView_.setVisibility(View.INVISIBLE);
        }
        // This code helps hide every 3rd image in ListView
        if (Utils.isItThirdItem(position)) {
            viewHolder.smallImageView_.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

}
