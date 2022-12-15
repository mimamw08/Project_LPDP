package com.agrisoil.npkapp;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ada_user extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if (firebaseUser != null){
            startActivity(new Intent(ada_user.this, HOME.class));
        }

    }
}
