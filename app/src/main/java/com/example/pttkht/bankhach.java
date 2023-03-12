package com.example.pttkht;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bankhach extends AppCompatActivity {
    AlertDialog.Builder builder;
    public Button btban1,btban2, btban3,btban4,btban5,btban6,home;
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
        delay();
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
                                get_ban(btban1, "/ban1/stt", "/ban1/oder");
                                get_ban(btban2, "/ban2/stt", "/ban2/oder");
                                get_ban(btban3, "/ban3/stt", "/ban3/oder");
                                get_ban(btban4, "/ban4/stt", "/ban4/oder");
                                get_ban(btban5, "/ban5/stt", "/ban5/oder");
                                get_ban(btban6, "/ban6/stt", "/ban6/oder");

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();
    }
    public void diaglog(String a){
        builder = new AlertDialog.Builder(this);
        builder.setMessage(a)
                .setCancelable(false)
                .setPositiveButton("Thanh toán", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(bankhach.this, Ql_taichinh.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"Closed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("ODER");
        alert.show();
    }
    public void get_ban(Button bt, String pathstt, String pathoder){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference stt = database.getReference(pathstt);
        stt.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    int stt = Integer.parseInt(String.valueOf(task.getResult().getValue()));
                    if(stt == 1)
                    {
                        DatabaseReference oder = database.getReference(pathoder);
                        oder.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (!task.isSuccessful()) {
                                    Log.e("firebase", "Error getting data", task.getException());
                                }
                                else {
                                    String oder = String.valueOf(task.getResult().getValue());
//                                    String stroder = oder.substring(1, oder.length()-1);
                                    bt.setBackgroundColor(Color.RED);
                                    bt.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            builder = new AlertDialog.Builder(bankhach.this);
                                            builder.setMessage(oder)
                                                    .setCancelable(false)
                                                    .setPositiveButton("Thanh toán", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                                                            DatabaseReference set_stt = database.getReference(pathstt);
                                                            set_stt.setValue(0);
                                                            DatabaseReference set_oder = database.getReference(pathoder);
                                                            set_oder.setValue("");
                                                            String soban = pathstt.substring(1,5);

                                                            Intent intent = new Intent(bankhach.this, Ql_taichinh.class);
                                                            intent.putExtra("guiban", soban);
                                                            intent.putExtra("guioder", oder);
                                                            startActivity(intent);

                                                        }
                                                    })
                                                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            //  Action for 'NO' Button
                                                            dialog.cancel();
                                                            Toast.makeText(getApplicationContext(),"Closed",
                                                                    Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                            //Creating dialog box
                                            AlertDialog alert = builder.create();
                                            //Setting the title manually
                                            alert.setTitle("ODER");
                                            alert.show();
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            }
        });
    }

}