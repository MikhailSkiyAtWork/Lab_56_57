package com.example.admin.lab_56_57;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
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

import com.example.admin.lab_56_57.data.*;

import java.io.File;
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

        // List of objects for title and description
        List<AppInfo> values = new ArrayList<AppInfo>();


        final PackageManager pm = getActivity().getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);

        double size = 0;
        for (ApplicationInfo packageInfo : packages) {
            try {
                File file = new File(packageInfo.sourceDir);
                size = file.length();
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage());
            }

            AppInfo singleItem = new AppInfo(packageInfo.packageName, packageInfo.targetSdkVersion, size);
            values.add(singleItem);
        }

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        adapterForRelative_ = new AdapterForRelative(this.getActivity(), values);
        adapterForLinear_ = new AdapterForLinear(this.getActivity(), values);

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
    public void onResume() {
        super.onResume();
        ListView listView = (ListView) getActivity().findViewById(R.id.list_view);
        listView.setAdapter(adapterForRelative_);
    }
}
