package com.vms.evisit.Activity;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.vms.evisit.R;

public class PasscodeVerification extends AppCompatActivity {
    TextView per_verify;
    EditText et1,et2,et3,et4;
    private static final int CAMERA_PIC_REQUEST = 3;
    private static final String TAG = "PasscodeVerification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode_verification);
        if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            // Hide the status bar.
        }

        per_verify = (TextView)findViewById(R.id.per_verify);
        et1= (EditText)findViewById(R.id.et1);
        et2= (EditText)findViewById(R.id.et2);
        et3= (EditText)findViewById(R.id.et3);
        et4= (EditText)findViewById(R.id.et4);

        setupListeners();
    }

    private void setupListeners() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4= new StringBuilder();


        et1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0){
                    et1.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
//                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if(sb.length()==1){
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(sb.length()==0 && s.length() == 1){
                    sb.append(s);
                    et1.clearFocus();
                    et2.requestFocus();
                    et2.setCursorVisible(true);
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0){
                    et1.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
//                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if(sb.length() == 1){
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(sb.length()==0 && s.length() == 1){
                    sb.append(s);
                    et2.clearFocus();
                    et3.requestFocus();
                    et3.setCursorVisible(true);
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        et3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0){
                    et2.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
//                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if(sb.length()==1){
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() == 1 && sb.length()==0){
                    sb.append(s);
                    et3.clearFocus();
                    et4.requestFocus();
                    et4.setCursorVisible(true);
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });

        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(sb.length() == 1){
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 1 && sb.length() == 0){
                    sb.append(s);
                    et4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0){
                    et3.requestFocus();
                }
            }
        });
    }


}
