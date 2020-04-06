package com.example.vumobile_test_app.api;

import com.example.vumobile_test_app.model.Images;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {


   // Image
    @GET("/api/users?page=1")
    Call<List<Images>> getImageandName();



}

