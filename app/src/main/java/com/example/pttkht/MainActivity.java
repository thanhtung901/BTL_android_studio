package com.example.pttkht;
// commenttttttttttt
//hoang thanh tùng
//55kmt
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btlogin;
    EditText edtuser, edtpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtuser = findViewById(R.id.edtuser);
        edtpassword = findViewById(R.id.edtpass);
        btlogin = findViewById(R.id.btlogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void login()
    {
        String user = edtuser.getText().toString();
        String password = edtpassword.getText().toString();
        if(user.equals("") && (password.equals("")))
        {
            Context context = getApplicationContext();
            CharSequence text = "Nhập thông tin tài khoản mật khẩu"; //commmen
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if(user.equals("admin") && (password.equals("admin")))
        {
            Context context = getApplicationContext();
            CharSequence text = "Đăng nhập thành công";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent home = new Intent(MainActivity.this, home.class);
            startActivity(home);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Sai tài khoản hoặc mật khẩu";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}