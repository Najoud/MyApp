package com.example.myappislami;

import com.example.myappislami.RadioModel.RadioResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APICalls {
 @GET("api/radio/radio_ar.json")
  Call<ResponseModel> getAllSources(@Query("apikey") String apikey);

    @GET("api/radio/radio_ar.json")

    Call<RadioResponse> getAllSources();





    }
