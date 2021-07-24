package com.example.retrofitflickrapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitflickrapi.Adapter.CommentAdapter;
import com.example.retrofitflickrapi.Model.Comment.Comment;
import com.example.retrofitflickrapi.Model.Comment.Comment__1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCommentActivity extends AppCompatActivity {
    RecyclerView rcvListComment;
    ArrayList<Comment__1> listComment;
    CommentAdapter commentAdapter;
    String idPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comment);
        rcvListComment= findViewById(R.id.rcv_list_comment);
        Intent intent= getIntent();
        idPhoto=intent.getStringExtra("idPhoto");
        getListComment();







    }
    //https://www.flickr.com/services/rest/?method=flickr.photos.comments.getList
     //&api_key=3633bfecbf708e160211dc18d56060c3&photo_id=51192760857&format=json&nojsoncallback=1
    public void getListComment() {

        RetrofitClient.getIntance().
                getListComment("flickr.photos.comments.getList","3633bfecbf708e160211dc18d56060c3",idPhoto,"json",1)
                .enqueue(new Callback<Comment>() {
                    @Override
                    public void onResponse(Call<Comment> call, Response<Comment> response) {
                        listComment= response.body().getComments().getComment();

                        LinearLayoutManager layoutManager= new LinearLayoutManager(ListCommentActivity.this,LinearLayoutManager.VERTICAL,true);
                        rcvListComment.setLayoutManager(layoutManager);
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvListComment.getContext(),
                                layoutManager.getOrientation());
                        rcvListComment.addItemDecoration(dividerItemDecoration);
                        commentAdapter= new CommentAdapter(listComment);
                        rcvListComment.setAdapter(commentAdapter);
                        rcvListComment.setHasFixedSize(true);


                        Toast.makeText(ListCommentActivity.this,""+response.code(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Comment> call, Throwable t) {
                        Toast.makeText(ListCommentActivity.this,""+t,Toast.LENGTH_SHORT).show();
                    }
                });
    }


//    private void addComment() {
//
//        listComment.add(new Comment__1("Hiep ahhaha1","DEP QUA1"));
//        listComment.add(new Comment__1("Hiep ahhaha2","DEP QUA2"));
//        listComment.add(new Comment__1("Hiep ahhaha3","DEP QUA3"));
//        listComment.add(new Comment__1("Hiep ahhaha4","DEP QUA4"));
//        listComment.add(new Comment__1("Hiep ahhaha5","DEP QUA5"));
//        listComment.add(new Comment__1("Hiep ahhaha6","DEP QUA7"));
//        listComment.add(new Comment__1("Hiep ahhaha7","DEP QUA8"));
//
//
//    }


}