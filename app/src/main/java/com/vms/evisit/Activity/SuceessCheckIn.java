package com.vms.evisit.Activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.vms.evisit.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SuceessCheckIn extends AppCompatActivity {

    CircleImageView visitor_image;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess_checkin);
        visitor_image = findViewById(R.id.visitor_image);

        if(getIntent() != null){
            bitmap = new Gson().fromJson(getIntent().getStringExtra("bitmap"), Bitmap.class);
            visitor_image.setImageBitmap(bitmap);
        }

        if(bitmap == null){
            visitor_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_user));
        }

        if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            // Hide the status bar.
        }
    }
}
