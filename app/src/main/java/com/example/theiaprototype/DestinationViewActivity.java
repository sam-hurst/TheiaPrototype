package com.example.theiaprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DestinationViewActivity extends AppCompatActivity {

    TextView destination, description;

    String destinations, destination_descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_view);

        destination = findViewById(R.id.destinationText);
        description = findViewById(R.id.descriptionText);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("destinations") && getIntent().hasExtra("destination_descriptions")) {
            destinations = getIntent().getStringExtra("destinations");
            destination_descriptions = getIntent().getStringExtra("destination_descriptions");
        }
        else {
            Toast.makeText(this, "Error ! no data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        destination.setText(destinations);
        description.setText(destination_descriptions);
    }
}