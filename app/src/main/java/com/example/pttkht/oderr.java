package com.example.pttkht;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oderr extends AppCompatActivity {
    Button btoder, bthome;
    EditText txtsoban;
    CheckBox cbchanhtuyet,cbvanicano, cbsuachua,cbtraxanh, cbkhoga, cbhuongduong, cbthachden, cbmachiato;

    public static int sobans;
    public static String oderss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oderr);
        btoder = findViewById(R.id.btoder);
        txtsoban = findViewById(R.id.edtsoban);
        bthome = findViewById(R.id.bthomess);


        cbchanhtuyet = findViewById(R.id.checkboxchanhtuyet);
        cbvanicano = findViewById(R.id.checkboxvinacano);
        cbhuongduong = findViewById(R.id.checkboxhuongduong);
        cbsuachua = findViewById(R.id.checkboxsuachuadamda);
        cbkhoga = findViewById(R.id.checkboxkhoga);
        cbtraxanh = findViewById(R.id.checkboxtraxanhsua);
        cbmachiato = findViewById(R.id.checkboxmachiato);
        cbthachden = findViewById(R.id.checkboxthachden);


        btoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sobans = xulySoban();
                oderss =xulycheckbox();
                Intent intent = new Intent(oderr.this, bankhach.class);
                intent.putExtra("soban", sobans);
                intent.putExtra("oder", oderss);
                startActivity(intent);
            }
        });
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kho = new Intent(oderr.this, home.class );
                startActivity(kho);
            }
        });

    }
    public int xulySoban(){
        int soban = Integer.parseInt(txtsoban.getText().toString());
        if(soban > 6 || soban < 1) {
            Context context = getApplicationContext();
            CharSequence text = "Mời nhập số bàn từ 1 đến 6";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Đã chọn đồ cho bàn số " + soban;
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        return soban;
    }
    public String xulycheckbox(){
         String[] do_uong = {};
        List<String> testList = new ArrayList<>(Arrays.asList(do_uong));
        if (cbchanhtuyet.isChecked())
            testList.add("chanh tuyết");
        if (cbmachiato.isChecked())
            testList.add("machiato");
        if (cbtraxanh.isChecked())
            testList.add("trà xanh sữa ");
        if (cbkhoga.isChecked())
            testList.add("khô gà");
        if (cbhuongduong.isChecked())
            testList.add("hướng dương");
        if (cbvanicano.isChecked())
            testList.add("vani cano ");
        if (cbthachden.isChecked())
            testList.add("thạch đen ");
        if(cbsuachua.isChecked())
            testList.add("sữa chua dầm đá ");
        do_uong = testList.toArray(new String[0]);
        String do_oder = Arrays.toString(do_uong);
        return do_oder;
    }
    public void diaglog(String a){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage(a)
                .setCancelable(false)
                .setPositiveButton("Thanhtoán", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(oderr.this, Ql_taichinh.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"closed",
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