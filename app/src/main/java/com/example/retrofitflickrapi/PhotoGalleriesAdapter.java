package com.example.retrofitflickrapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitflickrapi.Model.PhotoGalleries.Photo2;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoGalleriesAdapter extends RecyclerView.Adapter<PhotoGalleriesAdapter.PhotoGalleriesHolder> {

    private ArrayList<Photo2> arrPhotoGalleries;
    private Context Mcontext;

    public PhotoGalleriesAdapter(ArrayList<Photo2> arrPhotoGalleries, Context context) {
        this.arrPhotoGalleries = arrPhotoGalleries;
        this.Mcontext=context;
    }

    @NonNull
    @Override
    public PhotoGalleriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photogalleries, parent, false);

        return new PhotoGalleriesAdapter.PhotoGalleriesHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoGalleriesAdapter.PhotoGalleriesHolder holder, int position) {
        Photo2 photo=arrPhotoGalleries.get(position);
        Picasso.with(Mcontext).load(photo.getUrlC()).into(holder.imgPhotoGalleries);
        holder.txtnamePhoto.setText(photo.getTitle());
        holder.txtViewsPhoto.setText(photo.getViews()+" views");

    }

    @Override
    public int getItemCount() {
        return arrPhotoGalleries.size();
    }

    public class PhotoGalleriesHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotoGalleries;
        TextView txtnamePhoto,txtViewsPhoto;
        public PhotoGalleriesHolder(View itemView) {
            super(itemView);
            imgPhotoGalleries =itemView.findViewById(R.id.imgPhotoGalleries);
            txtnamePhoto=itemView.findViewById(R.id.txtTenPhoto);
            txtViewsPhoto=itemView.findViewById(R.id.txtViewsPhoto);

        }
    }
}
