package com.vms.evisit.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vms.evisit.BuildConfig;
import com.vms.evisit.R;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class SuceessCheckIn extends AppCompatActivity {
    CircleImageView visitor_image;
    private Bitmap bitmap;
    TextView print_photo;
    RelativeLayout root_layout;
    String dirpath;
    private static final String TAG = "SuceessCheckIn";
    private int STORAGE_PERMISSION_REQUEST = 101;
    private ByteArrayOutputStream bytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess_checkin);
        visitor_image = findViewById(R.id.visitor_image);
        print_photo = findViewById(R.id.print_photo);
        root_layout = findViewById(R.id.root_layout);

        if(getIntent() != null){
            bitmap = new Gson().fromJson(getIntent().getStringExtra("bitmap"), Bitmap.class);
            visitor_image.setImageBitmap(bitmap);
        }

        if(bitmap == null){
            print_photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    PrintManager printManager = null;
//                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//                        printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
//                        String jobName = getString(R.string.app_name) + " Discount    ";
//                        printManager.print(jobName, new MyPrintDocumentAdapter(this), null);
//                    }
                    layoutToImage(root_layout);
                }
            });
       } else {
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

    public void layoutToImage(View view) {
        // get view group using reference

        RelativeLayout relativeLayout = (RelativeLayout) view;
        // convert view group to bitmap
        relativeLayout.setDrawingCacheEnabled(true);
        relativeLayout.buildDrawingCache();
        Bitmap bm = relativeLayout.getDrawingCache();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        if(isStoragePermissionGranted()){
            Log.d(TAG, "layoutToImage: ");
            File f = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                imageToPDF();
            } catch (IOException e) {
                Log.d(TAG, "layoutToImage: "+ e.toString());
            }
        } else{
            Log.d(TAG, "layoutToImage: permission denied");
            ActivityCompat.requestPermissions(SuceessCheckIn.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_REQUEST);
           }
        }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult: grantresults length "+grantResults.length);
        if(requestCode == STORAGE_PERMISSION_REQUEST){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                File f = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");

                try {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                    imageToPDF();
                } catch (IOException e) {
                    Log.d(TAG, "layoutToImage: "+ e.toString());
                }


            }
        }
    }

    private boolean isStoragePermissionGranted() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {

            //permission already granted for devices below marshmallow
            return false;
        }
    }

    public void imageToPDF() throws FileNotFoundException {
        try {
            Document document = new Document();
            dirpath = Environment.getExternalStorageDirectory().toString();
            PdfWriter.getInstance(document, new FileOutputStream(dirpath + "/checkedin.pdf")); //  Change pdf's name.
            document.open();
            Image img = Image.getInstance(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0 - document.bottomMargin()- document.topMargin()-70) / img.getWidth()) * 100; // 0 means you have no indentation. If you have any, change it.
            img.scalePercent(scaler);
            img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);


            document.add(img);
            document.close();


            Toast.makeText(this, "PDF Generated successfully!..", Toast.LENGTH_SHORT).show();

            Log.d(TAG, "imageToPDF: pdf generaed");
            File d  = Environment.getExternalStorageDirectory();

            Log.d(TAG, "imageToPDF: external storage diretory created");

            File pdfFile  = new File(d, "checkedin.pdf");

            Log.d(TAG, "imageToPDF: filecreated" );

            Uri path = null;
            try {
                path = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileprovider", pdfFile);
            } catch (Exception e) {
                Log.d(TAG, "imageToPDF: "+e.toString());
            }
            Log.d(TAG, "imageToPDF: path "+path);

            Intent pdfIntent =new Intent(Intent.ACTION_VIEW);

            pdfIntent.setDataAndType(path, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            try{
                startActivity(pdfIntent);
            } catch (Exception e){
                Log.d(TAG, "imageToPDF: "+e.toString());
                Toast.makeText(this, ""+e.toString(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.d(TAG, "imageToPdf "+e.toString());
        }
    }
}
