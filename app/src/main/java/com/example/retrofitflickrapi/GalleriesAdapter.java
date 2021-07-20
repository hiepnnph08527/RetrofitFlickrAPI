package com.example.retrofitflickrapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitflickrapi.Interface.ItemClickListener;
import com.example.retrofitflickrapi.Model.Galleries.Gallery;

import java.util.ArrayList;

public class GalleriesAdapter extends RecyclerView.Adapter<GalleriesAdapter.GalleriesHolder>  {

    private ArrayList<Gallery> galleryArrayList;
    private ItemClickListener listener;

    public GalleriesAdapter(ArrayList<Gallery> galleryArrayList,ItemClickListener listener) {
        this.galleryArrayList = galleryArrayList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public GalleriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_galleries, parent, false);

        return new GalleriesHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleriesAdapter.GalleriesHolder holder, int position) {
        Gallery gallery = galleryArrayList.get(position);
        holder.txtNameGalleries.setText(gallery.getTitle().getContent());
       // holder.imgGalleries.setImageResource(gallery.set);
        holder.layout_galleries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onitemclick(gallery);
            }
        });

    }

    @Override
    public int getItemCount() {
        return galleryArrayList.size();
    }

    public class GalleriesHolder extends RecyclerView.ViewHolder {
        LinearLayout layout_galleries;
        TextView txtNameGalleries;
        ImageView imgGalleries;
        public GalleriesHolder(View itemView) {
            super(itemView);
            layout_galleries= itemView.findViewById(R.id.layout_album);
            txtNameGalleries=itemView.findViewById(R.id.txtNameGalleries);
            imgGalleries= itemView.findViewById(R.id.imgGalleries);
        }
    }
}
