package com.example.appli3a;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("Mytho.json")
    //@GET("dog")
    Call<RestResponse> getListPokemon();
}

