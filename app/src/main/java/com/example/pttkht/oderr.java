package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class oderr extends AppCompatActivity {
    Button btoder;
    EditText txtsoban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oderr);
        btoder = findViewById(R.id.btoder);
        txtsoban = findViewById(R.id.edtsoban);
        btoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = txtsoban.getText().toString();
                if(a.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Mời nhập số bàn";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Đã chọn đồ cho bàn " + a;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }
}