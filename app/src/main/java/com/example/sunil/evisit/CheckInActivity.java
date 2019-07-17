package com.example.sunil.evisit;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vms.evisit.R;

public class CheckInActivity extends AppCompatActivity {

    de.hdodenhof.circleimageview.CircleImageView visitor_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        visitor_image = (de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.visitor_image);
//        Bitmap bimp = this.getIntent().getParcelableExtra("bimp");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
