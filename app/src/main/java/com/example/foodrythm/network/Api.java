package com.example.foodrythm.network;

import com.example.foodrythm.models.SpoonacularSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/recipes/716429/information?apiKey=d45e9d02b3e04ad3bcbeb258d21b5cda")
    Call<SpoonacularSearchResponse> getRecipe(
            @Query("foodType") String foodType,
            @Query("term") String term
    );
}
