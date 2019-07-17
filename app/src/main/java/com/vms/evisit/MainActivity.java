package com.vms.evisit;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.vms.evisit.Activity.MobileVerification;
import com.vms.evisit.Activity.PasscodeVerification;

public class MainActivity extends AppCompatActivity {
    Toolbar tl;
    ImageView passcode_id, mobile_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

                passcode_id = findViewById(R.id.passcode_id);
                mobile_id = findViewById(R.id.mobile_id);

                mobile_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MobileVerification.class);
                        startActivity(intent);
                    }
                });

                passcode_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PasscodeVerification.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }
