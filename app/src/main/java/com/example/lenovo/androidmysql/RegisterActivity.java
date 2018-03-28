package com.example.lenovo.androidmysql;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
    EditText nama, username_register, password_register,nomor_telp_register,email;
    TextView judul;
    Button bt_register;
    String name, uname_regist, upass_regist,nomor_telp,str_email;
    Typeface tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        nama = (EditText)findViewById(R.id.et_name);
        judul = (TextView)findViewById(R.id.judulform);
        username_register = (EditText)findViewById(R.id.et_username_register);
        password_register = (EditText)findViewById(R.id.et_password_register);
        nomor_telp_register = (EditText)findViewById(R.id.et_phone);
        email = (EditText)findViewById(R.id.et_email);
        bt_register = (Button)findViewById(R.id.button_register);
        tv1 = Typeface.createFromAsset(getAssets(),"Roboto-Black.ttf");
        judul.setTypeface(tv1);
        regist();
    }

    public void regist() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nama.getText().toString();
                uname_regist = username_register.getText().toString();
                upass_regist = password_register.getText().toString();
                nomor_telp = nomor_telp_register.getText().toString();
                str_email = email.getText().toString();
                String method = "register";
                BackgroundWork bgwk = new BackgroundWork(getApplicationContext());
                bgwk.execute(method, name, uname_regist, upass_regist,nomor_telp,str_email);
                finish();
            }
        });
    }
}
