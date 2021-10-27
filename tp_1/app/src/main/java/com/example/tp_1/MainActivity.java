package com.example.tp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int v = 54;
        int n = v/9 - 2;
        Log.i(TAG, "n = "+n);
        int f = factorielle(n);
        setContentView(R.layout.activity_main);
        Log.i(TAG, String.valueOf(n) + "! = " + f );
        Log.d(TAG, "Test");
    }

    private int factorielle(int n) {
        int s = 1;
        for(int i = n; i > 1; i--)
            s *= i;
        return s;
    }
}