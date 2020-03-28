package com.example.tdfragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment implements IFragmentsKey {
    public DetailFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Character character=null;
        if (getArguments() != null) {
            character = (Character) getArguments().getParcelable(CHARACTER_DETAILED);
        }

            TextView name =rootView.findViewById(R.id.name);
            TextView comment=rootView.findViewById(R.id.comment);
            ImageView image=rootView.findViewById(R.id.imageProfile);
            name.setText(character.getmName());
            comment.setText(character.getmDescription());
            image.setImageResource(character.getmImage());


        return rootView;
    }
}
