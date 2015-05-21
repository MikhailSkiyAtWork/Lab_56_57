package com.example.admin.lab_56_57;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

import com.example.admin.lab_56_57.data.ItemInfo;


/**
 * A placeholder fragment containing a simple view.
 */
public class BigListActivityFragment extends  android.support.v4.app.Fragment{

    private AdapterForBigList adapterForBigList_;
    // Total amount of items
    private final static int COUNT = 20000;
    private final static String TITLE = "Name of item ";
    private final static String DESCRIPTION = "Description of item #";
    public BigListActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_big_list, container, false);

        String [] names = new String[COUNT];
        for (int i =0;i<names.length;i++){
            names[i]=TITLE + i;
        }

        String [] details = new String[COUNT];
        for (int i =0;i<details.length;i++){
            details[i]=DESCRIPTION + i;
        }

        List<ItemInfo> values = new ArrayList<ItemInfo>();

        for (int i = 0; i < COUNT; i++){
            ItemInfo singleItem = new ItemInfo(TITLE + i,DESCRIPTION + i);
            values.add(singleItem);
        }

        ListView listView = (ListView) rootView.findViewById(R.id.big_list_view);
        adapterForBigList_ = new AdapterForBigList(this.getActivity(),values);
        listView.setAdapter(adapterForBigList_);

        return rootView;
    }
}
