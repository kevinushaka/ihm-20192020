package com.example.tdfragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.Console;
import java.util.ArrayList;

public class MainFragment extends Fragment implements IFragmentsKey {

    public  MainFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_main,container,false);

        Character[] charactersList = new Character[]{};
        if (getArguments() != null) {
            charactersList = (Character[]) getArguments().getParcelableArray(STAR_WARS_CHARACTERS_KEY);
        }
        ArrayList list = new ArrayList();

        for (int i = 0; i < charactersList.length; i++) {
            list.add(charactersList[i].getmName());
            Log.i("MAINFRAGMENT",charactersList[i].getmName());

        }
        ListView listView = rootView.findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
       return rootView;
    }
}
