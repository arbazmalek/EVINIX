package com.arbaz.evinix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {


    EditText etEmail, etPassword;
    CardView btn_signin;
    FirebaseAuth auth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();

        auth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btn_signin = findViewById(R.id.btn_signin);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Logging in");



        etEmail.setBackground(null);
        etPassword.setBackground(null);


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        // email and password not enter error
                        if (etEmail.getText().toString().isEmpty()){
                            etEmail.setError("Please enter email");
                            return;
                        }
                        if (etPassword.getText().toString().isEmpty()){
                            etPassword.setError("Please enter password");
                            return;
                        }


                progressDialog.show();
                        auth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                            progressDialog.dismiss();
                                        if (task.isSuccessful()){


                                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                            startActivity(intent);

                                        }
                                        else {
                                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });


    }
}
