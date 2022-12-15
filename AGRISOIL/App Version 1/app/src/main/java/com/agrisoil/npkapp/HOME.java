package com.agrisoil.npkapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.agrisoil.npkapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;


public class HOME extends AppCompatActivity {
    ImageView meassure;
    ImageView calculator;
    ImageView predict;
    ImageView history;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView user_email;

    FirebaseAuth mAuth;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null){
            String email = account.getEmail();
            user_email.setText(email);

        }else{
            String otherEmail = mAuth.getCurrentUser().getEmail();
            //user_email.setText(otherEmail);
        }

        user_email = (TextView) findViewById(R.id.user_email);
        user_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mAuth.getCurrentUser().getEmail();
                user_email.setText(email);
                startActivity(new Intent(HOME.this, Profile_activity.class));

            }
        });


        meassure = (ImageView) findViewById(R.id.Meassure_btn);
        meassure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to page antares
                Intent i = new Intent(HOME.this, Meassur_page.class);
                startActivity(i);
            }
        });

        predict = (ImageView) findViewById(R.id.Predict_btn);
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HOME.this, Predict_page.class));
            }
        });

        calculator = (ImageView) findViewById(R.id.Calculator_btn);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(HOME.this, CALCULATOR.class);
                startActivity(j);
            }
        });

        history = (ImageView) findViewById(R.id.History_btn);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(HOME.this, History_page.class);
                startActivity(k);
            }
        });

        //bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigaton);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        return true;
                    case R.id.menu_meassure:
                        startActivity(new Intent(getApplicationContext(), Meassur_page.class));
                        //overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_history:
                        startActivity(new Intent(getApplicationContext(), History_page.class));
                        //overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_calculator:
                        startActivity(new Intent(getApplicationContext(), CALCULATOR.class));
                        //overridePendingTransition(1,1);
                        return true;
                    case R.id.menu_predict:
                        startActivity(new Intent(getApplicationContext(), Predict_page.class));
                        //overridePendingTransition(1,1);
                        return true;
                }
                return false;
            }
        });
    }

    private void createNotif(){
        String id = "my_channel_id";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null){
                channel = new NotificationChannel(id,"Jdul notif",NotificationManager.IMPORTANCE_HIGH);
                //deskripsi
                channel.setDescription("[deskrpisi]");
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{100,1000,200,340});
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            }
        }
        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contenIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.history_icon).setContentTitle("Ini judul")
                .setContentText("Deskripsi")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{100,1000,200,340})
                .setAutoCancel(false)// bisa diswipe tapi tidak hilang notifnya
                .setTicker("Notifikasi");
        builder.setContentIntent(contenIntent);
        NotificationManagerCompat m = NotificationManagerCompat.from(getApplicationContext());
        //generate notif baru
        m.notify(1, builder.build());
    }
}