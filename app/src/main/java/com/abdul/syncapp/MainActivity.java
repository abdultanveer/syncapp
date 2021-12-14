package com.abdul.syncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation - layout inflater

        nameEditText = findViewById(R.id.etName); //initialization
    }

    public void showToastMessage(View view) {
        //Toast.makeText(this, R.string.message, Toast.LENGTH_SHORT).show();
       /* Intent mIntent = new Intent(this,HomeActivity.class);
        startActivity(mIntent);*/
        String name = nameEditText.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }


    int add(int fnum, int snum){
        return fnum + snum;
    }
}