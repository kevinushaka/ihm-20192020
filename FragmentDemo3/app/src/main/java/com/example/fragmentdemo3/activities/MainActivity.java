package com.example.fragmentdemo3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentdemo3.R;
import com.example.fragmentdemo3.activities.IButtonClickedListener;
import com.example.fragmentdemo3.fragments.DetailFragment;
import com.example.fragmentdemo3.fragments.IMultipleActivityAndFragment;
import com.example.fragmentdemo3.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements IButtonClickedListener, IMultipleActivityAndFragment {
    private DetailFragment detailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment= (MainFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_saisie);
        if(mainFragment==null){
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout_saisie,new MainFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private int getTableValue(){
        EditText editText=findViewById(R.id.editText);
        InputMethodManager imm=(InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(),0);
        int result;
        try{
            result=Integer.parseInt(editText.getText().toString());
        }catch (NumberFormatException e){
            result=0;
        }
        return result;
    }

    @Override
    public void onButtonActivityClicked(View button) {
        int valeur =getTableValue();
        Toast.makeText(this,"Nouvelle activité avec "+ valeur,Toast.LENGTH_LONG ).show();
        Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
        intent.putExtra(ACTIVITY_PARAMETER,valeur);
        startActivity(intent);
    }

    @Override
    public void onButtonFragmentClicked(View button) {
            int valeur =getTableValue();
        Toast.makeText(this,"En-dessous avec "+ valeur,Toast.LENGTH_LONG ).show();
        detailFragment = new DetailFragment();
            Bundle args=new Bundle();
            args.putInt(FRAGMENT_PARAMETER,valeur);
            detailFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_detail,detailFragment)
                    .commit();

    }

    @Override
    public void onButtonClearFragmentClicked(View button) {
        Toast.makeText(this,"Supprimer le fragment en-dessou s ",Toast.LENGTH_LONG ).show();
        ((EditText)findViewById(R.id.editText)).setText("");
        if(detailFragment!=null){
             getSupportFragmentManager().beginTransaction().remove(detailFragment).commit();
        }
    }
}
