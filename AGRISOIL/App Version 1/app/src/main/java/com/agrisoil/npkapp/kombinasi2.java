package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;

public class kombinasi2 extends AppCompatActivity {
    EditText InputN;
    EditText InputP;
    EditText InputK;

    Button CAN;
    Button SSP;
    Button MOP;

    TextView hasilCAN;
    TextView hasilSSP;
    TextView hasilMOP;

    ImageView back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kombinasi2);
        getSupportActionBar().hide();

        InputN = (EditText) findViewById(R.id.input_komb2_N);
        InputP = (EditText) findViewById(R.id.input_komb2_P);
        InputK = (EditText) findViewById(R.id.input_komb2_K);

        CAN = (Button) findViewById(R.id.can_komb2);
        SSP = (Button) findViewById(R.id.ssp_komb2);
        MOP = (Button) findViewById(R.id.mop_komb2);

        hasilCAN = (TextView) findViewById(R.id.hasil_can_komb1);
        hasilSSP = (TextView) findViewById(R.id.hasil_ssp_komb2);
        hasilMOP = (TextView) findViewById(R.id.hasil_mop_komb2);

        back_arrow = (ImageView) findViewById(R.id.back_arrow_komb2);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(kombinasi2.this, CALCULATOR.class));
            }
        });

        CAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double can = Double.parseDouble(InputN.getText().toString());
                double hasi_can = can *  3.8461537;
                hasilCAN.setText(Double.toString(hasi_can));
            }
        });

        SSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ssp = Double.parseDouble(InputP.getText().toString());
                double hasi_ssp = ssp * 6.25;
                hasilSSP.setText(Double.toString(hasi_ssp));
            }
        });

        MOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mop = Double.parseDouble(InputK.getText().toString());
                double hasi_mop = mop * 1.6666666;
                hasilMOP.setText(Double.toString(hasi_mop));
            }
        });
    }
}