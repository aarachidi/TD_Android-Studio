package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewsActivity extends AppCompatActivity {
    public static Context context;

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        context = this.getApplicationContext();

        TextView txt_username = (TextView) findViewById(R.id.txt_username);
        Intent intent = getIntent();
        txt_username.setText(intent.getStringExtra("username"));

        Button btnAbout = (Button) findViewById(R.id.btn_about);
        Button btnLogout = (Button) findViewById(R.id.btn_logout);
        Button btnDetail = (Button) findViewById(R.id.btn_detail);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                startActivity(intent);
            }
        });



    }
}