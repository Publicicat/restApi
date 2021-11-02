package com.publicicat.restapi;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbConstructor {

    private final Context context;
    private static final int VOTE = 1;
    private static final int MASCOTAIDTEST = 2;
    public DbConstructor(Context context) {
        this.context = context;
    }

    //FRAGMENT ONE + FILL THE DATABASE FOR FIRST TIME
    public ArrayList<Constructor> obtenerDatosDb() {
        Db db = new Db(context);

        String query = "SELECT COUNT (*) FROM " + DbConfig.TABLE_MASCOTA;

        SQLiteDatabase dbCheck = db.getWritableDatabase();
        Cursor registros = dbCheck.rawQuery(query, null);

        if (registros != null) {
            registros.moveToFirst();
            if(registros.getInt(0) == 0 ) {
                //Zero means the table is empty, because SELECT COUNT always return a row that if it is empty is 0 in his integer value (getInt)
                //Thanks to paxdiablo here:
                // https://stackoverflow.com/questions/4397757/how-can-i-check-to-see-if-my-sqlite-table-has-data-in-it
                ContentValues contentValuesOne = new ContentValues();
                contentValuesOne.put(DbConfig.TABLE_MASCOTA_NAME,  "Dog the Dog");
                contentValuesOne.put(DbConfig.TABLE_MASCOTA_DESC, "Picture author, by Bjorn Graaf");
                contentValuesOne.put(DbConfig.TABLE_MASCOTA_EMAIL, "fish@stone.com");
                db.insertarMascota(contentValuesOne);

                ContentValues contentValuesOnePic = new ContentValues();
                contentValuesOnePic.put(DbConfig.TABLE_PIC_PIC, R.drawable.dog_sidiney_carlos);
                contentValuesOnePic.put(DbConfig.TABLE_PIC_MASCOTA_ID, 1);
                db.insertarPicsMascota(contentValuesOnePic);

                ContentValues contentValuesOneNameInsta = new ContentValues();
                contentValuesOneNameInsta.put(DbConfig.COL_INSTA_NAME, "Publicicat_");
                contentValuesOneNameInsta.put(DbConfig.COL_INSTA_MASCOTA_ID, 1);
                db.insertarToken(contentValuesOneNameInsta);

                ContentValues contentValuesTwo = new ContentValues();
                contentValuesTwo.put(DbConfig.TABLE_MASCOTA_NAME,  "Ham");
                contentValuesTwo.put(DbConfig.TABLE_MASCOTA_DESC, "Picture author, by Ricardo Rodriguez");
                contentValuesTwo.put(DbConfig.TABLE_MASCOTA_EMAIL, "ham@stone.com");
                db.insertarMascota(contentValuesTwo);

                ContentValues contentValuesTwoPic = new ContentValues();
                contentValuesTwoPic.put(DbConfig.TABLE_PIC_PIC, R.drawable.hamster_ricardo_rodriguez);
                contentValuesTwoPic.put(DbConfig.TABLE_PIC_MASCOTA_ID, 2);
                db.insertarPicsMascota(contentValuesTwoPic);

                ContentValues contentValuesTwoNameInsta = new ContentValues();
                contentValuesTwoNameInsta.put(DbConfig.COL_INSTA_NAME, "Publicicat_2");
                contentValuesTwoNameInsta.put(DbConfig.COL_INSTA_MASCOTA_ID, 2);
                db.insertarToken(contentValuesTwoNameInsta);

                ContentValues contentValuesThree = new ContentValues();
                contentValuesThree.put(DbConfig.TABLE_MASCOTA_NAME,  "Purr");
                contentValuesThree.put(DbConfig.TABLE_MASCOTA_DESC, "Picture author, by Ricardo Rodriguez");
                contentValuesThree.put(DbConfig.TABLE_MASCOTA_EMAIL, "cat@stone.com");
                db.insertarMascota(contentValuesThree);

                ContentValues contentValuesThreePic = new ContentValues();
                contentValuesThreePic.put(DbConfig.TABLE_PIC_PIC, R.drawable.yuki_the_cat_emrah_errr);
                contentValuesThreePic.put(DbConfig.TABLE_PIC_MASCOTA_ID, 3);
                db.insertarPicsMascota(contentValuesThreePic);

                ContentValues contentValuesFourPic = new ContentValues();
                contentValuesFourPic.put(DbConfig.TABLE_PIC_PIC, R.drawable.fish_louis_hall);
                contentValuesFourPic.put(DbConfig.TABLE_PIC_MASCOTA_ID, 3);
                db.insertarPicsMascota(contentValuesFourPic);

            } else {
                //If result is not zero, table is not empty
            }
        }

        return db.obtenerTodasLasMascotas();
    }

    public void darVoteMascota(Constructor mascota) {
        Db db = new Db(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbConfig.TABLE_LIKES_MASCOTA_ID, mascota.getId());
        contentValues.put(DbConfig.TABLE_LIKES_PIC_ID, mascota.getPicId());
        contentValues.put(DbConfig.TABLE_LIKES_NUM_VOTES, VOTE);
        db.insertarVoteMascota(contentValues);
    }

    public int obtenerVotesMascota(Constructor mascota){
        Db db = new Db (context);
        return db.obtenerVotesMascota(mascota);
    }

    //FRAGMENT TWO
    public ArrayList<Constructor> obtenerDatosUnaMascotaDb() {
        Db dbUnaMascota = new Db(context);
        return dbUnaMascota.obtenerUnaSolaMascota();
    }

    public int obtenerVotesUnaMascota(Constructor mascota){
        Db dbUnaMascota = new Db (context);
        return dbUnaMascota.obtenerVotesUnaMascota(mascota);
    }

    //FRAGMENT THREE
    public void preInsertarNombre(Constructor c){
        Db db = new Db(context);
        ContentValues cv = new ContentValues();
        cv.put(DbConfig.COL_INSTA_NAME, c.getName());
        cv.put(DbConfig.COL_INSTA_MASCOTA_ID, MASCOTAIDTEST);
        db.insertarNombre(cv);
    }

    public String obtenerNombreString(){
        Db obtenerNombreDesdeActivity = new Db(context);
        return obtenerNombreDesdeActivity.obtenerString();
    }


}

