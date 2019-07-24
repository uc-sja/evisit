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
    Boolean lastMobileBoxWasFilled = false, lastOtpBoxWasFilled=false;

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

        mobile_input = new EditText[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
        otp_input = new EditText[]{req_e1, req_e2, req_e3, req_e4};

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < mobile_input.length; i++) {
            mobile_input[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(e1, InputMethodManager.SHOW_IMPLICIT);
                    return  checkIfEmptyPin(v, mobile_input);
                }
            });
            Log.d(TAG, "onCreate: value " + j);
        }

        for (int i = 0; i < otp_input.length; i++) {
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

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e1.clearFocus();
                    e2.requestFocus();
                    e2.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e2.clearFocus();
                    e3.requestFocus();
                    e3.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e3.clearFocus();
                    e4.requestFocus();
                    e4.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e4.clearFocus();
                    e5.requestFocus();
                    e5.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        e5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e5.clearFocus();
                    e6.requestFocus();
                    e6.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        e6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e6.clearFocus();
                    e7.requestFocus();
                    e7.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        e7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e7.clearFocus();
                    e8.requestFocus();
                    e8.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        e8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e8.clearFocus();
                    e9.requestFocus();
                    e9.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        e9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e9.clearFocus();
                    e10.requestFocus();
                    e10.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        e10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder.length() == 1) {
                    stringBuilder.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder.length() == 0 && s.length() == 1) {
                    stringBuilder.append(s);
                    e10.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(stringBuilder.length()==0){
                    e10.requestFocus();
                    lastMobileBoxWasFilled = true;
                }
            }
        });

        e2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e2.getText().length() == 0) {
                    e1.requestFocus();
                    e1.getText().clear();
                }
                return false;
            }
        });

        e2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e2.getText().length() == 0) {
                    e1.requestFocus();
                    e1.getText().clear();
                }
                return false;
            }
        });

        e3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e3.getText().length() == 0) {
                    e2.requestFocus();
                    e2.getText().clear();
                }
                return false;
            }
        });

        e4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e4.getText().length() == 0) {
                    e3.requestFocus();
                    e3.getText().clear();
                }
                return false;
            }
        });

        e5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e5.getText().length() == 0) {
                    e4.requestFocus();
                    e4.getText().clear();
                }
                return false;
            }
        });

        e6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e6.getText().length() == 0) {
                    e5.requestFocus();
                    e5.getText().clear();
                }
                return false;
            }
        });

        e7.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e7.getText().length() == 0) {
                    e6.requestFocus();
                    e6.getText().clear();
                }
                return false;
            }
        });

        e8.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e8.getText().length() == 0) {
                    e7.requestFocus();
                    e7.getText().clear();
                }
                return false;
            }
        });

        e9.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e9.getText().length() == 0) {
                    e8.requestFocus();
                    e8.getText().clear();
                }
                return false;
            }
        });

        e10.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e10.getText().length() == 0 && !lastMobileBoxWasFilled) {
                    e9.requestFocus();
                    e9.getText().clear();
                } else if((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && e10.getText().length() == 0 && lastMobileBoxWasFilled){
                    lastMobileBoxWasFilled = !lastMobileBoxWasFilled;
                }
                return false;
            }
        });

        req_e2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && req_e2.getText().length() == 0) {
                    req_e1.requestFocus();
                    req_e1.getText().clear();
                }
                return false;
            }
        });

        req_e3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && req_e3.getText().length() == 0) {
                    req_e2.requestFocus();
                    req_e2.getText().clear();
                }
                return false;
            }
        });

        req_e4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP) && keyCode == KeyEvent.KEYCODE_DEL && req_e4.getText().length() == 0 && !lastOtpBoxWasFilled) {
                    req_e3.requestFocus();
                    req_e3.getText().clear();
                } else if(event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_DEL && req_e4.getText().length() == 0 && lastOtpBoxWasFilled) {
                    lastOtpBoxWasFilled = !lastOtpBoxWasFilled;
                }
                return false;
            }
        });

        req_e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder2.length() == 1) {
                    stringBuilder2.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder2.length() == 0 && s.length() == 1) {
                    stringBuilder2.append(s);
                    req_e1.clearFocus();
                    req_e2.requestFocus();
                    req_e2.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        req_e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder2.length() == 1) {
                    stringBuilder2.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder2.length() == 0 && s.length() == 1) {
                    stringBuilder2.append(s);
                    req_e2.clearFocus();
                    req_e3.requestFocus();
                    req_e3.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        req_e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder2.length() == 1) {
                    stringBuilder2.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder2.length() == 0 && s.length() == 1) {
                    stringBuilder2.append(s);
                    req_e3.clearFocus();
                    req_e4.requestFocus();
                    req_e4.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        req_e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
                if (stringBuilder2.length() == 1) {
                    stringBuilder2.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (stringBuilder2.length() == 0 && s.length() == 1) {
                    stringBuilder2.append(s);
                    req_e4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(stringBuilder2.length() == 0){
                    req_e4.requestFocus();
                    lastOtpBoxWasFilled = true;
                }
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
