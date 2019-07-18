package com.example.sunil.evisit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vms.evisit.R;

public class PreVerification extends AppCompatActivity {
    TextView per_verify;
    EditText et1,et2,et3,et4;
    private static final int CAMERA_PIC_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_verification);

        per_verify = (TextView)findViewById(R.id.per_verify);
        et1= (EditText)findViewById(R.id.et1);
        et2= (EditText)findViewById(R.id.et2);
        et3= (EditText)findViewById(R.id.et3);
        et4= (EditText)findViewById(R.id.et4);

        per_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            Intent cameraIntent = new Intent(PreVerification.this, ImageActivity.class);
            cameraIntent.putExtra("bmp",image);
            startActivity(cameraIntent);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
