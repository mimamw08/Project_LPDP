package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import id.co.telkom.iot.AntaresHTTPAPI;

public class History_page extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;

    Button alat1;Button alat2;Button alat3;Button alat4;Button alat5;
    Button alat6;Button alat7;Button alat8;Button alat9;Button alat10;
    Button alat11;Button alat12;Button alat13;Button alat14;Button alat15;
    Button alat16;Button alat17;Button alat18;Button alat19;Button alat20;
    Button alat21;Button alat22;Button alat23;Button alat24;Button alat25;

    private String TAG = "ANTARES-API";
    private AntaresHTTPAPI antaresAPIHTTP;
    private String dataDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
        getSupportActionBar().hide();

        alat1 = (Button) findViewById(R.id.btn_alat1);
        alat2 = (Button) findViewById(R.id.btn_alat2);
        alat3 = (Button) findViewById(R.id.btn_alat3);
        alat4 = (Button) findViewById(R.id.btn_alat4);
        alat5 = (Button) findViewById(R.id.btn_alat5);
        alat6 = (Button) findViewById(R.id.btn_alat6);
        alat7 = (Button) findViewById(R.id.btn_alat7);
        alat8 = (Button) findViewById(R.id.btn_alat8);
        alat9 = (Button) findViewById(R.id.btn_alat9);
        alat10 = (Button) findViewById(R.id.btn_alat10);
        alat11 = (Button) findViewById(R.id.btn_alat11);
        alat12 = (Button) findViewById(R.id.btn_alat12);
        alat13 = (Button) findViewById(R.id.btn_alat13);
        alat14 = (Button) findViewById(R.id.btn_alat14);
        alat15 = (Button) findViewById(R.id.btn_alat15);
        alat16 = (Button) findViewById(R.id.btn_alat16);
        alat17 = (Button) findViewById(R.id.btn_alat17);
        alat18 = (Button) findViewById(R.id.btn_alat18);
        alat19 = (Button) findViewById(R.id.btn_alat19);
        alat20 = (Button) findViewById(R.id.btn_alat20);
        alat21 = (Button) findViewById(R.id.btn_alat21);
        alat22 = (Button) findViewById(R.id.btn_alat22);
        alat23 = (Button) findViewById(R.id.btn_alat23);
        alat24 = (Button) findViewById(R.id.btn_alat24);
        alat25 = (Button) findViewById(R.id.btn_alat25);


        alat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat1.class);
                startActivity(i);
            }
        });
        alat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat2.class);
                startActivity(i);
            }
        });alat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat3.class);
                startActivity(i);
            }
        });alat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat4.class);
                startActivity(i);
            }
        });alat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat5.class);
                startActivity(i);
            }
        });
        alat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat6.class);
                startActivity(i);
            }
        });
        alat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat7.class);
                startActivity(i);
            }
        });alat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat8.class);
                startActivity(i);
            }
        });alat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat9.class);
                startActivity(i);
            }
        });alat10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat10.class);
                startActivity(i);
            }
        });        alat11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat11.class);
                startActivity(i);
            }
        });
        alat12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat12.class);
                startActivity(i);
            }
        });alat13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat13.class);
                startActivity(i);
            }
        });alat14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat14.class);
                startActivity(i);
            }
        });alat15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat15.class);
                startActivity(i);
            }
        });        alat16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat16.class);
                startActivity(i);
            }
        });
        alat17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat17.class);
                startActivity(i);
            }
        });alat18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat18.class);
                startActivity(i);
            }
        });alat19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat19.class);
                startActivity(i);
            }
        });alat20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat20.class);
                startActivity(i);
            }
        });        alat21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat21.class);
                startActivity(i);
            }
        });
        alat22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat22.class);
                startActivity(i);
            }
        });alat23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat23.class);
                startActivity(i);
            }
        });alat24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat24.class);
                startActivity(i);
            }
        });alat25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(History_page.this, com.agrisoil.npkapp.alat25.class);
                startActivity(i);
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
                        startActivity(new Intent(getApplicationContext(), Meassur_page.class));
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_history:
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
