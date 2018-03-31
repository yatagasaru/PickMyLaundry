package com.example.lenovo.androidmysql;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button bt_login,bt_signup;
    ProgressDialog progressDialog;
    View vieww;
    String nama, pass;
    MainUIActivity mainui = new MainUIActivity();
    BackgroundWork bgwk = new BackgroundWork(this);
    UnlimitedWorks uw = new UnlimitedWorks(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.et_username_login);
        password = (EditText)findViewById(R.id.et_password_login);
        bt_login = (Button)findViewById(R.id.button_login);
        bt_signup = (Button)findViewById(R.id.button_signup);
        progressDialog = new ProgressDialog(this);
        register();
        //prosesLogin();
    }

    public void prosesLogin(View view) {
                String method = "login";
                if(username.getText().length() != 0) {
                    nama = username.getText().toString();
                    pass = password.getText().toString();
                    //progressDialog.setMessage("Logging in");
                    //bgwk.execute(method, nama, pass);
                    uw.execute(nama, pass);

                    /*StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_LOGIN, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                            //Snackbar.make(mainui.view,response,Snackbar.LENGTH_SHORT).show();
                            if (!response.equals("error")){
                                startActivity(new Intent(MainActivity.this,MainUIActivity.class));
                            }
                        }
                    },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressDialog.hide();
                                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("user_name",nama);
                            params.put("pass_word",pass);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(stringRequest);*/

                } else {
                    Toast.makeText(getApplicationContext(), "Silahkan isi form terlebih dahulu",Toast.LENGTH_LONG).show();
              }
            }


    public void register() {
        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainUIActivity.class));
            }
        });
    }

}