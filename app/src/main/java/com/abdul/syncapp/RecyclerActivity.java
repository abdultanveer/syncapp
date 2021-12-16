package com.abdul.syncapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] countries = new String[]{"india","usa","uk","india","usa","uk"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView boardRecyclerView = findViewById(R.id.recyclerViewBoard);

        CountriesAdapter adapter = new CountriesAdapter(countries);
    }
}