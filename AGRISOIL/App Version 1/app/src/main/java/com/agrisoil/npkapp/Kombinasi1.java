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

public class Kombinasi1 extends AppCompatActivity {

    EditText InputN;
    EditText InputP;
    EditText InputK;

    Button Urea;
    Button SSP;
    Button MOP;

    TextView hasilUrea;
    TextView hasilSSP;
    TextView hasilMOP;

    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kombinasi1);
        getSupportActionBar().hide();

        InputN = (EditText) findViewById(R.id.input_komb1_N);
        InputP = (EditText) findViewById(R.id.input_komb1_P);
        InputK = (EditText) findViewById(R.id.input_komb1_K);

        Urea = (Button) findViewById(R.id.Urea_komb1);
        SSP = (Button) findViewById(R.id.ssp_komb1);
        MOP = (Button) findViewById(R.id.mop_komb1);

        hasilUrea = (TextView) findViewById(R.id.hasil_urea_komb1);
        hasilSSP = (TextView) findViewById(R.id.hasil_ssp_komb1);
        hasilMOP = (TextView) findViewById(R.id.hasil_mop_komb1);

        back_arrow = (ImageView) findViewById(R.id.back_arrow_komb1);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Kombinasi1.this, CALCULATOR.class));
            }
        });

        Urea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double urea = Double.parseDouble(InputN.getText().toString());
                double hasi_urea = urea * 2.173913;
                hasilUrea.setText(Double.toString(hasi_urea));
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