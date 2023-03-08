package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class bankhach extends AppCompatActivity {
    public Button btban1,btban2, btban3,btban4,btban5,btban6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankhach);
        btban1 = findViewById(R.id.btban1);
        btban2 = findViewById(R.id.btban2);
        btban3 = findViewById(R.id.btban3);
        btban4 = findViewById(R.id.btban4);
        btban5 = findViewById(R.id.btban5);
        btban6 = findViewById(R.id.btban6);
    }
}