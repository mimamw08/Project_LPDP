package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;

public class Notification_settings extends AppCompatActivity {

    ImageView bck_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        getSupportActionBar().hide();

        bck_btn = (ImageView) findViewById(R.id.bck_btn2);
        bck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Notification_settings.this, Profile_activity.class));
            }
        });
    }
}