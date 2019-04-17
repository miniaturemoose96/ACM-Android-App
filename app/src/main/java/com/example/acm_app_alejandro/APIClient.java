package com.example.acm_app_alejandro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL = "https://mlh-events.now.sh/";
    public static Retrofit retrofit;

    //We use the singleton pattern to insure that only one Retrofit instance is   made at a time.
    //This helps data from getting messed.
    public static Retrofit getApiClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    //JSON converts Java objects to their JSON representation
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
