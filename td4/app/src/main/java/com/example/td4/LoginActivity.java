package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static NewsListApplication context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = (NewsListApplication) this.getApplicationContext();


        setContentView(R.layout.activity_login2);
        EditText username = (EditText) findViewById(R.id.text_username);
        EditText password = (EditText) findViewById(R.id.text_password);
        Button login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString().equals("Test") && password.getText().toString().equals("1234")){
                    Intent intent = new Intent(context, NewsActivity.class);
                    intent.putExtra("username", username.getText().toString());
                    context.setLogin(username.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}