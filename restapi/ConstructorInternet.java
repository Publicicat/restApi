package com.publicicat.restapi;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ConstructorInternet {

    private String idInternet;
    private String fullNameInternet;
    private String likesInternet;
    private String picInternet;//url


    public ConstructorInternet(String fullNameInternet, String likesInternet,String picInternet){
        this.fullNameInternet = fullNameInternet;
        this.likesInternet = likesInternet;
        this.picInternet = picInternet;
    }

    public ConstructorInternet() {
    }

    public String getIdInternet() {
        return idInternet;
    }

    public void setIdInternet(String idInternet) {
        this.idInternet = idInternet;
    }

    public String getFullNameInternet() {
        return fullNameInternet;
    }

    public void setFullNameInternet(String fullNameInternet) {
        this.fullNameInternet = fullNameInternet;
    }

    public String getLikesInternet() {
        return likesInternet;
    }

    public void setLikesInternet(String likesInternet) {
        this.likesInternet = likesInternet;
    }

    public String getPicInternet() {
        return picInternet;
    }

    public void setPicInternet(String picInternet) {
        this.picInternet = picInternet;
    }

}
