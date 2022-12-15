package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_page extends AppCompatActivity {
    EditText etLoginemail;
    EditText etLogispassword;

    Button login;
    Button login_phone;
    Button login_google;
    Button login_facebook;

    TextView gosignup;
    TextView forgetpass;

    FirebaseAuth mAuth;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        etLoginemail = (EditText) findViewById(R.id.email_addres);
        etLogispassword = (EditText) findViewById(R.id.password_login);

        login_google = (Button) findViewById(R.id.google_login_button);
        login_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });

        login = (Button) findViewById(R.id.login_btn);
        login.setOnClickListener(view ->{
            loginUser();
        });

        login_phone = (Button) findViewById(R.id.phone_login_btn);
        login_phone.setOnClickListener(view ->{
            startActivity(new Intent(Login_page.this, new_phoneregis_sendOTP.class));
        });

        gosignup = (TextView) findViewById(R.id.regis_txt_button);
        gosignup.setOnClickListener(view ->{
            startActivity(new Intent(Login_page.this, Register_page.class));
        });

        forgetpass = (TextView) findViewById(R.id.forgetpass_txt_btn);
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_page.this, ResetPassword.class));
            }
        });
    }

    private void loginUser(){
        String email = etLoginemail.getText().toString();
        String password = etLogispassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etLoginemail.setError("Email cannot be empty");
            etLoginemail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etLogispassword.setError("password cannot be empty");
            etLogispassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        if(mAuth.getCurrentUser().isEmailVerified()){
                            Toast.makeText(Login_page.this,"Login user succesfuly",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login_page.this, HOME.class));
                        }else{
                            Toast.makeText(Login_page.this,"Please verify email",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Login_page.this,"Login error "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void SignIn(){
        Intent SignInIntent = gsc.getSignInIntent();
        startActivityForResult(SignInIntent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 100){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                HomeActivity();
            }catch (ApiException e){
                Toast.makeText(Login_page.this,"Something went error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void HomeActivity() {
        finish();
        Intent intent = new Intent(getApplicationContext(), HOME.class);
        startActivity(intent);
    }

}


