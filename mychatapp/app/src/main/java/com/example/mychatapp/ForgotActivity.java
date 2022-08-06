package com.example.mychatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ForgotActivity extends AppCompatActivity {

    private TextInputEditText editTextForgot;
    private Button buttonForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        editTextForgot=findViewById(R.id.editTextForgot);
        buttonForgot=findViewById(R.id.buttonForgot);
    }
}