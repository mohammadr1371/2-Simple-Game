package com.example.a2simplegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_layout);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_start);
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment startFragment = fragmentManager.findFragmentById(R.id.activity_start);
                if(startFragment == null){
                    fragmentManager.beginTransaction()
                            .add(R.id.activity_start , StartFragment.newInstance())
                            .commit();
                }
            }
        }, 8000);
    }
}