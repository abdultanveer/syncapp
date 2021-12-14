package com.abdul.syncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //mIntent from mainactivity started this activty

        String name = getIntent().getExtras().getString("waterkey");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}