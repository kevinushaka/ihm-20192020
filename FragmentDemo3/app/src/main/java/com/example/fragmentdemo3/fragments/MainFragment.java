package com.example.fragmentdemo3.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fragmentdemo3.activities.IButtonClickedListener;
import com.example.fragmentdemo3.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private IButtonClickedListener mCallBack;
    public MainFragment(){

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mCallBack=(IButtonClickedListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_main,container,false);
        rootView.findViewById(R.id.fragment_main_button_activity).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_main_button_fragment).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_main_button_clean).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View button) {
        if(button.getId()==R.id.fragment_main_button_activity){
            mCallBack.onButtonActivityClicked(button);
        }
        if(button.getId()==R.id.fragment_main_button_fragment){
            mCallBack.onButtonFragmentClicked(button);
        }
        if(button.getId()==R.id.fragment_main_button_clean){
            mCallBack.onButtonClearFragmentClicked(button);
        }
    }
}
