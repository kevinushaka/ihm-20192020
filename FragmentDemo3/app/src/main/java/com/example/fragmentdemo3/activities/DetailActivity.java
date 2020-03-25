package com.example.fragmentdemo3.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentdemo3.R;
import com.example.fragmentdemo3.fragments.DetailFragment;
import com.example.fragmentdemo3.fragments.IMultipleActivityAndFragment;
import com.example.fragmentdemo3.fragments.MainFragment;

public class DetailActivity extends AppCompatActivity implements IMultipleActivityAndFragment {
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       Intent intent= getIntent();
       int entier=intent.getIntExtra(ACTIVITY_PARAMETER,1);
       DetailFragment detailFragment= new DetailFragment();
       Bundle args= new Bundle();
       args.putInt(FRAGMENT_PARAMETER,entier);
       detailFragment.setArguments(args);
       getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_detail,detailFragment).commit();

    }
}
