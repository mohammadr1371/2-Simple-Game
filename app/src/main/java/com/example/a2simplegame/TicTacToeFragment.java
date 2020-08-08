package com.example.a2simplegame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.mrengineer13.snackbar.SnackBar;


public class TicTacToeFragment extends Fragment {

    private int[][] table = new int[3][3];

    private boolean flag = true;

    private Button mRetry;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;

    public static TicTacToeFragment newInstance() {
        TicTacToeFragment fragment = new TicTacToeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    public void findViews(View view) {
        mButton1 = view.findViewById(R.id.button1);
        mButton2 = view.findViewById(R.id.button2);
        mButton3 = view.findViewById(R.id.button3);
        mButton4 = view.findViewById(R.id.button4);
        mButton5 = view.findViewById(R.id.button5);
        mButton6 = view.findViewById(R.id.button6);
        mButton7 = view.findViewById(R.id.button7);
        mButton8 = view.findViewById(R.id.button8);
        mButton9 = view.findViewById(R.id.button9);
        mRetry = view.findViewById(R.id.button_retry_tic_tac_toe);
    }

    public void setListeners(){
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton1.setText("O");
                    mButton1.setEnabled(false);
                    table[0][0] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                } else if (flag == true){
                    mButton1.setText("X");
                    mButton1.setEnabled(false);
                    table[0][0] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton2.setText("O");
                    mButton2.setEnabled(false);
                    table[0][1] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton2.setText("X");
                    mButton2.setEnabled(false);
                    table[0][1] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton3.setText("O");
                    mButton3.setEnabled(false);
                    table[0][2] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                } else if (flag == true){
                    mButton3.setText("X");
                    mButton3.setEnabled(false);
                    table[0][2] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton4.setText("O");
                    mButton4.setEnabled(false);
                    table[1][0] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton4.setText("X");
                    mButton4.setEnabled(false);
                    table[1][0] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton5.setText("O");
                    mButton5.setEnabled(false);
                    table[1][1] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton5.setText("X");
                    mButton5.setEnabled(false);
                    table[1][1] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton6.setText("O");
                    mButton6.setEnabled(false);
                    table[1][2] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton6.setText("X");
                    mButton6.setEnabled(false);
                    table[1][2] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton7.setText("O");
                    mButton7.setEnabled(false);
                    table[2][0] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton7.setText("X");
                    mButton7.setEnabled(false);
                    table[2][0] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton8.setText("O");
                    mButton8.setEnabled(false);
                    table[2][1] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton8.setText("X");
                    mButton8.setEnabled(false);
                    table[2][1] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    mButton9.setText("O");
                    mButton9.setEnabled(false);
                    table[2][2] = 1;
                    flag = true;
                    boolean resulthor = checkTableHorizontalForOOO(table);
                    boolean resultVer = checkTableVerticalForOOO(table);
                    boolean resultObl = checkTableObliqueForOOO(table);
                    if(resulthor == true || resultVer == true|| resultObl == true){
                        Toast.makeText(getActivity(), "O wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }else if (flag == true){
                    mButton9.setText("X");
                    mButton9.setEnabled(false);
                    table[2][2] = 2;
                    flag = false;
                    boolean resulthor = checkTableHorizontalForXXX(table);
                    boolean resultVer = checkTableVerticalForXXX(table);
                    boolean resultObl = checkTableObliqueForXXX(table);
                    if(resulthor == true || resultVer == true || resultObl == true){
                        Toast.makeText(getActivity(), "X wins!", Toast.LENGTH_SHORT).show();
                        disableButtons();
                        mRetry.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        mRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRetry.setVisibility(View.GONE);
                resetGame();
            }
        });

    }

    public boolean checkTableHorizontalForOOO(int[][] table){
        for(int i = 0; i<3; i++){
            if(table[i][0] == 1 && table[i][1] == 1 && table[i][2] == 1){
                return true;
            }
        }
        return false;
    }

    public boolean checkTableVerticalForOOO(int[][] table){
        for(int i = 0; i<3; i++){
            if(table[0][i] == 1 && table[1][i] == 1 && table[2][i] == 1){
                return true;
            }
        }
        return false;
    }

    public boolean checkTableHorizontalForXXX(int[][] table){
        for(int i = 0; i<3; i++){
            if(table[i][0] == 2 && table[i][1] == 2 && table[i][2] == 2){
                return true;
            }
        }
        return false;
    }

    public boolean checkTableVerticalForXXX(int[][] table){
        for(int i = 0; i<3; i++){
            if(table[0][i] == 2 && table[1][i] == 2 && table[2][i] == 2){
                return true;
            }
        }
        return false;
    }

    public boolean checkTableObliqueForOOO(int[][] table){
        if((table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1) ||
                (table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 1) ){
            return true;
        }
        return false;
    }

    public boolean checkTableObliqueForXXX(int[][] table){
        if((table[0][0] == 2 && table[1][1] == 2 && table[2][2] == 2) ||
                (table[0][2] == 2 && table[1][1] == 2 && table[2][0] == 2) ){
            return true;
        }
        return false;
    }

    public void resetGame(){
        mButton1.setEnabled(true);
        mButton1.setText("");
        mButton2.setEnabled(true);
        mButton2.setText("");
        mButton3.setEnabled(true);
        mButton3.setText("");
        mButton4.setEnabled(true);
        mButton4.setText("");
        mButton5.setEnabled(true);
        mButton5.setText("");
        mButton6.setEnabled(true);
        mButton6.setText("");
        mButton7.setEnabled(true);
        mButton7.setText("");
        mButton8.setEnabled(true);
        mButton8.setText("");
        mButton9.setEnabled(true);
        mButton9.setText("");
        mRetry.setVisibility(View.INVISIBLE);
        flag = true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                table[i][j]  = 0;
            }
        }
    }

    public void disableButtons(){
        mButton1.setEnabled(false);
        mButton2.setEnabled(false);
        mButton3.setEnabled(false);
        mButton4.setEnabled(false);
        mButton5.setEnabled(false);
        mButton6.setEnabled(false);
        mButton7.setEnabled(false);
        mButton8.setEnabled(false);
        mButton9.setEnabled(false);
    }

}