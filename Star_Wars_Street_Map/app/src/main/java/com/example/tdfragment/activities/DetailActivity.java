package com.example.tdfragment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tdfragment.R;
import com.example.tdfragment.fragments.DetailFragment;
import com.example.tdfragment.fragments.IFragmentsKey;

public class DetailActivity extends AppCompatActivity implements IFragmentsKey,IActivities {
    private DetailFragment detailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);
        Intent intent= getIntent();
        Parcelable character=intent.getParcelableExtra(ACTIVITY_PARAMETER);
        detailFragment= new DetailFragment();
        Bundle args= new Bundle();
        args.putParcelable(CHARACTER_DETAILED,character);
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_detail,detailFragment).commit();

    }
}
