package com.publicicat.restapi;

public class DbConfig {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NAME = "name";
    public static final String TABLE_MASCOTA_DESC = "description";
    public static final String TABLE_MASCOTA_EMAIL = "email";
    //public static final String TABLE_MASCOTA_PIC = "pic";

    public static final String TABLE_PIC = "mascota_pics";
    public static final String TABLE_PIC_ID = "id";
    public static final String TABLE_PIC_MASCOTA_ID = "mascota_id";
    public static final String TABLE_PIC_PIC = "pic";

    public static final String TABLE_LIKES = "mascota_likes";
    public static final String TABLE_LIKES_ID = "id";
    public static final String TABLE_LIKES_MASCOTA_ID = "mascota_id";
    public static final String TABLE_LIKES_PIC_ID = "pic_id";
    public static final String TABLE_LIKES_NUM_VOTES = "num_votes";

    public static final String TABLE_INSTA = "mascota_insta";
    public static final String COL_INSTA_ID = "id";
    public static final String COL_INSTA_MASCOTA_ID = "mascota_id";
    public static final String COL_INSTA_NAME = "name";

}

