package com.publicicat.restapi;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class DbConstructorTwo {

    private final Context context;

    public DbConstructorTwo(Context context) {
        this.context = context;
    }

    public ArrayList<Constructor> obtenerDatosMascotaProfileDb() {
        Db db = new Db(context);

        ContentValues contentValuesOne = new ContentValues();
        contentValuesOne.put(DbConfig.TABLE_MASCOTA_NAME,  "Turtles Castle");
        contentValuesOne.put(DbConfig.TABLE_MASCOTA_DESC, "Picture author, by Bjorn Graaf");
        contentValuesOne.put(DbConfig.TABLE_MASCOTA_EMAIL, "fish@stone.com");
        //contentValuesOne.put(DbConfig.TABLE_MASCOTA_PIC, R.drawable.dog_sidiney_carlos);
        db.insertarMascota(contentValuesOne);

        ContentValues contentValuesTwo = new ContentValues();
        contentValuesTwo.put(DbConfig.TABLE_MASCOTA_NAME,  "Ham");
        contentValuesTwo.put(DbConfig.TABLE_MASCOTA_DESC, "Picture author, by Ricardo Rodriguez");
        contentValuesTwo.put(DbConfig.TABLE_MASCOTA_EMAIL, "ham@stone.com");
        //contentValuesTwo.put(DbConfig.TABLE_MASCOTA_PIC, R.drawable.hamster_ricardo_rodriguez);
        db.insertarMascota(contentValuesTwo);

        ContentValues contentValuesThree = new ContentValues();
        contentValuesThree.put(DbConfig.TABLE_MASCOTA_NAME,  "Purr");
        contentValuesThree.put(DbConfig.TABLE_MASCOTA_DESC, "Picture author, by Ricardo Rodriguez");
        contentValuesThree.put(DbConfig.TABLE_MASCOTA_EMAIL, "cat@stone.com");
        //contentValuesThree.put(DbConfig.TABLE_MASCOTA_PIC, R.drawable.yuki_the_cat_emrah_errr);
        db.insertarMascota(contentValuesThree);

        return db.obtenerTodasLasMascotas();
    }

}

