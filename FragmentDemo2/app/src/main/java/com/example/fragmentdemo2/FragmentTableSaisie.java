package com.example.fragmentdemo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentTableSaisie extends Fragment implements IFragmentTable{

    public FragmentTableSaisie(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_saisie,container,false);
        final EditText valeur = rootView.findViewById(R.id.valeur);

        rootView.findViewById(R.id.valid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valeur.getText().length()!=0){
                    int table =Integer.parseInt(valeur.getText().toString());
                    Fragment fragment=new FragmentTableAfficher();
                    Bundle args=new Bundle();
                    args.putInt(KEY,table);
                    fragment.setArguments(args);

                    getFragmentManager().beginTransaction().replace(R.id.contenuTable,fragment).commit();
                }
            }
        });
        return rootView;
    }
}
