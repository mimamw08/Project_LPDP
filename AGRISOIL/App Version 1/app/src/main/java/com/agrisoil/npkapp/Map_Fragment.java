package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.agrisoil.npkapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Map_Fragment extends Fragment {

    Button view_tools;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_, container, false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
//                        MarkerOptions markerOptions = new MarkerOptions();
//                        markerOptions.position(latLng);
//                        markerOptions.title(latLng.latitude+":"+latLng.longitude);
//                        googleMap.clear();
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));

                        LatLng TelU = new LatLng(-6.9733731, 107.6300012);
                        googleMap.addMarker(new MarkerOptions().position(TelU).title("Telkom University"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(TelU));
                        googleMap.getUiSettings().setZoomControlsEnabled(true);
                        googleMap.getUiSettings().setZoomGesturesEnabled(true);
                    }
                });
            }
        });

        view_tools = (Button) view.findViewById(R.id.btn_tools);
        view_tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.bottom_sheet);
                bottomSheetDialog.setCanceledOnTouchOutside(false);

                ImageView kangkung = bottomSheetDialog.findViewById(R.id.kangkung);
                ImageView mangga = bottomSheetDialog.findViewById(R.id.mangga);
                ImageView rambutan = bottomSheetDialog.findViewById(R.id.rambutan);

                kangkung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), alat1.class));
                    }
                });

                mangga.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), alat1.class));
                    }
                });

                rambutan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), alat1.class));
                    }
                });
                bottomSheetDialog.show();
            }
        });
        return view;
    }


}