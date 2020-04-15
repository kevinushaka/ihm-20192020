package com.example.ihm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  IFragmentsKey, Mocks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarFragment calendarFragment = (CalendarFragment)getSupportFragmentManager().findFragmentById(R.id.frame_calendar);
        if(calendarFragment ==null){
            calendarFragment =new CalendarFragment();
            getSupportFragmentManager().beginTransaction()
            .replace(R.id.frame_calendar, calendarFragment)
            .addToBackStack(null)
            .commit();
        }

    }
}
