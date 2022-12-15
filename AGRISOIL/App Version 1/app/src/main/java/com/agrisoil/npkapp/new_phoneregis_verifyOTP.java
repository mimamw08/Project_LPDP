package com.agrisoil.npkapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agrisoil.npkapp.databinding.ActivityNewPhoneregisVerifyOtpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class new_phoneregis_verifyOTP extends AppCompatActivity {

    private ActivityNewPhoneregisVerifyOtpBinding binding;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewPhoneregisVerifyOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editTextInput();

        binding.viewNmbr.setText(String.format(
                "+62-%s", getIntent().getStringExtra("phone")
        ));

        verificationId = getIntent().getStringExtra("verificationId");

        binding.resendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(new_phoneregis_verifyOTP.this,"OTP Berhasil dikirim",Toast.LENGTH_SHORT).show();
            }
        });

        binding.verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressBarVerify.setVisibility(View.VISIBLE);
                binding.verifyBtn.setVisibility(View.INVISIBLE);
                if(binding.OTPCode1.getText().toString().trim().isEmpty() ||
                        binding.OTPCode2.getText().toString().trim().isEmpty() ||
                        binding.OTPCode3.getText().toString().trim().isEmpty() ||
                        binding.OTPCode4.getText().toString().trim().isEmpty() ||
                        binding.OTPCode5.getText().toString().trim().isEmpty() ||
                        binding.OTPCode6.getText().toString().trim().isEmpty()){
                    Toast.makeText(new_phoneregis_verifyOTP.this,"OTP Tidak Valid",Toast.LENGTH_SHORT).show();
                }else {
                    if (verificationId !=null){
                        String code = binding.OTPCode1.getText().toString().trim() +
                                binding.OTPCode2.getText().toString().trim() +
                                binding.OTPCode3.getText().toString().trim() +
                                binding.OTPCode4.getText().toString().trim() +
                                binding.OTPCode5.getText().toString().trim() +
                                binding.OTPCode6.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                        FirebaseAuth
                                .getInstance()
                                .signInWithCredential(credential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    binding.progressBarVerify.setVisibility(View.VISIBLE);
                                    binding.verifyBtn.setVisibility(View.INVISIBLE);
                                    Intent intent = new Intent(new_phoneregis_verifyOTP.this, HOME.class);
                                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }else {
                                    binding.progressBarVerify.setVisibility(View.GONE);
                                    binding.verifyBtn.setVisibility(View.INVISIBLE);
                                    Toast.makeText(new_phoneregis_verifyOTP.this,"OTP Tidak Valid",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private void editTextInput() {
        binding.OTPCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.OTPCode2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.OTPCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.OTPCode3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.OTPCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.OTPCode4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.OTPCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.OTPCode5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.OTPCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.OTPCode5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}