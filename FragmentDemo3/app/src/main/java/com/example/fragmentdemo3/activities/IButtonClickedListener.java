package com.example.fragmentdemo3.activities;

import android.view.View;

public interface IButtonClickedListener {
    void onButtonActivityClicked(View button);
    void onButtonFragmentClicked(View button);
    void onButtonClearFragmentClicked(View button);
}
