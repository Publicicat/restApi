package com.publicicat.restapi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;

//Gson library
public class RestApiDesSerializadorMascota implements JsonDeserializer<RestApiMascotaResponse> {

    @Override
    public RestApiMascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        RestApiMascotaResponse restApiMascotaResponse = gson.fromJson(json, RestApiMascotaResponse.class);
        JsonArray restApiMascotaResponseDATA = json.getAsJsonObject().getAsJsonArray(RestApiDesJsonKeys.MEDIA_RESPONSE_ARRAY);

        //Aquesta funció recull les dades de deserialize(...) i crida a la funció de sota
        //per retornar estructurat com a array -segons hem declarat- les dades d'internet
        restApiMascotaResponse.setMascotasInternet(deserializarMascotasDeJson(restApiMascotaResponseDATA));
        return restApiMascotaResponse;
    }

    private ArrayList<ConstructorInternet> deserializarMascotasDeJson(JsonArray restApiMascotaResponseDATA) {
        ArrayList<ConstructorInternet> mascotasInternet = new ArrayList<>();
        for ( int i = 0; i < restApiMascotaResponseDATA.size(); i++ ) {
            JsonObject mascotaResponseDATAObject =
                    restApiMascotaResponseDATA.get(i).getAsJsonObject();
            String idInternet =
                    mascotaResponseDATAObject.get(RestApiDesJsonKeys.ID).getAsString();
            String fullNameInternet =
                    mascotaResponseDATAObject.get(RestApiDesJsonKeys.USER_FULLNAMAE).getAsString();
            String picInternet =
                    mascotaResponseDATAObject.get(RestApiDesJsonKeys.MEDIA_URL).getAsString();
            //Haurien de ser els likes però ja no es poden agafar, agafo el TimeStamp
            String likesInternet =
                    mascotaResponseDATAObject.get(RestApiDesJsonKeys.MEDIA_TIMESTAMP).getAsString();
            char firstCharTimestampString =
                    likesInternet.charAt(6);

            ConstructorInternet mascotaActual = new ConstructorInternet();
            mascotaActual.setIdInternet(idInternet);
            mascotaActual.setFullNameInternet(fullNameInternet);
            mascotaActual.setPicInternet(picInternet);
            mascotaActual.setLikesInternet(Character.toString(firstCharTimestampString));

            mascotasInternet.add(mascotaActual);
        }

        return mascotasInternet;
    }
}
