package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;

public class Ql_taichinh extends AppCompatActivity {
    Button bthome;
    TextView datetime, txtoder,txtsoluong,txtsoban;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ql_taichinh);
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        String date =  day + "/" + month + "/" + year;
        datetime = findViewById(R.id.datetime);
        datetime.setText(date);
        bthome = findViewById(R.id.bthome);

        txtsoban = findViewById(R.id.txtsoban);
        txtoder = findViewById(R.id.txtoder);
        txtsoluong = findViewById(R.id.txtsoluong);

        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ql_taichinh.this, home.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String oder = bundle.getString("guioder");
        String soban = bundle.getString("guiban");
        String split = oder.substring(1, oder.length()-1);
        String[] sp = split.split("//s");

        txtsoban.setText(soban);
        txtoder.setText(sp[0]);
    }
}