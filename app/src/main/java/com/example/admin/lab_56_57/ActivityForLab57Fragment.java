package com.example.admin.lab_56_57;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.admin.lab_56_57.data.*;

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

    private enum Mode_ {
        LINEAR("Linear Layout"),
        RELATIVE("Relative Layout");

        private final String text_;

        private Mode_(final String text) {
            this.text_ = text;
        }
    }

    public ActivityForLab57Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lab57_activity_fragment, container, false);

        // Get values for spinner
        String[] valuesForSpinner = getResources().getStringArray(R.array.spinner);

        // List of objects for title and description
        List<AppInfo> appInfoValues = new ArrayList<AppInfo>();

        PackageManager packageManager = getActivity().getPackageManager();
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(0);

        for (ApplicationInfo packageInfo : packages) {
            // Size of app
            double size = Utils.getSize(packageManager, packageInfo);
            // Getting icon of app
            Drawable icon = Utils.getIcon(packageManager, packageInfo);
            // Adding all values to object
            AppInfo singleItem = new AppInfo(packageInfo.packageName, packageInfo.targetSdkVersion, size,icon);
            appInfoValues.add(singleItem);
        }

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        adapterForRelative_ = new AdapterForRelative(this.getActivity(), appInfoValues);
        adapterForLinear_ = new AdapterForLinear(this.getActivity(), appInfoValues);

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
                String mode = parent.getItemAtPosition(pos).toString();
                ListView listView = (ListView) getActivity().findViewById(R.id.list_view);
                if (mode.equals(Mode_.LINEAR)) {
                    listView.setAdapter(adapterForLinear_);
                    adapterForRelative_.notifyDataSetChanged();
                } else if (mode.equals(Mode_.RELATIVE)) {
                    listView.setAdapter(adapterForRelative_);
                    adapterForLinear_.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // Nothing to do
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
