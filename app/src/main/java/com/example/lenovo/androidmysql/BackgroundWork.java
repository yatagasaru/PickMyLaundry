package com.example.lenovo.androidmysql;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Lenovo on 20/03/2018.
 */

    public class BackgroundWork extends AsyncTask<String,Void,String> {

    Context ctx;
    AlertDialog alertDialog;

    BackgroundWork(Context context) {
        ctx = context;
    }


    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        String regist_url = "http://10.0.2.2/AndroidMySQL/regist.php";
        String login_url = "http://10.0.2.2/AndroidMySQL/login.php";
        if (method.equals("register")) {
            String name = params[1];
            String user_name = params[2];
            String password = params[3];
            String nomortelp = params[4];
            String email_address = params[5];
            try {
                URL url = new URL(regist_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("nama", "UTF-8") + "="
                        + URLEncoder.encode(name, "UTF-8") + "&"
                        + URLEncoder.encode("username", "UTF-8") + "="
                        + URLEncoder.encode(user_name, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "="
                        + URLEncoder.encode(password, "UTF-8")+"&"
                        + URLEncoder.encode("nomortelp","UTF-8")+"="
                        + URLEncoder.encode(nomortelp,"UTF-8")+"&"
                        + URLEncoder.encode("email_address","UTF-8")+"="
                        + URLEncoder.encode(email_address,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                return "Berhasil Register";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } if (method.equals("login")) {
            String name = params[1];
            String pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")
                        + "&" + URLEncoder.encode("pass_word", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String baris = "";
                while ((baris = bufferedReader.readLine()) != null) {
                    result += baris;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");

    }

    @Override
    protected void onPostExecute(String s) {

        if(s.equals("Berhasil Register")) {
            Toast.makeText(ctx,s, Toast.LENGTH_LONG).show();
        } else {
            alertDialog.setMessage(s);
            alertDialog.show();

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
