package com.example.retrofitflickrapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitflickrapi.Adapter.PhotoGalleriesAdapter;
import com.example.retrofitflickrapi.Model.PhotoGalleries.Photo2;
import com.example.retrofitflickrapi.Model.PhotoGalleries.PhotoGalleries;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoGalleriesActivity extends AppCompatActivity {

    RecyclerView rcv_photoGalleries;
    private static final String extras="description,license,date_upload,date_taken,owner_name,icon_server,original_format,last_update,geo,tags,machine_tags,o_dims,views,media,path_alias,url_sq,url_t,url_s,url_q,url_m,url_n,url_z,url_c,url_l,url_o";
    ArrayList<Photo2> arrayListPhotoGalleries;
    PhotoGalleriesAdapter photoGalleriesAdapter;
    String idgalery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_galleries);
        rcv_photoGalleries=findViewById(R.id.rcv_photoGalleries);
        getGalleryId();
        getImageGalleries();

    }

    public void getGalleryId() {
        Intent intent=getIntent();
        idgalery=intent.getStringExtra("gallery_id");
    }


//https://www.flickr.com/services/rest/?method=flickr.galleries.getPhotos
    // &api_key=3633bfecbf708e160211dc18d56060c3&gallery_id=72157715485929427&extras=date_upload%2C+date_taken%2C+owner_name%2C+icon_server%2C+original_format%2C+last_update%2C+geo%2C+tags%2C+machine_tags%2C+o_dims%2C+views%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_c%2C+url_l%2C+url_o
    // &per_page=10&page=1&format=json&nojsoncallback=1

    private void getImageGalleries() {
        RetrofitClient.getIntance().getPhotoGalleries("flickr.galleries.getPhotos","3633bfecbf708e160211dc18d56060c3",idgalery,extras,50,1,"json",1).enqueue(new Callback<PhotoGalleries>() {
            @Override
            public void onResponse(Call<PhotoGalleries> call, Response<PhotoGalleries> response) {
                arrayListPhotoGalleries=response.body().getPhotos().getPhoto();
                photoGalleriesAdapter= new PhotoGalleriesAdapter(arrayListPhotoGalleries,PhotoGalleriesActivity.this);
                StaggeredGridLayoutManager layoutManager=
                        new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                rcv_photoGalleries.setLayoutManager(layoutManager);
                rcv_photoGalleries.setAdapter(photoGalleriesAdapter);
                rcv_photoGalleries.setHasFixedSize(true);

                Toast.makeText(PhotoGalleriesActivity.this,"thanh cong",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<PhotoGalleries> call, Throwable t) {
                Toast.makeText(PhotoGalleriesActivity.this,"that bai",Toast.LENGTH_SHORT).show();

            }
        });
    }
}