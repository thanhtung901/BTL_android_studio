package com.example.pttkht;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oderr extends AppCompatActivity {
    Button btoder, bthome;
    EditText txtsoban;
    CheckBox cbchanhtuyet,cbvanicano, cbsuachua,cbtraxanh, cbkhoga, cbhuongduong, cbthachden, cbmachiato;
    TextView giachanhtuyet, giavinacano, giasuachua,giatraxanh, giakhoga,giahuongduong, giamachiato,giathachden;
    public static int sobans;
    public static String oderss;
//    public int gia_chanhtuyet, gia_vinacano, gia_suachua,gia_traxanh, gia_khoga,gia_huongduong, gia_machiato,gia_thachden;
    @SuppressLint("MissingInflatedId")
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

        giachanhtuyet = findViewById(R.id.giachanhtuyet);
        giavinacano = findViewById(R.id.giavinacano);
        giatraxanh = findViewById(R.id.giatraxanh);
        giasuachua = findViewById(R.id.giasuachua);
        giakhoga = findViewById(R.id.giakhoga);
        giahuongduong = findViewById(R.id.giahuongduong);
        giamachiato = findViewById(R.id.giamachiato);
        giathachden = findViewById(R.id.giathachden);
        delay();

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
    public void get_chanhtuyet(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/chanhtuyet");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giachanhtuyet.setText("Error getting data");
                }
                else {
                    giachanhtuyet.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_huongduong(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/huongduong");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giahuongduong.setText("Error getting data");
                }
                else {
                    giahuongduong.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_khoga(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/khoga");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giakhoga.setText("Error getting data");
                }
                else {
                    giakhoga.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_machiato(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/machiato");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giamachiato.setText("Error getting data");
                }
                else {
                    giamachiato.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_suachua(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/suachua");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giasuachua.setText("Error getting data");
                }
                else {
                    giasuachua.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_thachden(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/thachden");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giathachden.setText("Error getting data");
                }
                else {
                    giathachden.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_traxanh(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/traxanhsua");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giatraxanh.setText("Error getting data");
                }
                else {
                    giatraxanh.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void get_vinacano(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/vinacano");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    giavinacano.setText("Error getting data");
                }
                else {
                    giavinacano.setText("Giá: "+String.valueOf(task.getResult().getValue()) + "đ");
                }
            }
        });
    }
    public void delay()
    {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                get_chanhtuyet();
                                get_vinacano();
                                get_huongduong();get_khoga();get_machiato();get_thachden();get_suachua();get_traxanh();

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();
    }

}