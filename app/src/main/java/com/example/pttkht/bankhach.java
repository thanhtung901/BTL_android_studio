package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class bankhach extends AppCompatActivity {
    AlertDialog.Builder builder;
    public Button btban1,btban2, btban3,btban4,btban5,btban6,home;
    int ban1,ban2,ban3,ban4,ban5,ban6;
    String oder1, oder2, oder3, oder4, oder5, oder6;
    @SuppressLint("MissingInflatedId")
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
        home = findViewById(R.id.bthome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bankhach.this, home.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String oders = intent.getStringExtra("oder");
        int soban = intent.getIntExtra("soban",0);

        if(soban==1) {
            ban1 = soban;
            oder1 = oders;
            if (ban1 == 1)
                btban1.setBackgroundColor(Color.RED);

        }
        if(soban==2){
            ban2 = soban;
            oder2 = oders;
            if(ban2 ==2)
                btban2.setBackgroundColor(Color.RED);}
        if(soban==3) {
            ban3 = soban;
            oder3 = oders;
            if (ban3 == 3)
                btban3.setBackgroundColor(Color.RED);
        }
        if(soban==4)
        {
            ban4 = soban;
            oder4 = oders;
            if(ban4 ==4)
                btban4.setBackgroundColor(Color.RED);
        }
        if(soban==5){
            ban5 = soban;
            oder5 = oders;
            if(ban5 ==5)
                btban5.setBackgroundColor(Color.RED);
        }
        if(soban==6){
            ban6 = soban;
            oder6 = oders;
            if(ban6 ==6)
                btban6.setBackgroundColor(Color.RED);
        }
        if(ban1==1) {
            btban1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oder1);
                }
            });
        }
        if(ban2==2){
            btban2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oder2);
                }
            });


        }
        if(ban3==3){
            btban3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oder3);
                }
            });


        }
        if(ban4==4){
            btban4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oder4);
                }
            });


        }
        if(ban5==5){
            btban5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oder5);
                }
            });


        }
        if(ban6==6){
            btban6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oder6);
                }
            });


        }

    }
    public void diaglog(String a){
        builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage(a)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Toast.makeText(getApplicationContext(),"oke",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"oke",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("ODER");
        alert.show();
        }
}