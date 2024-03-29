package com.example.mychatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MyLoginActivity extends AppCompatActivity {

    private TextInputEditText editTextEmail, editTextPassword;
    private Button buttonSignUp, buttonSignIn;
    private TextView textViewForgot;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewForgot = findViewById(R.id.textViewForgot);

        auth = FirebaseAuth.getInstance();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String email = editTextEmail.getText().toString();
             String password = editTextPassword.getText().toString();
             if (!email.equals("") && !password.equals(""))
             {
                 signIn(email, password);
             }
             else
             {
                 Toast.makeText(MyLoginActivity.this, "Please enter an email and password.", Toast.LENGTH_SHORT).show();
             }
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        textViewForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLoginActivity.this, ForgotActivity.class);
                startActivity(intent);
            }
        });

    }

    public void signIn(String email, String password)
    {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
              if (task.isSuccessful()){
               Intent intent = new Intent(MyLoginActivity.this, MainActivity.class);
               Toast.makeText(MyLoginActivity.this, "Sign in successful",Toast.LENGTH_SHORT).show();
            }
        }
        });
    }
}