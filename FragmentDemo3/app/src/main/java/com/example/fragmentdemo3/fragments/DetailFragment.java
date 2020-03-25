package com.example.fragmentdemo3.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragmentdemo3.R;

import java.util.ArrayList;

public class DetailFragment extends Fragment implements IMultipleActivityAndFragment {
    public DetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        int valeurAffichee = 0;
        if (getArguments() != null) {
            valeurAffichee = getArguments().getInt(FRAGMENT_PARAMETER);
        }
        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setText("Table de " + valeurAffichee);
        ArrayList list = new ArrayList();

        for (int i = 0; i < 20; i++) {
            list.add(i + " * " + valeurAffichee + " = " + i * valeurAffichee);
        }
        ListView listView = rootView.findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        return rootView;
    }
}