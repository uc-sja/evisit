package com.example.sunil.evisit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vms.evisit.R;

import static android.support.v4.provider.FontsContractCompat.FontRequestCallback.RESULT_OK;

public class ImageActivity extends AppCompatActivity {
    TextView enter;
    private TextView photo_button,recapture;
    private de.hdodenhof.circleimageview.CircleImageView imageHolder;
    private final int requestCode = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        enter = (TextView)findViewById(R.id.enter);
        recapture = (TextView)findViewById(R.id.recapture);
        imageHolder = (de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.captured_photo);
        TextView capturedImageButton = (TextView)findViewById(R.id.photo_button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageActivity.this,CheckInActivity.class);
                startActivity(intent);
            }
        });
        Bitmap bmp = this.getIntent().getParcelableExtra("bmp");
        imageHolder.setImageBitmap(bmp);
//        Button capturedImageButton = (Button)findViewById(R.id.photo_button);
//        capturedImageButton.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(photoCaptureIntent, requestCode);
//            }
//        });
        recapture.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
