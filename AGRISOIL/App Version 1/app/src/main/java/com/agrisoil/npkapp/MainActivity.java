package com.agrisoil.npkapp;// !!!!------ IMPORTANT ---------!!!!//
// Ubah semua code setelah package nama.package.Anda dengan
// dengan Code berikut

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class MainActivity extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener{

    private Button btnRefresh;
    private Button latest_btn;

    private TextView txtData;
    private TextView txtdata2;
    private String TAG = "ANTARES-API";
    private AntaresHTTPAPI antaresAPIHTTP;
    private String dataDevice;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        // --- Inisialisasi UI yang digunakan di aplikasi --- //
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        //latest_btn = (Button) findViewById(R.id.latest_btn);


        txtData = (TextView) findViewById(R.id.txtData);
        //txtdata2 = (TextView) findViewById(R.id.txtData2);

        // --- Inisialisasi API Antares --- //
        //antaresAPIHTTP = AntaresHTTPAPI.getInstance();
        antaresAPIHTTP = new AntaresHTTPAPI();
        antaresAPIHTTP.addListener(this);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antaresAPIHTTP.getLatestDataofDevice("7a2b707551593efb:f8609170e186f667","Smartvillage_NPK","Alat_1");


            }
        });

//        latest_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                antaresAPIHTTP.createDevice("7a2b707551593efb:f8609170e186f667","Smartvillage_NPK","Alat_1");
//            }
//        });

        //bottom navigation
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

    @Override
//    public void onResponse(AntaresResponse antaresResponse) {
//        // --- Cetak hasil yang didapat dari ANTARES ke System Log --- //
//        Log.d(TAG,antaresResponse.toString());
//        Log.d(TAG,Integer.toString(antaresResponse.getRequestCode()));
//        if(antaresResponse.getRequestCode()==0){
//            try {
//                JSONObject body = new JSONObject(antaresResponse.getBody());
//                dataDevice = body.getJSONObject("m2m:cin").getString("con");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        txtData.setText(dataDevice);
//                    }
//                });
//                Log.d(TAG,dataDevice);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public void onResponse(AntaresResponse antaresResponse) {
        // --- Cetak hasil yang didapat dari ANTARES ke System Log --- //
        //Log.d(TAG,antaresResponse.toString());
        Log.d(TAG,Integer.toString(antaresResponse.getRequestCode()));
        if(antaresResponse.getRequestCode()==0){
            try {
                JSONObject body = new JSONObject(antaresResponse.getBody());
                dataDevice = body.getJSONObject("m2m:cin").getString("con");
                String[] split = dataDevice.split(",|:");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtData.setText("N: "+split[1]+"\n"+"P: "+split[2]+"\n"+"K: "+split[3]+"\n"+"Ph: "+split[4]+"\n"+"Moist: "+split[5]);
                        //txtdata2.setText("N: "+split[1]+"\n"+"P: "+split[2]+"\n"+"K: "+split[3]+"\n"+"Ph: "+split[4]+"\n"+"Moist: "+split[5]);
                    }
                });
                Log.d(TAG,dataDevice);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}