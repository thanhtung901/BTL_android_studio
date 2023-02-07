package com.example.pttkht;
//hellssakjfshjkfhsdkjfghsdkgfjksfgkjfk
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

public class nhapkho extends AppCompatActivity {
    Spinner spnncc,spndvt;
    Button xacnhan;
    EditText edtmahang,edttenhang,edtsoluong,edtdongia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhapkho);
        edtdongia = findViewById(R.id.edtdongia);
        edttenhang = findViewById(R.id.edttenhang);
        edtsoluong = findViewById(R.id.edtsoluong);
        edtmahang = findViewById(R.id.edtmahang);
        spnncc = findViewById(R.id.spinncc);
        spndvt = findViewById(R.id.spindvt);
        xacnhan = findViewById(R.id.btxacnhan);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hoàng-Trái cây");
        arrayList.add("Duy-Siro");
        arrayList.add("Hòa-Cốc");
        arrayList.add("Nam-Ăn Vặt");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnncc.setAdapter(arrayAdapter);
        spnncc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String tutorialsName = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        dvt();
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Thông tin đã được cập nhật";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                edtdongia.setText("");
                edtsoluong.setText("");edttenhang.setText("");edtmahang.setText("");



            }
        });






    }
    public void dvt()
    {
        ArrayList<String> arrdvt = new ArrayList<>();
        arrdvt.add("Gói");
        arrdvt.add("Thùng");
        arrdvt.add("Kg");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrdvt);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spndvt.setAdapter(arrayAdapter);
        spndvt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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