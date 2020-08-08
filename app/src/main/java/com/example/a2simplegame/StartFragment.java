package com.example.a2simplegame;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StartFragment extends Fragment {

    public static final String FLAG_OF_START = "flag of start";
    private TextView mStartTexView;

    private Button mTicTacToe;
    private Button m4InRow;
    private Button mExit;

    private boolean flag;

    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    public void findViews(View view){
        mStartTexView = view.findViewById(R.id.textView_start);
        mTicTacToe = view.findViewById(R.id.button_tic_tac_toe_start);
        m4InRow = view.findViewById(R.id.button_4_in_row_start);
        mExit = view.findViewById(R.id.button_exit);
    }

    public void setListeners(){

        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        mTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = true;
                Intent intent = new Intent(getActivity() , GameActivity.class);
                intent.putExtra(FLAG_OF_START , flag );
                startActivity(intent);
            }
        });

        m4InRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = false;
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(FLAG_OF_START , flag);
                startActivity(intent);
            }
        });
    }
}