package com.abdul.syncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToastMessage(View view) {
        //Toast.makeText(this, "welcome to android", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, R.string.message, Toast.LENGTH_SHORT).show();

        add(10,20);
    }

    int add(int fnum, int snum){
        return fnum + snum;
    }
}