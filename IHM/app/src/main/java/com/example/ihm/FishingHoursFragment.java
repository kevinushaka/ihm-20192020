package com.example.ihm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FishingHoursFragment extends Fragment implements IFragmentsKey, AdapterView.OnItemClickListener {

    private ISelectedItemListener mCallBack;

    public FishingHoursFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_fishing_hours_list,container,false);
        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        Event[] eventsList = new Event[]{};
        if (getArguments() != null) {
            eventsList = (Event[]) getArguments().getParcelableArray(FISHING_HOURS_LIST);
        }
        ArrayList list = new ArrayList();

        for (int i = 0; i < eventsList.length; i++) {
            list.add(eventsList[i]);

        }

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //mCallBack.onHourItemSelected(view,position,id);
    }
}
