package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.databinding.ActivityNewPhoneregisSendOtpBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class new_phoneregis_sendOTP extends AppCompatActivity {

    private ActivityNewPhoneregisSendOtpBinding binding;
    private FirebaseAuth firebaseAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    Button send;
    ImageView back_btn;
    EditText input_nmbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewPhoneregisSendOtpBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(new_phoneregis_sendOTP.this, Login_page.class));
            }
        });

        binding.sendOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.phoneNmbr.getText().toString().trim().isEmpty()){
                    Toast.makeText(new_phoneregis_sendOTP.this,"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                }else if(binding.phoneNmbr.getText().toString().trim().length() != 11){
                    Toast.makeText(new_phoneregis_sendOTP.this,"type valid Phone Number",Toast.LENGTH_SHORT).show();
                }else{
                    otpSend();
                }
            }
        });
    }

    private void otpSend() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.sendOTPBtn.setVisibility(View.INVISIBLE);
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                binding.progressBar.setVisibility(View.GONE);
                binding.sendOTPBtn.setVisibility(View.VISIBLE);
                Toast.makeText(new_phoneregis_sendOTP.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.progressBar.setVisibility(View.GONE);
                binding.sendOTPBtn.setVisibility(View.VISIBLE);
                Intent intent = new Intent(new_phoneregis_sendOTP.this, new_phoneregis_verifyOTP.class);
                intent.putExtra("phone", binding.phoneNmbr.getText().toString().trim());
                intent.putExtra("verification id",verificationId);
                startActivity(intent);
            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber("+62" + binding.phoneNmbr.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}