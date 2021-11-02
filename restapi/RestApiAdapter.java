package com.publicicat.restapi;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {


    public RestApiEndpoints establecerConexionRestApiInstragram(Gson gsonMascotaInternet) {

        //Part de la query al servidor d'Instragram amb la url fixa.
        //La part dinàmica que demanarà les diferents fotos a partir
        //de les dades de l'arxiu JSON és la part de la url que està declarada
        //a la interfície RestApiEndPoints (Interface).
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestApiConstantes.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonMascotaInternet))
                .build();

        return retrofit.create(RestApiEndpoints.class);
    }

    //Tot el que ve de RestApiDesSerializadorMascota
    // s'ajusti a RestApiMascotaResponse
    public Gson construyeGsonDesSerializadorMascotaInternet() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RestApiMascotaResponse.class, new RestApiDesSerializadorMascota());

        return gsonBuilder.create();
    }
}
