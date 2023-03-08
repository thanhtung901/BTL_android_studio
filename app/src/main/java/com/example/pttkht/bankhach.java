package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class bankhach extends AppCompatActivity {
    public Button btban1,btban2, btban3,btban4,btban5,btban6;
    int soban = oderr.sobans;
    String oders = oderr.oderss;
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
        if(soban==1)
            btban1.setBackgroundColor(Color.RED);
        if(soban==2)
            btban2.setBackgroundColor(Color.RED);
        if(soban==3)
            btban3.setBackgroundColor(Color.RED);
        if(soban==4)
            btban4.setBackgroundColor(Color.RED);
        if(soban==5)
            btban5.setBackgroundColor(Color.RED);
        if(soban==6)
            btban6.setBackgroundColor(Color.RED);
        if(soban==2){
        btban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaglog(oders);
            }
        });
        }


        if(soban==2){
            btban1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oders);
                }
            });


        }
        if(soban==3){
            btban1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oders);
                }
            });


        }
        if(soban==4){
            btban1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oders);
                }
            });


        }
        if(soban==5){
            btban1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oders);
                }
            });


        }
        if(soban==6){
            btban1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    diaglog(oders);
                }
            });


        }
    }
    public void diaglog(String a){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(a);
        //Tạo nút Không
        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            //Khi nhấn sẽ tạo thông báo
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.cancel();
            }
        });
        //Tạo nút Có
        alertDialogBuilder.setNegativeButton("Thanh toán",new DialogInterface.OnClickListener() {
            //Khi nhấn sẽ đóng hộp thoại
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent kho = new Intent(bankhach.this, Ql_taichinh.class );
                startActivity(kho);
            }
        });

        alertDialogBuilder.create().show();
        //alertDialog.show();

    }
}