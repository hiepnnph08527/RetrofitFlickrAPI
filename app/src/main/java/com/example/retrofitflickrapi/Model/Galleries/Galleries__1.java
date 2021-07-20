
package com.example.retrofitflickrapi.Model.Galleries;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Galleries__1 {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("gallery")
    @Expose
    private ArrayList<Gallery> gallery = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public ArrayList<Gallery> getGallery() {
        return gallery;
    }

    public void setGallery(ArrayList<Gallery> gallery) {
        this.gallery = gallery;
    }

}
