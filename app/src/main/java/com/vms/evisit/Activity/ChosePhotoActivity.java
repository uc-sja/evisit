package com.vms.evisit.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vms.evisit.R;

import java.lang.reflect.Type;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChosePhotoActivity extends AppCompatActivity {

    private static final int OPEN_CAMERA_CODE = 1201;
    CircleImageView circleImageView;
    TextView recapture, enter;
    Bitmap bitmap;
    private int CAMERA_REQUEST_CODE = 1014;
    private static final String TAG = "ChosePhotoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_photo);

        if(Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.

            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            // Hide the status bar.
        }

        circleImageView = findViewById(R.id.captured_photo);
        recapture = findViewById(R.id.recapture);
        enter = findViewById(R.id.enter);

        if(getIntent() != null){
            bitmap = new Gson().fromJson(getIntent().getStringExtra("bitmap"), Bitmap.class);
            circleImageView.setImageBitmap(bitmap);
        }

        if(bitmap == null){
            circleImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_user));
            Log.d(TAG, "onCreate: no intent");
        }

        recapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
                    } else {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, OPEN_CAMERA_CODE);
                    }
                }
            }
        });

         enter.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(ChosePhotoActivity.this, SuceessCheckIn.class);
                 intent.putExtra("bitmap", getIntent().getStringExtra("bitmap"));
                 startActivity(intent);
             }
         });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == CAMERA_REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, OPEN_CAMERA_CODE);
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == OPEN_CAMERA_CODE && resultCode == Activity.RESULT_OK){
            bitmap = (Bitmap) data.getExtras().get("data");
            circleImageView.setImageBitmap(bitmap);
        }
    }
}
