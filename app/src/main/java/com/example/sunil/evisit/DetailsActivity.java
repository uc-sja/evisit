package com.example.sunil.evisit;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.vms.evisit.R;

public class DetailsActivity extends AppCompatActivity {

    TextView take_photo;
    private static final int CAMERA_PIC_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        take_photo = (TextView)findViewById(R.id.take_photo);
        take_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            Intent cameraIntent = new Intent(DetailsActivity.this, ImageActivity.class);
            cameraIntent.putExtra("bmp",image);
            startActivity(cameraIntent);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
