package com.example.a2simplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;


public class SettingFragment extends Fragment {

    public static final String BOOLEAN_KEY_OF_TABLE = "com.example.a2simplegame_boolean_key_of_table";
    public static final String INT_KEY_OF_COLOR = "com.example.a2simplegame_int_key_of_color";

    private boolean mIs55Selected = false;
    private int mColorInt = 0;

    private RadioButton m44Button;
    private RadioButton m55Button;
    private RadioButton mBackgroundYellow;
    private RadioButton mBackgroundWithe;

    private Button mApply;
    private Button mBack;

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        findViews(view);
        setListener();

        return view;
    }

    public void findViews(View view) {
        m44Button = view.findViewById(R.id.radioButton_44);
        m55Button = view.findViewById(R.id.radioButton55);
        mBackgroundYellow = view.findViewById(R.id.radioButton_blue);
        mBackgroundWithe = view.findViewById(R.id.radioButton_white);
        mApply = view.findViewById(R.id.button_Apply);
        mBack = view.findViewById(R.id.button_back);
    }

    public void setListener() {
        m44Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIs55Selected = false;
            }
        });

        m55Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIs55Selected = true;
            }
        });

        mBackgroundWithe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mColorInt = 1;
            }
        });

        mBackgroundYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mColorInt = 0;
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        mApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(BOOLEAN_KEY_OF_TABLE, mIs55Selected);
                intent.putExtra(INT_KEY_OF_COLOR, mColorInt);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        });
    }
}