package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    ImageButton imgbtoder,imgbtnhapkho,imgbtnhansu, imgbttaichinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imgbtnhansu = findViewById(R.id.imgbtnhansu);
        imgbtnhapkho = findViewById(R.id.imgbtnhapkho);
        imgbtoder = findViewById(R.id.imgbtoder);
        imgbttaichinh = findViewById(R.id.imgbttaichinh);
        imgbtoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oder = new Intent(home.this, oderr.class );
                startActivity(oder);
            }
        });
        imgbtnhapkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kho = new Intent(home.this, nhapkho.class );
                startActivity(kho);
            }
        });
        imgbtnhansu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qlns = new Intent(home.this, bankhach.class );
                startActivity(qlns);
            }
        });
//        imgbttaichinh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent qlns = new Intent(home.this, bankhach.class );
//                startActivity(qlns);
//            }
//        });

    }
}