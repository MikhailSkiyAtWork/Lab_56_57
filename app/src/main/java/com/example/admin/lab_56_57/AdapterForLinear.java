package com.example.admin.lab_56_57;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.lab_56_57.data.*;

import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 18.05.2015.
 */

/**
 * Custom adapter for showing images, text fields and small icon. Based on LinearLayout
 */
public class AdapterForLinear extends ArrayAdapter<AppInfo> {

    public AdapterForLinear(Context context, List<AppInfo> values){
        super(context, R.layout.linear_list_item, values);

    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.linear_list_item, parent, false);
        TextView nameOfCapital = (TextView) view.findViewById(R.id.list_item_title);
        TextView detailsOfCapital = (TextView) view.findViewById(R.id.list_item_details);
        ImageView image = (ImageView) view.findViewById(R.id.list_item_image_view);
        ImageView smallImage = (ImageView) view.findViewById(R.id.list_item_small_image);

        nameOfCapital.setText(getItem(position).getTitle());
        detailsOfCapital.setText(Utility.makeDescription(getItem(position).getTargetSdkVersion(),getItem(position).getSize()));
        image.setImageResource(R.mipmap.ic_launcher);
        smallImage.setImageDrawable(getItem(position).getIcon());

        // This code helps hide every second description field
        if (Utility.isItSecondItem(position)){
            detailsOfCapital.setVisibility(View.INVISIBLE);
        }
        // This code helps hide every 3rd image in ListView
        if (Utility.isItThirdItem(position)) {
            smallImage.setVisibility(View.INVISIBLE);
        }

        return view;
    }

}
