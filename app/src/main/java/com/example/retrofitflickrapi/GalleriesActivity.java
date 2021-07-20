package com.example.retrofitflickrapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.retrofitflickrapi.Interface.ItemClickListener;
import com.example.retrofitflickrapi.Model.Galleries.Galleries;
import com.example.retrofitflickrapi.Model.Galleries.Gallery;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleriesActivity extends AppCompatActivity  {

    RecyclerView rcv_galleries;
    String method= "flickr.galleries.getList";
    String api_key="3633bfecbf708e160211dc18d56060c3";
    String USER_ID = "189419592@N04";
    ArrayList<Gallery> galleryArrayList;
    GalleriesAdapter galleriesAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleries);
        rcv_galleries= findViewById(R.id.rcv_galleries);
        callapiGalleries();
    }

    public void callapiGalleries(){

        RetrofitClient.getIntance().
                getListgalleries("flickr.galleries.getList","3633bfecbf708e160211dc18d56060c3","189419592@N04",100,1,"json",1).enqueue(new Callback<Galleries>() {
            @Override
            public void onResponse(Call<Galleries> call, Response<Galleries> response) {
                galleryArrayList=response.body().getGalleries().getGallery();
                galleriesAdapter= new GalleriesAdapter(galleryArrayList, new ItemClickListener() {
                    @Override
                    public void onitemclick(Gallery gallery) {

                        Intent intent= new Intent(GalleriesActivity.this,PhotoGalleriesActivity.class);
                        intent.putExtra("gallery_id",gallery.getGalleryId());
                        startActivity(intent);

                    }
                });
                GridLayoutManager layoutManager= new GridLayoutManager(GalleriesActivity.this,2);
                rcv_galleries.setLayoutManager(layoutManager);
                rcv_galleries.setAdapter(galleriesAdapter);
                rcv_galleries.setHasFixedSize(true);



            }

            @Override
            public void onFailure(Call<Galleries> call, Throwable t) {
                Toast.makeText(GalleriesActivity.this,"Lấy danh sách album thất bại",Toast.LENGTH_SHORT).show();

            }
        });
    }


}