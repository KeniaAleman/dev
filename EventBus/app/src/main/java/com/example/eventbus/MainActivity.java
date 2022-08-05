package com.example.eventbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

//Publisher
public class MainActivity extends AppCompatActivity {

    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.textMessage);
        send = findViewById(R.id.btnSend);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment fragment = new fragment();
        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = message.getText().toString();
                //publish the message, starts the broadcasting. All subscribers can receive it if they are subscribed.
                EventBus.getDefault().post(new Messages(userMessage));
            }
        });
    }
}