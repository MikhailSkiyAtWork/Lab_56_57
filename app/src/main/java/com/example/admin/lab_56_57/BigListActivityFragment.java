package com.example.admin.lab_56_57;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.UUID;

import com.example.admin.lab_56_57.data.ItemInfo;


/**
 * A placeholder fragment containing a simple view.
 */
public class BigListActivityFragment extends  android.support.v4.app.Fragment{

    private RecyclerAdapterForBigList adapterForBigList_;
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

        List<ItemInfo> values = new ArrayList<ItemInfo>();

        int fictionalId = 1;
        for (int i = 0; i < COUNT; i++) {
            String randomString = UUID.randomUUID().toString();
            ItemInfo singleItem = new ItemInfo(fictionalId, TITLE + i, DESCRIPTION + i + randomString);
            values.add(singleItem);
            fictionalId++;
            if (fictionalId > 4) {
                fictionalId = 1;
            }
        }

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        adapterForBigList_ = new RecyclerAdapterForBigList(this.getActivity(),values);
        recyclerView.setAdapter(adapterForBigList_);

        return rootView;
    }
}
