package com.example.fragmentdemo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentTableAfficher extends Fragment implements IFragmentTable {
    private int valeurTable;

    public FragmentTableAfficher(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(getArguments()!=null){
            valeurTable =getArguments().getInt(KEY);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView= inflater.inflate(R.layout.fragment_table_afficher,container,false);
        ArrayList list=new ArrayList();
        for(int i =0 ; i<20;i++){
            list.add(i +" * "+ valeurTable+" = "+ i*valeurTable);
        }
        ListView listView=rootView.findViewById(R.id.listView);
        ArrayAdapter adapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
