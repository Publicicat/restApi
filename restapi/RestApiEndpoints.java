package com.publicicat.restapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiEndpoints  {

    // Modifiquem el GET que hem demanat al propi perfil d'instragram
    // i el convertim en una string a partir dels arrays[] i objectes {} de JSON

    //RestApiMascotaResponse és una clase definida en un arxiu de nom igual
    //on declarem que retornarem un array -el json transformat en array-.

    //Amb els mètodes definits del get i el set al constructor RestApiMascotaResponse
    //i sabent que se'ns retorna un array, demanem agafar les dades necessàries
    //util·litzant la part dinàmica de la url que farem servir per la connexió
    //La primera part de la url està definida a l'adapter RestApiAdapter.

    @GET(RestApiConstantes.URL_GET_RECENT_MEDIA_USER)
    Call<RestApiMascotaResponse> getRecentMedia();

}
