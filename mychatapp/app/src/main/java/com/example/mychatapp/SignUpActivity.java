package com.example.mychatapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextInputEditText editTextEmailSignUp, editTextPasswordSignUp, editTextUserNameSignUp;
    private Button buttonRegister;
    boolean imageControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        circleImageView= findViewById(R.id.imageViewCircle);
        editTextEmailSignUp= findViewById(R.id.editTextEmailSignUp);
        editTextPasswordSignUp= findViewById(R.id.editTextPasswordSignUp);
        editTextUserNameSignUp= findViewById(R.id.editTextUserName);
        buttonRegister = findViewById(R.id.buttonRegister);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextEmailSignUp.getText().toString();
                String password = editTextPasswordSignUp.getText().toString();
                String userName = editTextUserNameSignUp.getText().toString();

                if (!email.equals("") && !password.equals("") && !userName.equals("")){
                    signUp(email, password, userName);
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Please enter all fields", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void imageChooser()
    {
        Intent intent = new Intent();
        intent.setType("images/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
            Uri imageUri = data.getData();
            Picasso.get().load(imageUri).into(circleImageView);
            imageControl = true;
        }
        else
        {
            imageControl = false;
        }

    }

    public void signUp(String email, String password, String userName)
    {

    }
}