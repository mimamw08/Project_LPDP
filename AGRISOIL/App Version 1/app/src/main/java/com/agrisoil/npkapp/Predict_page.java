package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Predict_page extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict_page);
        getSupportActionBar().hide();

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setFirstDayOfWeek(1);

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
                        startActivity(new Intent(getApplicationContext(), Meassur_page.class));
                        overridePendingTransition(1,1);
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

                        return true;
                }
                return false;
            }
        });
    }
}