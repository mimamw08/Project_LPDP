package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;

public class language_page extends AppCompatActivity {

    ImageView bck_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_page);
        getSupportActionBar().hide();

        bck_btn = (ImageView) findViewById(R.id.bck_btn1);
        bck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(language_page.this, Profile_activity.class));
            }
        });
    }
}