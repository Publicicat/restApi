package com.publicicat.restapi;

import android.content.Context;
import android.os.Bundle;

public final class RestApiConstantes {

    public static final String ROOT_URL = "https://graph.instagram.com";
    public static final String ID = "/me/media";
    public static final String GET_INFORMATION = "?fields=id,media_type,media_url,username,timestamp";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String ACCESS_TOKEN = "";
    public static final String URL_GET_RECENT_MEDIA_USER = ID + GET_INFORMATION + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}
