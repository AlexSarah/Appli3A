package com.example.appli3a;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/AlexSarah/APIMythologie/master/")
                //.baseUrl("https://raw.githubusercontent.com/Metasilveur/MobileFireEmblem/master/dogApi.json")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestApi restApi = retrofit.create(RestApi.class);

        Call<RestResponse> call = restApi.getListPokemon();
        call.enqueue(new Callback<RestResponse>() {
            @Override
            public void onResponse(Call<RestResponse> call, Response<RestResponse> response) {
                RestResponse restResponse = response.body();
                List<Api> listPokemon = restResponse.getResults();
                activity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error because onFailure");
            }
        });
    }
}
