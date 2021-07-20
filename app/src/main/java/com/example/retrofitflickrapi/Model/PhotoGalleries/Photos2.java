
package com.example.retrofitflickrapi.Model.PhotoGalleries;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Photos2 {

    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("perpage")
    @Expose
    private String perpage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("photo")
    @Expose
    private ArrayList<Photo2> photo = null;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ArrayList<Photo2> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<Photo2> photo) {
        this.photo = photo;
    }

}
