package com.vms.evisit.Activity;

import android.content.Context;
import android.content.Intent;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vms.evisit.R;

public class PasscodeVerification extends AppCompatActivity {
    TextView per_verify;
    EditText et1,et2,et3,et4;
    private static final int CAMERA_PIC_REQUEST = 3;
    private static final String TAG = "PasscodeVerification";
    private boolean lastBoxEmpty;

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

//        setupListeners();
    }

//    private void setupListeners() {
//        StringBuilder sb = new StringBuilder();
//        lastBoxEmpty = false;
//
//        et1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start,
//                                          int count, int after) {
////                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
//                if(sb.length()==1){
//                    sb.deleteCharAt(0);
//                }
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start,
//                                      int before, int count) {
//                if(sb.length()==0 && s.length() == 1){
//                    sb.append(s);
//                    et1.clearFocus();
//                    et2.requestFocus();
//                    et2.setCursorVisible(true);
//                }
//            }
//        });
//
//        et2.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d(TAG, "afterTextChanged: "+sb);
//                if(sb.length()==0){
//                    et1.requestFocus();
//                    lastBoxEmpty = true;
//                }
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start,
//                                          int count, int after) {
////                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
//                if(sb.length() == 1){
//                    sb.deleteCharAt(0);
//                }
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start,
//                                      int before, int count) {
//                if(sb.length()==0 && s.length() == 1){
//                    sb.append(s);
//                    et2.clearFocus();
//                    et3.requestFocus();
//                    et3.setCursorVisible(true);
////                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
//                }
//            }
//        });
//
////        et2.setOnKeyListener(new View.OnKeyListener() {
////            @Override
////            public boolean onKey(View v, int keyCode, KeyEvent event) {
////                Log.d(TAG, "onKey: e2 keycode "+keyCode);
////                Log.d(TAG, "onKey: e2 eventkeycode "+ event.getKeyCode());
////                Log.d(TAG, "onKey: e2"+event.getAction());
////                if((event.getAction() == KeyEvent.ACTION_UP)  && keyCode == KeyEvent.KEYCODE_DEL && et2.getText().length()==0){
////                    Log.d(TAG, "onKey: action up");
////                    et1.requestFocus();
////                    et1.getText().clear();
////
////                }
////                return false;
////            }
////        });
//
////        et2.setOnTouchListener(new View.OnTouchListener() {
////               @Override
////               public boolean onTouch(View v, MotionEvent event) {
////                   if(checkEmptyPin(v)){return true;} else{
////                       return false;
////                   }
////               }
////           }
////        );
//
//        et3.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {
//                if(sb.length()==0){
//                    et2.requestFocus();
//                    lastBoxEmpty = true;
//                }
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start,
//                                          int count, int after) {
////                et1.setBackgroundResource(R.drawable.round_textedit_blackfilled);
//                if(sb.length()==1){
//                    sb.deleteCharAt(0);
//                }
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start,
//                                      int before, int count) {
//                if(s.length() == 1 && sb.length()==0){
//                    sb.append(s);
//                    et3.clearFocus();
//                    et4.requestFocus();
//                    et4.setCursorVisible(true);
////                    mTxtVer2.setBackgroundResource(R.drawable.round_textedit_blackfilled);
//                }
//            }
//        });
//
////        et3.setOnKeyListener(new View.OnKeyListener() {
////            @Override
////            public boolean onKey(View v, int keyCode, KeyEvent event) {
////                Log.d(TAG, "onKey: e3 keycode "+keyCode);
////                Log.d(TAG, "onKey: e3 eventkeycode "+ event.getKeyCode());
////                if((event.getAction() == KeyEvent.ACTION_UP)  && keyCode == KeyEvent.KEYCODE_DEL && et3.getText().length()==0){
////                    Log.d(TAG, "onKey: e3 + action up ");
////                    et2.requestFocus();
////                    et2.getText().clear();
////                }
////                return false;
////            }
////        });
//
////        et3.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                if(checkEmptyPin(v)){return true;} else{
////                    return false;
////                }
////            }
////        });
//
//        et4.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                if(sb.length() == 1){
//                    sb.deleteCharAt(0);
//                }
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(s.length() == 1 && sb.length() == 0){
//                    sb.append(s);
//                    et4.requestFocus();
//                }
//            }
//
//            //lastboxEmpty flag is used because cursor does not move forward for the last box,
//            //hence, if backspace is hit, when the last edit box has a value, its value gets deleted
//            //but simultaneously keylister event(the checks for empty box) for last edittext is also activated
//            //resulting in deletion of the second last edittext.
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d(TAG, "afterTextChanged: ");
//                if(sb.length()==0){
//                    et3.requestFocus();
//                    lastBoxEmpty = true;
//                }
//            }
//        });
//
////        et4.setOnKeyListener(new View.OnKeyListener() {
////            @Override
////            public boolean onKey(View v, int keyCode, KeyEvent event) {
////                Log.d(TAG, "onKey: delete e4 key");
////                Log.d(TAG, "onKey: delete e4 "+event.getAction());
////                Log.d(TAG, "onKey: delete e4 "+event.getKeyCode());
////                if((event.getAction() == KeyEvent.ACTION_UP)  && keyCode == KeyEvent.KEYCODE_DEL && et4.getText().length()==0 && !lastBoxEmpty){
////                    Log.d(TAG, "onKey: deleted size 0");
////                    et3.requestFocus();
////                    et3.getText().clear();
////                 } else if(((event.getAction() == KeyEvent.ACTION_UP)  && keyCode == KeyEvent.KEYCODE_DEL && et4.getText().length()==0 && lastBoxEmpty)){
////                    lastBoxEmpty = !lastBoxEmpty;
////                }
////                return false;
////            }
////        });
////
////        et4.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                Log.d(TAG, "onTouch: ");
////                if(checkEmptyPin(v)){return true;} else{
////                    return false;
////                }
////            }
////        });
//
//        per_verify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PasscodeVerification.this, ChosePhotoActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    private Boolean checkEmptyPin(View v) {
        EditText editText = (EditText)v;
        if(editText.getText().length()>0){
            if(editText.getId()==R.id.et4){
                return false;
            } else {
                return true;
            }
        }

        if (et1.getText().length() == 0) {
            editText.clearFocus();
            et1.requestFocus();
            et1.setCursorVisible(true);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et1, InputMethodManager.SHOW_IMPLICIT);

            return true;
        }
        else if (et2.getText().length() == 0) {
            editText.clearFocus();
            et2.requestFocus();
            et2.setCursorVisible(true);
            return true;
        }
        else if (et3.getText().length() == 0) {
            editText.clearFocus();
            et3.requestFocus();
            et3.setCursorVisible(true);
            return true;
        }
       return false;
    }
}
