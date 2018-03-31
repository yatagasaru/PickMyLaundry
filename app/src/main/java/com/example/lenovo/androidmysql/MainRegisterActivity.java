package com.example.lenovo.androidmysql;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        Fragment frag = new Register1();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmain, frag);
        ft.commit();
    }
}
