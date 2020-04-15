package com.example.tdfragment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tdfragment.Character;
import com.example.tdfragment.ISelectedItemListener;
import com.example.tdfragment.IStarWars;
import com.example.tdfragment.R;
import com.example.tdfragment.fragments.IFragmentsKey;
import com.example.tdfragment.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements IStarWars, IFragmentsKey, ISelectedItemListener,IActivities{

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
        Button button_open_map=findViewById(R.id.open_map_button);
        button_open_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MapActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFilmItemSelected(View item, int position, long id) {
        Character character =CHARACTERS[position];
        Toast.makeText(this,character.getmName(),Toast.LENGTH_LONG ).show();
        Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
        intent.putExtra(ACTIVITY_PARAMETER,CHARACTERS[position]);
        startActivity(intent);
    }
}
