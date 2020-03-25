package com.example.tdfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IStarWars,IFragmentsKey{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment= (MainFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_list);
        if(mainFragment==null){
            mainFragment=new MainFragment();
            Bundle bundle=new Bundle();
            bundle.putParcelableArray(STAR_WARS_CHARACTERS_KEY,CHARACTERS);
            mainFragment.setArguments(bundle);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout_list,mainFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
