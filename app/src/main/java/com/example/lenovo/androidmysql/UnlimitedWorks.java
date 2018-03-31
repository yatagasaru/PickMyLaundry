package com.example.lenovo.androidmysql;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ga on 3/31/18.
 */

public class UnlimitedWorks extends AsyncTask<String, Void, String> {
    Context ctx;
    UnlimitedWorks(Context context){ctx = context;}
    ProgressDialog progressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String nama = params[0];
        String pass = params[1];
        //progressDialog.setMessage("Logging in");
        while(!isCancelled()) {
            return getLoginStatus(nama, pass);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(s.equals("200")){
            //Toast.makeText(ctx, "Berhasil Login", Toast.LENGTH_SHORT).show();
            ctx.startActivity(new Intent(ctx, MainUIActivity.class));
            cancel(true);
        }
        else if(s.equals("404")){
            Toast.makeText(ctx, "Gagal Login", Toast.LENGTH_SHORT).show();
        }
    }


    //GG
    public String getLoginStatus(String nama, String pass){
        try{
            String get = "http://35.198.197.85/api/route?set=login&uname="+nama+"&passwd="+pass;
            URL url = new URL(get);

            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            String status = rootobj.get("status").getAsString();
            request.disconnect();
            return status;

        } catch (MalformedURLException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


