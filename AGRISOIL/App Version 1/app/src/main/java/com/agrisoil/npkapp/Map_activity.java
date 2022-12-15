package com.agrisoil.npkapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.agrisoil.npkapp.R;
import com.agrisoil.npkapp.databinding.ActivityMapBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Map_activity extends AppCompatActivity {
    private BottomSheetBehavior behavior;
    private GoogleMap map;
    private ActivityMapBinding binding;

    Button tools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().hide();

        Fragment fragment = new Map_Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();


//        View bottomSheet = findViewById(R.id.sheet);
//        behavior = BottomSheetBehavior.from(bottomSheet);
//        behavior.setPeekHeight(120);
//        behavior.setHideable(true);

    }

}