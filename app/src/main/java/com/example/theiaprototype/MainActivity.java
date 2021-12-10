package com.example.theiaprototype;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String destinations[], destination_descriptions[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        destinations = getResources().getStringArray(R.array.destinations);
        destination_descriptions = getResources().getStringArray(R.array.destination_descriptions);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, destinations, destination_descriptions);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}