package com.example.lenovo.androidmysql;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainUIActivity extends Activity {
    CardView cv_laundry;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        cv_laundry = (CardView)findViewById(R.id.cardview_laundry);
        cv_laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello world", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getMainUIView(View view) {
        this.view = view;
    }
}
