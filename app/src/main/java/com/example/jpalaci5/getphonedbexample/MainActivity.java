package com.example.jpalaci5.getphonedbexample;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


public class MainActivity extends ActionBarActivity {

    EditText etName, etAge, etemail;
    Button bSubmit;
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        etName = (EditText)findViewById(R.id.editName);
        etAge = (EditText)findViewById(R.id.editAge);
        etemail = (EditText)findViewById(R.id.editemail);

        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ""+etName.getText().toString();
                String age = ""+etAge.getText().toString();
                String email = ""+etemail.getText().toString();

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

                nameValuePairs.add(new BasicNameValuePair("name", name));
                nameValuePairs.add(new BasicNameValuePair("age", age));
                nameValuePairs.add(new BasicNameValuePair("email", email));

                try{

                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost("http://31.170.160.93/workshop_connect.php");

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity= response.getEntity();


                    String msg = "Data enter successful";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
            catch (ClientProtocolException e) {
                Log.e("ClientProtocol", "Log_tag");
                e.printStackTrace();
            }catch (IOException e) {
                    Log.e("Log_tag", "IOException");
                    e.printStackTrace();
            }
            }
        });
        }
}