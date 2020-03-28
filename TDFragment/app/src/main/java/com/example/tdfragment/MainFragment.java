package com.example.tdfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainFragment extends Fragment implements IFragmentsKey, AdapterView.OnItemClickListener {

    private ISelectedItemListener mCallBack;

    public  MainFragment(){


    }


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mCallBack=(ISelectedItemListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_list,container,false);
        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        Character[] charactersList = new Character[]{};
        if (getArguments() != null) {
            charactersList = (Character[]) getArguments().getParcelableArray(STAR_WARS_CHARACTERS_KEY);
        }
        ArrayList list = new ArrayList();

        for (int i = 0; i < charactersList.length; i++) {
            list.add(charactersList[i].getmName());

        }

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
       return rootView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCallBack.onFilmItemSelected(view,position,id);
    }
}
