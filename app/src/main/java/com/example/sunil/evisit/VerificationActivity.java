package com.example.sunil.evisit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.vms.evisit.R;

public class VerificationActivity extends AppCompatActivity {

    TextView verify;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,req_et1,req_et2,req_et3,req_et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        e1= (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        e4 = (EditText)findViewById(R.id.e4);
        e5 = (EditText)findViewById(R.id.e5);
        e6 = (EditText)findViewById(R.id.e6);
        e7 = (EditText)findViewById(R.id.e7);
        e8 = (EditText)findViewById(R.id.e8);
        e9 = (EditText)findViewById(R.id.e9);
        e10 = (EditText)findViewById(R.id.e10);
        req_et1 = (EditText)findViewById(R.id.req_et1);
        req_et2 = (EditText)findViewById(R.id.req_et2);
        req_et3= (EditText)findViewById(R.id.req_et3);
        req_et4 = (EditText)findViewById(R.id.req_et4);

        setupListeners();
        verify = (TextView)findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerificationActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupListeners() {
        e1.addTextChangedListener(new TextWatcher() {

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
                    e2.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e2.addTextChangedListener(new TextWatcher() {

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
                    e3.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e3.addTextChangedListener(new TextWatcher() {

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
                    e4.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e4.addTextChangedListener(new TextWatcher() {

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
                    e5.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e5.addTextChangedListener(new TextWatcher() {

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
                    e6.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e6.addTextChangedListener(new TextWatcher() {

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
                    e7.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e7.addTextChangedListener(new TextWatcher() {

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
                    e8.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e8.addTextChangedListener(new TextWatcher() {

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
                    e9.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        e9.addTextChangedListener(new TextWatcher() {

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
                    e10.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        req_et1.addTextChangedListener(new TextWatcher() {

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
                    req_et2.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        req_et2.addTextChangedListener(new TextWatcher() {

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
                    req_et3.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
        req_et3.addTextChangedListener(new TextWatcher() {

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
                    req_et4.requestFocus();
//                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
