package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class phone_regis_page1 extends AppCompatActivity {

    EditText input_nomor,input_otp;
    Button kirim_otp, verif_otp;

    FirebaseAuth mAuth;

    String verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_regis_page1);

        input_nomor = (EditText) findViewById(R.id.input_phoneNmbr);
        input_otp = (EditText) findViewById(R.id.otp_code);
        kirim_otp = (Button) findViewById(R.id.send_otp_btn);
        verif_otp = (Button) findViewById(R.id.verif_btn);
        mAuth = FirebaseAuth.getInstance();

        kirim_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(input_nomor.getText().toString())){
                    Toast.makeText(phone_regis_page1.this,"Enter valid Phone No.",Toast.LENGTH_SHORT).show();
                }else{
                    String number = input_nomor.getText().toString();
                    sendVerificationCode(number);
                }
            }
        });

        verif_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(input_otp.getText().toString())){
                    Toast.makeText(phone_regis_page1.this,"Wrong OTP",Toast.LENGTH_SHORT).show();
                }
                else{
                    verifycode(input_otp.getText().toString());
                }
            }
        });
    }


    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+62"+phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential)
        {
            final String code = credential.getSmsCode();
            if (code!= null){
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(phone_regis_page1.this, "Verification Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                @NonNull PhoneAuthProvider.ForceResendingToken token)
        {
            super.onCodeSent(s, token);
            verificationID = s;
        }
    };

    private void verifycode(String Code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,Code);
        signinCredentials(credential);
    }

    private void signinCredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(phone_regis_page1.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(phone_regis_page1.this, HOME.class));
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null){
            startActivity(new Intent(phone_regis_page1.this, HOME.class));
            finish();
        }
    }
}