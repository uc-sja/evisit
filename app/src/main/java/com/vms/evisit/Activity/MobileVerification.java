package com.vms.evisit.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;
import com.vms.evisit.R;

public class MobileVerification extends AppCompatActivity {
    OtpView edit_otp;
    private boolean isFormatting;
    private boolean deletingHyphen;
    private int hyphenStart;
    private boolean deletingBackward;
    private static final String TAG = "MobileVerification";
    private Button verifyOtpBtn;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
    EditText req_e1,req_e2,req_e3,req_e4;
    private EditText[] mobile_input;
    private EditText[] otp_input;
    private int j;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);
        e9 = findViewById(R.id.e9);
        e10 = findViewById(R.id.e10);

        req_e1 = findViewById(R.id.req_et1);
        req_e2 = findViewById(R.id.req_et2);
        req_e3 = findViewById(R.id.req_et3);
        req_e4 = findViewById(R.id.req_et4);

        if(Build.VERSION.SDK_INT < 16){
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            // Hide the status bar.
//            final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
//
//            getWindow().getDecorView().setSystemUiVisibility(flags);
//            final View decorView = getWindow().getDecorView();
//            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
//                @Override
//                public void onSystemUiVisibilityChange(int visibility) {
//                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
//                        decorView.setSystemUiVisibility(flags);
//                    }
//                }
//        });

        }

        mobile_input = new EditText[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10};

        otp_input = new EditText[]{req_e1,req_e2,req_e3,req_e4};

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < mobile_input.length; i++){
            j = i;
            mobile_input[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return checkIfEmptyPin(v, mobile_input);
                }
            });


            Log.d(TAG, "onCreate: value "+j);
            mobile_input[j].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (stringBuilder.length() == 1) {
                        stringBuilder.deleteCharAt(0);
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Log.d(TAG, "onTextChanged: value of j "+j);
                    if(mobile_input[j]){
                        if(stringBuilder.length()==0 && s.length()==1){
                            stringBuilder.append(s);
                            mobile_input[j].requestFocus();
                        }
                    }
                    else if(stringBuilder.length()==0 && s.length()==1){
                        stringBuilder.append(s);
                        mobile_input[j].clearFocus();
                        mobile_input[j+1].requestFocus();
                        mobile_input[j+1].setCursorVisible(true);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }

        for(int i = 0; i < otp_input.length; i++){
            otp_input[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return checkIfEmptyPin(v, otp_input);
                }
            });
        }

        verifyOtpBtn = findViewById(R.id.request_otp_btn);

        verifyOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileVerification.this, FormActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkIfEmptyPin(View v,EditText input_array[] ) {
        EditText editText = (EditText) v;
        if(editText.getText().length()>1){
            return true;
        }
        boolean return_value = false;

        for(int i = 0; i < input_array.length; i++){
            if(input_array[i].getText().length()==0){
                editText.clearFocus();
                input_array[i].requestFocus();
                input_array[i].setCursorVisible(true);
                    return_value = true;
                break;
            }
        }
        return return_value;
    }
}
