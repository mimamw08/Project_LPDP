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
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Register_page extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    EditText email;
    EditText pass;

    Button phone;
    Button google;
    Button register;

    TextView btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        email = (EditText) findViewById(R.id.regis_email);
        pass = (EditText) findViewById(R.id.regis_password);
        register = (Button) findViewById(R.id.regis_btn);
        register.setOnClickListener(view ->{
            createUser();
        });

        btn_signin = (TextView) findViewById(R.id.signin_txt_btn);
        btn_signin.setOnClickListener(view ->{
            startActivity(new Intent(Register_page.this, Login_page.class));
        });

        phone = (Button) findViewById(R.id.regis_phone_btn);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register_page.this,new_phoneregis_sendOTP.class));
            }
        });
        
        google = (Button) findViewById(R.id.regis_google_btn);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });

    }

    private void SignIn() {
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
                Toast.makeText(Register_page.this,"Something went error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void HomeActivity() {
        finish();
        Intent intent = new Intent(getApplicationContext(), HOME.class);
        startActivity(intent);
    }

    private void createUser(){
        String emaill = email.getText().toString();
        String password = pass.getText().toString();

        if(TextUtils.isEmpty(emaill)){
            email.setError("Email cannot be empty");
            email.requestFocus();

        }else if (TextUtils.isEmpty(password)){
            pass.setError("Password cannot be empty");
            pass.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(emaill,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register_page.this,"User register succesfully, please chcek your email for verification",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Register_page.this, Login_page.class));
                                }else {
                                    Toast.makeText(Register_page.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }else{
                        Toast.makeText(Register_page.this,"Registration error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}