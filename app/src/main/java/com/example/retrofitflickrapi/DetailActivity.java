package com.example.retrofitflickrapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitflickrapi.Model.Favorite.Photo;
import com.github.clans.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISION_CODE =10 ;
    ImageView imgDetail1;
    TextView txttacGia,txtViews,txtComment;
    FloatingActionButton sizeLDowload,sizeCDowload,sizeZDowload,setWalpaper;
    String idphoto;
    String urlC,urlL,urlZ;
    WallpaperManager wallpaperManager;
    Bitmap bitmap1,bitmap2;
    int width,height;
    BitmapDrawable bitmapDrawable;
    DisplayMetrics displayMetrics;

    boolean checkPermission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail1 = findViewById(R.id.imgDetail);
        txttacGia= findViewById(R.id.txttacGia);
        sizeLDowload = findViewById(R.id.dowload1);
        sizeCDowload = findViewById(R.id.dowload2);
        sizeZDowload = findViewById(R.id.dowload3);
        setWalpaper=findViewById(R.id.setWalpaper);


        txtViews= findViewById(R.id.txtViews1);
        Photo photo= (Photo) getIntent().getSerializableExtra("anh");

        //lấy id ảnh
        idphoto=photo.getId();
        urlC=photo.getUrlC();
        urlL=photo.getUrlL();
        urlZ=photo.getUrlZ();


        Picasso.with(this).load(photo.getUrlL()).into(imgDetail1);
        txttacGia.setText("By "+photo.getOwnername());
        txtViews.setText(photo.getViews()+" views");

        sizeLDowload.setLabelText(photo.getHeightL()+"x"+photo.getWidthL());
        sizeCDowload.setLabelText(photo.getHeightC()+"x"+photo.getWidthC());
        sizeZDowload.setLabelText(photo.getHeightZ()+"x"+photo.getWidthZ());

        sizeLDowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
                if(checkPermission==true){
                    startDowloadFile1(urlL);
                }else {
                    return;
                }
            }
        });
        sizeCDowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
                if(checkPermission==true){
                    startDowloadFile1(urlC);
                }else {
                    return;
                }
                //startDowloadFile1(urlC);
            }
        });
        sizeZDowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
                if(checkPermission==true){
                    startDowloadFile1(urlZ);
                }else {
                    return;
                }
                //startDowloadFile1(urlZ);
            }
        });

        setWalpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHinhNen();
            }
        });


    }



    private void setHinhNen() {

        wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
        bitmapDrawable=(BitmapDrawable)imgDetail1.getDrawable();

        bitmap1=bitmapDrawable.getBitmap();
        getScreenWidthHeight();
        setBitmapSize();

        try{
            wallpaperManager.setBitmap(bitmap2);
            wallpaperManager.suggestDesiredDimensions(width,height);
            Toast.makeText(this,"Thay đổi hình nền thành công",Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this,"Thất bại",Toast.LENGTH_SHORT).show();

        }

    }
    private void setBitmapSize() {
        bitmap2  = Bitmap.createScaledBitmap(bitmap1,width,height,false);
    }

    private void getScreenWidthHeight() {
        displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width= displayMetrics.widthPixels;
        height=displayMetrics.heightPixels;
    }


    public void openlistComment(View view) {
        Intent intentComment= new Intent(DetailActivity.this,ListCommentActivity.class);
        intentComment.putExtra("idPhoto",idphoto);
        startActivity(intentComment);

    }
    private void checkPermission(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                String [] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission,REQUEST_PERMISION_CODE);
            }else {
                checkPermission=true;

            }
        }else {
            checkPermission=true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_PERMISION_CODE){
            if(grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                checkPermission=true;
                Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT).show();

            }else{
                checkPermission=false;
                Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void startDowloadFile1(String url) {

        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE|DownloadManager.Request.NETWORK_WIFI);
        request.setTitle("Dowload");
        request.setDescription("Dowload file ...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,String.valueOf(System.currentTimeMillis()));

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        if(downloadManager!=null){
            downloadManager.enqueue(request);
        }
    }



}