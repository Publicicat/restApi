package com.publicicat.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView dots = findViewById(R.id.right_icon);
        dots.setVisibility(View.GONE);
        ImageView back = findViewById(R.id.left_icon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


}
