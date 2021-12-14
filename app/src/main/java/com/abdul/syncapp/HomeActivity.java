package com.abdul.syncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView  homeTextView = findViewById(R.id.tvHome);
        //mIntent from mainactivity started this activty

        String name = getIntent().getExtras().getString("waterkey");
        homeTextView.setText(name);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}