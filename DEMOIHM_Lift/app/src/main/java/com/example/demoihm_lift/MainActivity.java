package com.example.demoihm_lift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer {
    public static final int LAST_LEVEL = +3;
    public static final int FIRST_LEVEL = 0;
    private int currentLevel = 0;
    private LevelSensor levelSensor = new LevelSensor();
    private Lift lift = new Lift( levelSensor );
    private TextView tvCurrentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //récupérer les widgets
        tvCurrentLevel = findViewById(R.id.tvCurrentLevel);


        findViewById(R.id.buttonUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( currentLevel < LAST_LEVEL ) {
                    tvCurrentLevel.setText("???");
                    lift.move(findViewById(R.id.imageLift), ++currentLevel );
                }
            }
        });

        findViewById(R.id.buttonDown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( currentLevel > FIRST_LEVEL ) {
                    tvCurrentLevel.setText("???");
                    lift.move(findViewById(R.id.imageLift), --currentLevel );
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        currentLevel=(Integer)arg;
        tvCurrentLevel.setText(currentLevel);
    }
}
