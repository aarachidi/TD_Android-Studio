package com.example.dice_roller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_de = (Button) findViewById(R.id.btn_de);
        TextView text_de = (TextView) findViewById(R.id.txt_de);
        TextView text_de2 = (TextView) findViewById(R.id.txt_de2);
        EditText number = (EditText) findViewById(R.id.nb_faces);

        btn_de.setOnClickListener(view -> {
            Toast toast = Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT);
            toast.show();
            Random rand = new Random();
            int n = rand.nextInt(Integer.parseInt(String.valueOf(number.getText()))) + 1;
            int n2 = rand.nextInt(Integer.parseInt(String.valueOf(number.getText()))) + 1;

            // next_int will return a number between 0 & 5
            text_de.setText(String.valueOf(n));
            text_de2.setText(String.valueOf(n2));

        });

    }
}