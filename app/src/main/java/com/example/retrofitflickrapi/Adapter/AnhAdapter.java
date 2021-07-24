package com.example.retrofitflickrapi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitflickrapi.DetailActivity;
import com.example.retrofitflickrapi.Model.Favorite.Photo;
import com.example.retrofitflickrapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AnhAdapter extends RecyclerView.Adapter<AnhAdapter.ViewHolder> {
    private Context context;
    ArrayList<Photo> arrayListAnh;

    public AnhAdapter(Context context, ArrayList<Photo> arrayListAnh) {
        this.context = context;
        this.arrayListAnh = arrayListAnh;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.item_main,parent,false);
        ViewHolder viewHolder  = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AnhAdapter.ViewHolder holder, int position) {
        Photo photo= arrayListAnh.get(position);
        Picasso.with(context).load(photo.getUrlZ()).into(holder.imgAnh);
        holder.txtTen.setText(photo.getTitle());
        holder.txtViews.setText(photo.getViews()+" views");

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, DetailActivity.class);
                Bundle bundle= new Bundle();
                intent.putExtra("anh",photo);
//                intent.putExtra("urlL",photo.getUrlL());
//                intent.putExtra("photo_id",photo.getUrlO());
//                intent.putExtra("urlZ",photo.getUrlZ());
//                intent.putExtra("ownerName",photo.getOwnername());
//                intent.putExtra("sizeL",photo.getHeightL()+"x"+photo.getWidthL());
//                intent.putExtra("sizeC",photo.getHeightC()+"x"+photo.getWidthC());
//                intent.putExtra("sizeZ",photo.getHeightZ()+"x"+photo.getWidthZ());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListAnh.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imgAnh;
        TextView txtTen,txtViews;
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAnh= itemView.findViewById(R.id.imgAnh);
           txtTen= itemView.findViewById(R.id.txtTen);
           txtViews=itemView.findViewById(R.id.txtViews);
            parentLayout= itemView.findViewById(R.id.parent_layout);


        }


    }
}
