package com.example.retrofitflickrapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.retrofitflickrapi.Model.Favorite.Example;
import com.example.retrofitflickrapi.Model.Favorite.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String FULL_EXTRAS = "views,media,path_alias,url_sq,url_t,url_s,url_q,url_m,url_n,url_z,url_c,url_l,url_o,owner_name";
    private static final String USER_ID = "189419592@N04";
    private static final String KEY_TOKEN = "3633bfecbf708e160211dc18d56060c3";
    private static final String GET_FAVO = "flickr.favorites.getList";
    private int page = 1;
    private ArrayList<Photo> arrayListAnh;
    private RecyclerView recyclerView;
    private AnhAdapter anhAdapter;
    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rcv_main);
        arrayListAnh= new ArrayList<>();
        callapi();


    }






//    private void addData() {
//        arrayListAnh.add(new Image(R.drawable.iron1,"Iron man 1","112 views"));
//        arrayListAnh.add(new Image(R.drawable.iron2,"Iron man 2","113 views"));
//        arrayListAnh.add(new Image(R.drawable.iron3,"Iron man 3","1154 views"));
//        arrayListAnh.add(new Image(R.drawable.iron4,"Iron man 4","116views"));
//    }

    private void callapi(){
        RetrofitClient.getIntance().getListFavo(FULL_EXTRAS,
                "1", USER_ID, "json", KEY_TOKEN, GET_FAVO, page,
                80).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                arrayListAnh= response.body().getPhotos().getPhoto();
                anhAdapter= new AnhAdapter(MainActivity.this,arrayListAnh);

                StaggeredGridLayoutManager layoutManager=
                        new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(anhAdapter);
                recyclerView.setHasFixedSize(true);


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this,""+t,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.galleries:
                startActivity(new Intent(MainActivity.this, GalleriesActivity.class));
                overridePendingTransition(R.xml.slide_in_from_right, R.xml.slide_out_to_left);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}