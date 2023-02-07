package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class home_QLNS extends AppCompatActivity {
    Spinner spngtgt;
    Button btthemnv, btxoanv;
    EditText manv, hoten,diachi,ngaysinh,cmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_qlns);
        spngtgt = findViewById(R.id.spgoitinh);
        btthemnv = findViewById(R.id.btthemnv);
        btxoanv = findViewById(R.id.btxoanv);
        manv = findViewById(R.id.edtmanv);
        hoten = findViewById(R.id.edttennv);
        diachi = findViewById(R.id.edtdiachi);
        ngaysinh = findViewById(R.id.edtngaysinh);
        cmt = findViewById(R.id.edtcmt);
        btthemnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = manv.getText().toString();
                if(a.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Nhập mã nhân viên";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Đã thêm nhân viên có mã là: "+ a;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    manv.setText("");hoten.setText("");diachi.setText("");ngaysinh.setText("");cmt.setText("");
                }
            }
        });
        btxoanv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = manv.getText().toString();
                if(a.matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Nhập mã nhân viên";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Đã xóa nhân viên có mã là: "+ a;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        gt();
    }

    public void gt()
    {
        ArrayList<String> arrdvt = new ArrayList<>();
        arrdvt.add("Nam");
        arrdvt.add("Nữ");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrdvt);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spngtgt.setAdapter(arrayAdapter);
        spngtgt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String tutorialsName = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

    }
}
