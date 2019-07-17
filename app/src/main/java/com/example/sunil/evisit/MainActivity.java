package com.example.sunil.evisit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

import com.vms.evisit.R;

public class MainActivity extends AppCompatActivity {
    RelativeLayout pass_layout,camera;
    TextView textView,textfield;
    TextView txt_pc,txt_m;
    ImageView pass_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_pick);
        pass_layout = (RelativeLayout)findViewById(R.id.pass_layout);
        textfield = (TextView)findViewById(R.id.textfield);
        camera = (RelativeLayout) findViewById(R.id.camera);
//        txt_m = (TextView)findViewById(R.id.txt_m);
//        txt_pc = (TextView)findViewById(R.id.txt_pc);
//        TextView txtcam = (TextView) findViewById(R.id.textfield);
//        TextView txtgal = (TextView) findViewById(R.id.txtgal);
//        TextView pc = (TextView) findViewById(R.id.txt_pass);
        textfield.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "Fundamental Demo.ttf"));
//        txtgal.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "Fundamental Demo.ttf"));
//        pc.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "Fundamental Demo.ttf"));
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PreVerification.class);
                startActivity(intent);
            }
        });

        pass_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VerificationActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
