package com.vms.evisit.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.mukesh.OtpView;
import com.vms.evisit.R;

public class MobileVerification extends AppCompatActivity implements TextWatcher {
    OtpView edit_otp;
    private static final String TAG = "MobileVerification";
    private Button verifyOtpBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);



        if (Build.VERSION.SDK_INT < 16) {
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

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();



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
        boolean return_value = false;
        //So that we can rebring the keyboard if all fields are filled and keyboard is hidden
        if(editText.getText().length()>0){
            if(editText.getId()==input_array[input_array.length-1].getId()){
                return false;
            } else {
                return true;
            }
        }


        for(int i = 0; i < input_array.length; i++){
            if(input_array[i].getText().length()==0){
                editText.clearFocus();
                input_array[i].requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(input_array[i], InputMethodManager.SHOW_IMPLICIT);
                return_value = true;
                break;
            }
        }
        return return_value;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
