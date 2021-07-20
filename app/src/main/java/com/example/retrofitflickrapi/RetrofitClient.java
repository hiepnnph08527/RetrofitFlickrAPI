package com.example.retrofitflickrapi;

import com.example.retrofitflickrapi.Interface.APIService;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static APIService service;
    private static String BASE_URL="https://www.flickr.com/";;

    public static APIService getIntance(){
        if(service==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(APIService.class);
        }
        return service;
    }




}
