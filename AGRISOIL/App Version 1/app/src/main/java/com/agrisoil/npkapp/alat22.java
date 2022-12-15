package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;

import org.json.JSONObject;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class alat22 extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener{

    private Button btnRefresh;
    private TextView txtdata;
    private ImageView bck_btn;

    private String TAG="ANTARES-API";
    private AntaresHTTPAPI antaresHTTPAPI;
    private String dataDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alat22);
        getSupportActionBar().hide();

        btnRefresh = (Button) findViewById(R.id.btnRefresh_alat22);

        txtdata = (TextView) findViewById(R.id.txtData_alat22);

        bck_btn = (ImageView) findViewById(R.id.bck_btn_alat22);

        antaresHTTPAPI = new AntaresHTTPAPI();
        antaresHTTPAPI.addListener(this);

        bck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(alat22.this, History_page.class));
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                antaresHTTPAPI.getLatestDataofDevice("7a2b707551593efb:f8609170e186f667","AplikasiNPK","Alat-22");
            }
        });

    }


    @Override
    public void onResponse(AntaresResponse antaresResponse) {
        Log.d(TAG,Integer.toString(antaresResponse.getRequestCode()));
        if(antaresResponse.getRequestCode()==0){
            try{
                JSONObject body = new JSONObject(antaresResponse.getBody());
                dataDevice = body.getJSONObject("m2m:cin").getString("con");
                String[] split = dataDevice.split(",|:");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtdata.setText("N: "+split[5]+"\n"+"P: "+split[6]+"\n"+"K: "+split[7]+"\n");
                    }
                });
                Log.d(TAG,dataDevice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}