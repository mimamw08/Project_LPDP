package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class Profile_activity extends AppCompatActivity {

    TextView user_email;
    Button logout;
    Button language_btn;
    Button notification_btn;
    ImageView back;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        back = (ImageView) findViewById(R.id.profile_back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (Profile_activity.this, HOME.class));
            }
        });

        user_email = (TextView) findViewById(R.id.profile_email);
        user_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mAuth.getCurrentUser().getEmail();
                user_email.setText(email);
            }
        });

        language_btn = (Button) findViewById(R.id.language_btn);
        language_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile_activity.this, language_page.class));
            }
        });

        notification_btn = (Button) findViewById(R.id.notification_btn);
        notification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile_activity.this, Notification_settings.class));
            }
        });

        logout = (Button) findViewById(R.id.keluar_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // keluar Home
                mAuth.signOut();
                Toast.makeText(Profile_activity.this,"Account Logout",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Profile_activity.this, Login_page.class));
            }
        });
    }
}