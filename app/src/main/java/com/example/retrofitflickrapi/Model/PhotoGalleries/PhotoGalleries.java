
package com.example.retrofitflickrapi.Model.PhotoGalleries;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PhotoGalleries {

    @SerializedName("photos")
    @Expose
    private Photos2 photos;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Photos2 getPhotos() {
        return photos;
    }

    public void setPhotos(Photos2 photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
