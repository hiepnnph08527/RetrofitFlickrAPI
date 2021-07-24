
package com.example.retrofitflickrapi.Model.Comment;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Comments {

    @SerializedName("photo_id")
    @Expose
    private String photoId;
    @SerializedName("comment")
    @Expose
    private ArrayList<Comment__1> comment = null;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public ArrayList<Comment__1> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment__1> comment) {
        this.comment = comment;
    }

}
