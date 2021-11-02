package com.publicicat.restapi;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public class ChangeUserActivity extends AppCompatActivity {

    EditText userName;
    Button btnChangeUser;
    Activity activity;
    Context context;
    Constructor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeuser);

        ImageView dots = findViewById(R.id.right_icon);
        dots.setVisibility(View.GONE);
        ImageView back = findViewById(R.id.left_icon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ChangeUserActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        userName = (EditText) findViewById(R.id.edittext_Changeuser);
        btnChangeUser = (Button) findViewById(R.id.but_ChangeUser);

        btnChangeUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String fullNameInternet = userName.getText().toString();


                if ( fullNameInternet.equals("Publicicat_")) {
                    try {
                        // Thanks to: Mike M answer:
                        //If TextManager is not being used as an Activity, it should not extend an Activity.
                        // That's why the Context is null.
                        // Remove extends Start, and pass a Context to TextManager,
                        // either in a constructor, or a method.
                        //This made me realize no context had to be placed, so
                        //this works with getApplicationContext, but is essay-error escenario
                        //At: https://stackoverflow.com/questions/48741275/activity-instance-does-not-exist-null-object-reference

                        Constructor c = new Constructor(fullNameInternet, null, null, 0, 0);
                        DbConstructor dbC = new DbConstructor(getApplicationContext());
                        dbC.preInsertarNombre(c);


                        Intent one = new Intent(ChangeUserActivity.this, MainActivity.class);
                        //one.putExtra("fullNameInternet", fullNameInternet);
                        startActivity(one);

                        Toast.makeText(ChangeUserActivity.this, "You asked for " + fullNameInternet + " Instagram's account", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        Toast.makeText(ChangeUserActivity.this, "Something went wrong with " + fullNameInternet + " query, try again!", Toast.LENGTH_SHORT).show();
                        Log.e("Falló la conexion", e.toString());
                    }
                } else if (fullNameInternet.equals("Publicicat_No")) {
                    try {
                        int newIdFiltered = 1;

                        Constructor c = new Constructor(fullNameInternet, null, null, 0, 0);
                        DbConstructor dbC = new DbConstructor(getApplicationContext());
                        dbC.preInsertarNombre(c);


                        Intent one = new Intent(ChangeUserActivity.this, MainActivity.class);
                        //one.putExtra("fullNameInternet", fullNameInternet);
                        startActivity(one);

                        Toast.makeText(ChangeUserActivity.this, "You asked for " + fullNameInternet + " Instagram's account", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        Toast.makeText(ChangeUserActivity.this, "Something went wrong with " + fullNameInternet + " query, try again!", Toast.LENGTH_SHORT).show();
                        Log.e("Falló la conexion", e.toString());
                    }

                } else {
                    Toast.makeText(ChangeUserActivity.this, "We could not find any user with this name, try again!" , Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

}