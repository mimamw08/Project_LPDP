package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class Meassur_page extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener {

    BottomNavigationView bottomNavigationView;

    ImageView mydata;
    ImageView map;
    ImageView back_arrow;

    Button p201;
    Button n113;
    Button o313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meassur_page);
        getSupportActionBar().hide();

        mydata = (ImageView) findViewById(R.id.goto_mydata);
        map = (ImageView) findViewById(R.id.addData_map);
        back_arrow = (ImageView) findViewById(R.id.back_arrow_add);
        p201 = (Button) findViewById(R.id.p201_btn);
        n113 = (Button) findViewById(R.id.n113_btn);
        o313 = (Button) findViewById(R.id.o313_btn);

        mydata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meassur_page.this, Mydata_page.class));
            }
        });
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meassur_page.this, HOME.class));
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meassur_page.this, Map_activity.class));
            }
        });

        p201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Meassur_page.this);
                bottomSheetDialog.setContentView(R.layout.p201);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                EditText device_EUI = bottomSheetDialog.findViewById(R.id.lora_deviceEUI_p201);
                EditText device_ID = bottomSheetDialog.findViewById(R.id.lora_deviceID_p201);
                EditText device_Address = bottomSheetDialog.findViewById(R.id.lora_deviceAddress_p201);
                Button submit = bottomSheetDialog.findViewById(R.id.submit_p201);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Meassur_page.this, HOME.class));
                    }
                });
                bottomSheetDialog.show();
            }

        });

        n113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Meassur_page.this);
                bottomSheetDialog.setContentView(R.layout.n113);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                EditText device_EUI = bottomSheetDialog.findViewById(R.id.lora_deviceEUI_n113);
                EditText device_ID = bottomSheetDialog.findViewById(R.id.lora_deviceID_n113);
                EditText device_Address = bottomSheetDialog.findViewById(R.id.lora_deviceAddress_n113);
                Button submit = bottomSheetDialog.findViewById(R.id.submit_n113);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Meassur_page.this, HOME.class));
                    }
                });
                bottomSheetDialog.show();
            }
        });

        o313.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Meassur_page.this);
                bottomSheetDialog.setContentView(R.layout.o313);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                EditText device_EUI = bottomSheetDialog.findViewById(R.id.lora_deviceEUI_o313);
                EditText device_ID = bottomSheetDialog.findViewById(R.id.lora_deviceID_o313);
                EditText device_Address = bottomSheetDialog.findViewById(R.id.lora_deviceAddress_o313);
                Button submit = bottomSheetDialog.findViewById(R.id.submit_o313);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Meassur_page.this, HOME.class));
                    }
                });
                bottomSheetDialog.show();
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

                        return true;
                    case R.id.menu_meassure:
                        return true;
                    case R.id.menu_history:
                        startActivity(new Intent(getApplicationContext(), History_page.class));

                        return true;
                    case R.id.menu_calculator:
                        startActivity(new Intent(getApplicationContext(), CALCULATOR.class));

                        return true;
                    case R.id.menu_predict:
                        startActivity(new Intent(getApplicationContext(), Predict_page.class));

                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onResponse(AntaresResponse antaresResponse) {
        // --- Cetak hasil yang didapat dari ANTARES ke System Log --- //
        //Log.d(TAG,antaresResponse.toString());

    }
}