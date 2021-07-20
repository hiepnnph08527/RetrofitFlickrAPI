package com.example.retrofitflickrapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView imgDetail;
    TextView txttacGia;
    FloatingActionButton sizeLDowload,sizeCDowload,sizeZDowload;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txttacGia= findViewById(R.id.txttacGia);
        sizeLDowload = findViewById(R.id.dowload1);
        sizeCDowload = findViewById(R.id.dowload2);
        sizeZDowload = findViewById(R.id.dowload3);



        Intent intent = getIntent();
        String tacgia=intent.getStringExtra("ownerName");
        String linkanhchitiet= intent.getStringExtra("urlL");
        String sizeL = intent.getStringExtra("sizeL");
        String sizeC = intent.getStringExtra("sizeC");
        String sizeZ = intent.getStringExtra("sizeZ");


        Picasso.with(this).load(linkanhchitiet).into(imgDetail);
        txttacGia.setText("By "+tacgia);
        sizeLDowload.setLabelText(sizeL);
        sizeCDowload.setLabelText(sizeC);
        sizeZDowload.setLabelText(sizeZ);



    }
}