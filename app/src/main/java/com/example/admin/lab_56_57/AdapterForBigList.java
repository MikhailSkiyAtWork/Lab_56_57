package com.example.admin.lab_56_57;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mikhail Skiy on 20.05.2015.
 */
public class AdapterForBigList extends ArrayAdapter {

    private static final String CLEAR = "clear.png";
    private static final String CLOUDY = "cloudy.png";
    private static final String FLURRIES = "flurries.png";
    private static final String FOG= "fog.png";
    private final Context context;
    // values for name of item
    private final String [] names;
    // values for details
    private final String [] details;

    static class ViewHolder {
        TextView nameOfItem;
        TextView descriptionOfItem;
        ImageView image;
    }

    public AdapterForBigList (Context context,String[] names,String[] details){
        super(context,R.layout.big_list_item);
        this.context = context;
        this.names = names;
        this.details = details;
    }


    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public View getView (int position,View convertView,ViewGroup parent){

        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.big_list_item,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.nameOfItem = (TextView)convertView.findViewById(R.id.big_list_item_title);
            viewHolder.descriptionOfItem = (TextView)convertView.findViewById(R.id.big_list_item_details);
            viewHolder.image = (ImageView)convertView.findViewById(R.id.big_list_item_image_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.nameOfItem.setText(names[position]);
        viewHolder.descriptionOfItem.setText(details[position]);
        setImage(viewHolder,position);

        return convertView;
    }

    /**
     * Sets the image depend on the position
     * @param viewHolder
     * @param position
     */
    private void setImage(ViewHolder viewHolder, int position){

        if ((position + 1) % 2 == 0) {
            viewHolder.image.setImageResource(R.mipmap.cloudy);
        }
        else if ((position + 1) % 3 == 0) {
            viewHolder.image.setImageResource(R.mipmap.flurries);
        }
        else if ((position + 1) % 4 == 0) {
            viewHolder.image.setImageResource(R.mipmap.fog);
        }
        else {
             viewHolder.image.setImageResource(R.mipmap.clear);
        }
    }
}
