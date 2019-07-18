package com.vms.evisit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
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
        per_verify = (TextView)findViewById(R.id.per_verify);
        et1= (EditText)findViewById(R.id.et1);
        et2= (EditText)findViewById(R.id.et2);
        et3= (EditText)findViewById(R.id.et3);
        et4= (EditText)findViewById(R.id.et4);

        setupListeners();
    }

    private void setupListeners() {
        et1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
//                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() == 1){
                    et2.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        et2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
//                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() == 1){
                    et3.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        et3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
//                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() == 1){
                    et4.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
    }
}
