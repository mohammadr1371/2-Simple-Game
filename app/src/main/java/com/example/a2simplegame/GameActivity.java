package com.example.a2simplegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2simplegame.R;

public class GameActivity extends AppCompatActivity {

    private Button mGameTicTacToe;
    private Button mGame4InRow;
    private boolean flag;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViews();
        flag = getIntent().getBooleanExtra(StartFragment.FLAG_OF_START , false);
        setFirstFragment();
        setListeners();
    }

    private void findViews(){
        mGameTicTacToe = findViewById(R.id.game_button_tic_tac_toe);
        mGame4InRow = findViewById(R.id.game_button_4_in_row);
    }

    private void setFirstFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(flag == true){
            fragmentManager.beginTransaction()
                    .add(R.id.game_fragment_layout, TicTacToeFragment.newInstance())
                    .commit();
        } else if(flag == false){
            fragmentManager.beginTransaction()
                    .add(R.id.game_fragment_layout , FourInRowFragment.newInstance())
                    .commit();
        }
    }

    private void setListeners(){

        mGame4InRow.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentManager = getSupportFragmentManager();

            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.game_fragment_layout, FourInRowFragment.newInstance())
                        .commit();
            }
        });

        mGameTicTacToe.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentManager = getSupportFragmentManager();

            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.game_fragment_layout, TicTacToeFragment.newInstance())
                        .commit();
            }
        });
    }

}