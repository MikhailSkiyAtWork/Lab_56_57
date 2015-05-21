package com.example.admin.lab_56_57;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mikhail Valuyskiy on 18.05.2015.
 */

/**
 * Custom adapter for showing images, text fields and small icon. Based on LinearLayout
 */
public class AdapterForLinear extends ArrayAdapter<String> {
    private final Context context_;

    // values for details
    private final String [] details;

    public AdapterForLinear(Context context, String[] values, String[] details){
        super(context, R.layout.linear_list_item, values);
        this.context_ = context;
        this.details = details;
    }

    //TODO Add List of Objects {Title/Details}
    @Override
    public View getView(int position, View convertView,ViewGroup parent){
        View view = LayoutInflater.from(context_).inflate(R.layout.linear_list_item, parent, false);
        TextView nameOfCapital = (TextView) view.findViewById(R.id.list_item_title);
        TextView detailsOfCapital = (TextView) view.findViewById(R.id.list_item_details);
        ImageView image = (ImageView) view.findViewById(R.id.list_item_image_view);
        ImageView smallImage = (ImageView) view.findViewById(R.id.list_item_small_image);

        nameOfCapital.setText(getItem(position));
        detailsOfCapital.setText(details[position]);
        image.setImageResource(R.mipmap.ic_launcher);
        smallImage.setImageResource(R.mipmap.ic_launcher);

        // This code helps hide every second description field
        if ((position + 1)%2 == 0){
            detailsOfCapital.setVisibility(View.INVISIBLE);
        }
        // This code helps hide every 3rd image in ListView
        if ((position + 1) % 3 == 0) {
            smallImage.setVisibility(View.INVISIBLE);
        }

        return view;
    }

}
