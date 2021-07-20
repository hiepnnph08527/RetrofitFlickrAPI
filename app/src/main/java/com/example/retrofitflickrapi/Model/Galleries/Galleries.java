
package com.example.retrofitflickrapi.Model.Galleries;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Galleries {

    @SerializedName("galleries")
    @Expose
    private Galleries__1 galleries;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Galleries__1 getGalleries() {
        return galleries;
    }

    public void setGalleries(Galleries__1 galleries) {
        this.galleries = galleries;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
