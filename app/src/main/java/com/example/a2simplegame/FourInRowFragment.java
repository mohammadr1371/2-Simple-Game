package com.example.a2simplegame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class FourInRowFragment extends Fragment {

    private int[][] table44 = new int[4][4];
    private int[][] table55 = new int[5][5];
    private int[][] targetTable;

    private boolean flag = false;
    private boolean table55Flag = false;

    private LinearLayout mBackgroundLayout;
    private LinearLayout mRow5;

    private Button mButton1_1;
    private Button mButton1_2;
    private Button mButton1_3;
    private Button mButton1_4;
    private Button mButton1_extra;
    private Button mButton2_1;
    private Button mButton2_2;
    private Button mButton2_3;
    private Button mButton2_4;
    private Button mButton2_extra;
    private Button mButton3_1;
    private Button mButton3_2;
    private Button mButton3_3;
    private Button mButton3_4;
    private Button mButton3_extra;
    private Button mButton4_1;
    private Button mButton4_2;
    private Button mButton4_3;
    private Button mButton4_4;
    private Button mButton4_extra;
    private Button mButton5_1;
    private Button mButton5_2;
    private Button mButton5_3;
    private Button mButton5_4;
    private Button mButton5_extra;
    private Button mSetting;
    private Button mRetry;

    public static FourInRowFragment newInstance() {
        FourInRowFragment fragment = new FourInRowFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_in_row, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    public void findViews(View view) {
        mBackgroundLayout = view.findViewById(R.id.Background_layout);
        mRow5 = view.findViewById(R.id.in_row_5);
        mButton1_1 = view.findViewById(R.id.button1_1);
        mButton1_2 = view.findViewById(R.id.button1_2);
        mButton1_3 = view.findViewById(R.id.button1_3);
        mButton1_4 = view.findViewById(R.id.button1_4);
        mButton1_extra = view.findViewById(R.id.button1_extra);
        mButton2_1 = view.findViewById(R.id.button2_1);
        mButton2_2 = view.findViewById(R.id.button2_2);
        mButton2_3 = view.findViewById(R.id.button2_3);
        mButton2_4 = view.findViewById(R.id.button2_4);
        mButton2_extra = view.findViewById(R.id.button2_extra);
        mButton3_1 = view.findViewById(R.id.button3_1);
        mButton3_2 = view.findViewById(R.id.button3_2);
        mButton3_3 = view.findViewById(R.id.button3_3);
        mButton3_4 = view.findViewById(R.id.button3_4);
        mButton3_extra = view.findViewById(R.id.button3_extra);
        mButton4_1 = view.findViewById(R.id.button4_1);
        mButton4_2 = view.findViewById(R.id.button4_2);
        mButton4_3 = view.findViewById(R.id.button4_3);
        mButton4_4 = view.findViewById(R.id.button4_4);
        mButton4_extra = view.findViewById(R.id.button4_extra);
        mButton5_1 = view.findViewById(R.id.button5_1);
        mButton5_2 = view.findViewById(R.id.button5_2);
        mButton5_3 = view.findViewById(R.id.button5_3);
        mButton5_4 = view.findViewById(R.id.button5_4);
        mButton5_extra = view.findViewById(R.id.button5_extra);
        mSetting = view.findViewById(R.id.button_setting_4_in_row);
        mRetry = view.findViewById(R.id.button_retry_4_in_row);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_CANCELED || data == null) {
            return;
        }
        if (requestCode == 0) {
            int colorInt = getActivity().getIntent().getIntExtra(SettingFragment.INT_KEY_OF_COLOR, 0);
            boolean tableResult = getActivity().getIntent().getBooleanExtra(SettingFragment.BOOLEAN_KEY_OF_TABLE, false);
            if (tableResult == false) {
                table55Flag = false;
                mRow5.setVisibility(View.GONE);
                mButton1_extra.setVisibility(View.GONE);
                mButton2_extra.setVisibility(View.GONE);
                mButton3_extra.setVisibility(View.GONE);
                mButton4_extra.setVisibility(View.GONE);
                mButton5_extra.setVisibility(View.GONE);
            } else if (tableResult == true) {
                table55Flag = true;
                mRow5.setVisibility(View.VISIBLE);
                mButton1_extra.setVisibility(View.VISIBLE);
                mButton2_extra.setVisibility(View.VISIBLE);
                mButton3_extra.setVisibility(View.VISIBLE);
                mButton4_extra.setVisibility(View.VISIBLE);
                mButton5_extra.setVisibility(View.VISIBLE);
            }

            if (colorInt == 0)
                mBackgroundLayout.setBackgroundColor(Color.YELLOW);
            else if (colorInt == 1)
                mBackgroundLayout.setBackgroundColor(Color.WHITE);

            return;
        }

    }

    public void setListeners() {
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        mButton1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton1_1, 1, 1);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton1_2, 1, 2);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton1_3, 1, 3);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }
            }
        });

        mButton1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton1_4, 1, 4);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }
            }
        });

        mButton2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton2_1, 2, 1);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton2_2, 2, 2);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton2_3, 2, 3);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton2_4, 2, 4);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton3_1, 3, 1);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton3_2, 3, 2);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton3_3, 3, 3);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton3_3, 3, 3);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton3_4, 3, 4);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton4_1, 4, 1);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton4_2, 4, 2);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton4_3, 4, 3);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mButton4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(mButton4_4, 4, 4);
                if ((checkBlueHorizontal(targetTable) == true) || (checkBlueVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Blue Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if ((checkRedHorizontal(targetTable) == true) || (checkRedVertical(targetTable) == true)) {
                    mRetry.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Red Wins!", Toast.LENGTH_LONG).show();
                    disableButtons();
                }

            }
        });

        mRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableButtons();
                mRetry.setVisibility(View.GONE);
                resetButtons();
            }
        });


    }

    public boolean checkBlueHorizontal(int[][] table) {
        int counter = 0;
        if (table55Flag == false) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (table[i][j] == 1) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        if (table55Flag == true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (table[i][j] == 1) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public boolean checkRedHorizontal(int[][] table) {
        int counter = 0;
        if (table55Flag == false) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (table[i][j] == 2) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        if (table55Flag == true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (table[i][j] == 2) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public boolean checkBlueVertical(int[][] table) {
        int counter = 0;
        if (table55Flag == false) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (table[j][i] == 1) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        if (table55Flag == true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (table[j][i] == 1) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public boolean checkRedVertical(int[][] table) {
        int counter = 0;
        if (table55Flag == false) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (table[j][i] == 2) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        if (table55Flag == true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (table[j][i] == 2) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public void selectButton(Button button, int i, int j) {
        if (flag == false) {
            button.setBackgroundColor(Color.BLUE);
            flag = true;
            if (table55Flag == true) {
                table55[i - 1][j - 1] = 1;
                targetTable = table55;
            } else {
                table44[i - 1][j - 1] = 1;
                targetTable = table44;
            }
            return;
        } else {
            button.setBackgroundColor(Color.RED);
            flag = false;
            if (table55Flag == true) {
                table55[i - 1][j - 1] = 2;
                targetTable = table55;
            } else {
                table44[i - 1][j - 1] = 2;
                targetTable = table44;
            }
            return;
        }

    }

    public void disableButtons() {
        mButton1_1.setEnabled(false);
        mButton1_2.setEnabled(false);
        mButton1_3.setEnabled(false);
        mButton1_4.setEnabled(false);
        mButton1_extra.setEnabled(false);
        mButton2_1.setEnabled(false);
        mButton2_2.setEnabled(false);
        mButton2_3.setEnabled(false);
        mButton2_4.setEnabled(false);
        mButton2_extra.setEnabled(false);
        mButton3_1.setEnabled(false);
        mButton3_2.setEnabled(false);
        mButton3_3.setEnabled(false);
        mButton3_4.setEnabled(false);
        mButton3_extra.setEnabled(false);
        mButton4_1.setEnabled(false);
        mButton4_2.setEnabled(false);
        mButton4_3.setEnabled(false);
        mButton4_4.setEnabled(false);
        mButton4_extra.setEnabled(false);
        mButton5_1.setEnabled(false);
        mButton5_2.setEnabled(false);
        mButton5_3.setEnabled(false);
        mButton5_4.setEnabled(false);
        mButton5_extra.setEnabled(false);
        mSetting.setEnabled(false);
    }

    public void enableButtons() {
        mButton1_1.setEnabled(true);
        mButton1_2.setEnabled(true);
        mButton1_3.setEnabled(true);
        mButton1_4.setEnabled(true);
        mButton1_extra.setEnabled(true);
        mButton2_1.setEnabled(true);
        mButton2_2.setEnabled(true);
        mButton2_3.setEnabled(true);
        mButton2_4.setEnabled(true);
        mButton2_extra.setEnabled(true);
        mButton3_1.setEnabled(true);
        mButton3_2.setEnabled(true);
        mButton3_3.setEnabled(true);
        mButton3_4.setEnabled(true);
        mButton3_extra.setEnabled(true);
        mButton4_1.setEnabled(true);
        mButton4_2.setEnabled(true);
        mButton4_3.setEnabled(true);
        mButton4_4.setEnabled(true);
        mButton4_extra.setEnabled(true);
        mButton5_1.setEnabled(true);
        mButton5_2.setEnabled(true);
        mButton5_3.setEnabled(true);
        mButton5_4.setEnabled(true);
        mButton5_extra.setEnabled(true);
        mSetting.setEnabled(true);
    }

    public void resetButtons() {
        mButton1_1.setBackgroundColor(Color.LTGRAY);
        mButton1_2.setBackgroundColor(Color.LTGRAY);
        mButton1_3.setBackgroundColor(Color.LTGRAY);
        mButton1_4.setBackgroundColor(Color.LTGRAY);
        mButton1_extra.setBackgroundColor(Color.LTGRAY);
        mButton2_1.setBackgroundColor(Color.LTGRAY);
        mButton2_2.setBackgroundColor(Color.LTGRAY);
        mButton2_3.setBackgroundColor(Color.LTGRAY);
        mButton2_4.setBackgroundColor(Color.LTGRAY);
        mButton2_extra.setBackgroundColor(Color.LTGRAY);
        mButton3_1.setBackgroundColor(Color.LTGRAY);
        mButton3_2.setBackgroundColor(Color.LTGRAY);
        mButton3_3.setBackgroundColor(Color.LTGRAY);
        mButton3_4.setBackgroundColor(Color.LTGRAY);
        mButton3_extra.setBackgroundColor(Color.LTGRAY);
        mButton4_1.setBackgroundColor(Color.LTGRAY);
        mButton4_2.setBackgroundColor(Color.LTGRAY);
        mButton4_3.setBackgroundColor(Color.LTGRAY);
        mButton4_4.setBackgroundColor(Color.LTGRAY);
        mButton4_extra.setBackgroundColor(Color.LTGRAY);
        mButton5_1.setBackgroundColor(Color.LTGRAY);
        mButton5_2.setBackgroundColor(Color.LTGRAY);
        mButton5_3.setBackgroundColor(Color.LTGRAY);
        mButton5_4.setBackgroundColor(Color.LTGRAY);
        mButton5_extra.setBackgroundColor(Color.LTGRAY);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                table44[i][j] = 0;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table55[i][j] = 0;
            }
        }
    }


}