package com.example.idemolifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<String> activities=new ArrayList<>();
    private TextView listActivities;
    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listActivities=(TextView)findViewById(R.id.listActivities);
        button=(Button)findViewById(R.id.changeActivity);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),ImageActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        activities.add("onStart()");
        listActivities.setText(activities.toString());
        Log.d("#INFO","onStart()");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        activities.add("onRestart()");
        listActivities.setText(activities.toString());
        super.onRestart();
    }

    @Override
    protected void onResume() {
        activities.add("onResume()");
        listActivities.setText(activities.toString());
        super.onResume();
    }

    @Override
    protected void onStop() {
        activities.add("onStop()");
        listActivities.setText(activities.toString());
        super.onStop();
    }
}
