package com.publicicat.restapi;

public class Constructor {

    private int id;
    private String name;
    private String desc;
    private String email;

    private int picId;
    private int pic;
    private int votes = 0;


    public Constructor (String name, String desc, String email,  int pic, int votes) {
        this.name = name;
        this.desc = desc;
        this.votes = votes;
        this.pic = pic;
    }

    public Constructor (String name) {
        this.name = name;
    }

    public Constructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}

