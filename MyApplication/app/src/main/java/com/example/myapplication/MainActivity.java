package com.example.myapplication;// !!!!------ IMPORTANT ---------!!!!//
// Ubah semua code setelah package nama.package.Anda dengan
// dengan Code berikut

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class MainActivity extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener{

    private Button btnRefresh;
    private Button btnOn;
    private Button btnOff;

    private TextView txtData;
    private TextView txt_data;
    private String TAG = "ANTARES-API";
    private AntaresHTTPAPI antaresAPIHTTP;
    private String dataDevice;
    private String nilai_npk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Inisialisasi UI yang digunakan di aplikasi --- //
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
//        btnOff = (Button) findViewById(R.id.btnOff);
//        btnOn = (Button) findViewById(R.id.btnOn);

        txtData = (TextView) findViewById(R.id.txtData);
//        txt_data = (TextView) findViewById(R.id.txt_data);

        // --- Inisialisasi API Antares --- //
        //antaresAPIHTTP = AntaresHTTPAPI.getInstance();
        antaresAPIHTTP = new AntaresHTTPAPI();
        antaresAPIHTTP.addListener(this);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antaresAPIHTTP.getLatestDataofDevice("7a2b707551593efb:f8609170e186f667","Smartvillage_NPK","\n" +
                        "Alat_1");
                antaresAPIHTTP.getOldestDataofDevice("7a2b707551593efb:f8609170e186f667","Smartvillage_NPK","\n" +
                        "Alat_1");

            }
        });

//        btnOn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                antaresAPIHTTP.storeDataofDevice(1,"your-access-key", "your-application-name", "your-device-name", "{\\\"status\\\":\\\"1\\\"}");
//
//            }
//        });
//
//        btnOff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                antaresAPIHTTP.storeDataofDevice(1,"your-access-key", "your-application-name", "your-device-name", "{\\\"status\\\":\\\"0\\\"}");
//            }
//        });
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(AntaresResponse antaresResponse){
        // --- Cetak hasil yang didapat dari ANTARES ke System Log --- //
        Log.d(TAG, antaresResponse.toString());
        Log.d(TAG, Integer.toString(antaresResponse.getRequestCode()));

        if(antaresResponse.getRequestCode()==0){
            try{
                //Memanggil json dan melakukan proses parsing meng-getstring
                JSONObject body = new JSONObject(antaresResponse.getBody());
                dataDevice = body.getJSONObject("m2m:cin").getString("con");
                //Proses melakukan formatting sesuai output yang ditentukan
                String[]separated = dataDevice.split(",");
                //String[]split = dataDevice.split(":");
                //String[][] result = new String[separated.length][];
                //String[][] object = Stream.of(separated).map( e-> e.split(";")).toArray(String[][]::new);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        for (int i=0; i<separated.length; i++){
//                            result[i] = separated[i].split(":");
//                            //txtData.setText(result[0]);
//                        }
                        //txtData.setText(Arrays.deepToString(object));
                        txtData.setText("N: "+separated[2]+"\n"+"P: "+separated[3]+"\n"+"K: "+separated[4]+"\n"+"pH: "+separated[5]+"\n"+"Moisture: "+separated[6]);
                        //txtData.setText(separated[8]);
                    }
                });
                Log.d(TAG,dataDevice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
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

}

