package com.example.admin.lab_56_57;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.admin.lab_56_57.data.ItemInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ActivityForLab57Fragment extends android.support.v4.app.Fragment {

    private AdapterForLinear adapterForLinear_;
    private AdapterForRelative adapterForRelative_;
    private Spinner menuSpinner_;
    private ArrayAdapter<String> spinnerAdapter_;
    private final String LINEAR = "Linear Layout";
    private final String RELATIVE = "Relative Layout";

    public ActivityForLab57Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_for_lab57, container, false);

        // Get values for spinner
        String[] valuesForSpinner = getResources().getStringArray(R.array.spinner);

        // Get capitals from array
        String [] titles = getResources().getStringArray(R.array.capitals);

        // Get details about capitals from array
        String [] details = getResources().getStringArray(R.array.description);

        // List of objects for title and description
        List<ItemInfo> values = new ArrayList<ItemInfo>();

        // Just make sure that the number of items are equal
        // Otherwise not all items will have description or title
        // May cause errors
        if (titles.length == details.length) {
            // Add values for menu item into List
            for (int i=0;i<titles.length;i++) {
                ItemInfo singleItem = new ItemInfo(titles[i], details[i]);
                values.add(singleItem);
            }
        }
        else
        {
            Log.e("WARNING","The number of titles is not equal to the number of description");
        }


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        adapterForRelative_ = new AdapterForRelative(this.getActivity(),values);
        adapterForLinear_ = new AdapterForLinear(this.getActivity(),values);

        listView.setAdapter(adapterForLinear_);

        spinnerAdapter_ = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                valuesForSpinner
        );

        menuSpinner_ = (Spinner) rootView.findViewById(R.id.menu_spinner);
        menuSpinner_.setAdapter(spinnerAdapter_);

        menuSpinner_.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String city = parent.getItemAtPosition(pos).toString();
                ListView listView = (ListView) getActivity().findViewById(R.id.list_view);
                if (city.equals(LINEAR)) {
                    listView.setAdapter(adapterForLinear_);
                    adapterForRelative_.notifyDataSetChanged();
                } else if (city.equals(RELATIVE)) {
                    listView.setAdapter(adapterForRelative_);
                    adapterForLinear_.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        ListView listView = (ListView) getActivity().findViewById(R.id.list_view);
        listView.setAdapter (adapterForRelative_);
    }
}
