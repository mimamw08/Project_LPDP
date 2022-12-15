package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;

public class Welcome_page extends AppCompatActivity {
    Button signin;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome_page);

        signin = (Button) findViewById(R.id.signin_btn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome_page.this, Login_page.class);
                startActivity(i);
            }
        });

        signup = (TextView) findViewById(R.id.signup_txt_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Welcome_page.this, Register_page.class);
                startActivity(j);
            }
        });
    }
}