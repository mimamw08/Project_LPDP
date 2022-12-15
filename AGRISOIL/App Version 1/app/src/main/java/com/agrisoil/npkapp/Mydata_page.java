package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Mydata_page extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    ImageView mydata;
    ImageView back_arrow;
    ImageView maps;

    Button antares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata_page);

        getSupportActionBar().hide();

        mydata = (ImageView) findViewById(R.id.my_data);
        back_arrow = (ImageView) findViewById(R.id.back_arrow_mydata);
        maps = (ImageView) findViewById(R.id.my_data_map);
        antares = (Button) findViewById(R.id.antares);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mydata_page.this, Map_activity.class));
            }
        });

        mydata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mydata_page.this, Meassur_page.class));
            }
        });

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mydata_page.this, Meassur_page.class));
            }
        });

        antares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mydata_page.this, MainActivity.class));
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
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_meassure:
                        return true;
                    case R.id.menu_history:
                        startActivity(new Intent(getApplicationContext(), History_page.class));
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_calculator:
                        startActivity(new Intent(getApplicationContext(), CALCULATOR.class));
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_predict:
                        startActivity(new Intent(getApplicationContext(), Predict_page.class));
                        overridePendingTransition(1,1);
                        return true;
                }
                return false;
            }
        });
    }
}