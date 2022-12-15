package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CALCULATOR extends AppCompatActivity {

    ImageButton komb1;
    ImageButton komb2;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_calculator);

        komb1 = (ImageButton) findViewById(R.id.Kombinasi1);
        komb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CALCULATOR.this, Kombinasi1.class);
                startActivity(i);
            }
        });

        komb2 = (ImageButton) findViewById(R.id.Kombinasi2);
        komb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(CALCULATOR.this, kombinasi2.class);
                startActivity(j);
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigaton);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        startActivity(new Intent(getApplicationContext(), HOME.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu_meassure:
                        startActivity(new Intent(getApplicationContext(), Meassur_page.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu_history:
                        startActivity(new Intent(getApplicationContext(), History_page.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu_calculator:
                        return true;
                    case R.id.menu_predict:
                        startActivity(new Intent(getApplicationContext(), Predict_page.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}