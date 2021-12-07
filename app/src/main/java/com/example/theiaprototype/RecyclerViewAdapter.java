package com.example.theiaprototype;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    String destinations[], destination_descriptions[];

    public RecyclerViewAdapter(Context context, String destinations[], String destination_descriptions[]) {
        this.context = context;
        this.destinations = destinations;
        this.destination_descriptions = destination_descriptions;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.destination.setText(destinations[position]);
        holder.description.setText(destination_descriptions[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DestinationViewActivity.class);
                intent.putExtra("destinations", destinations[position]);
                intent.putExtra("destination_descriptions", destination_descriptions[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return destinations.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView destination, description;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            destination = itemView.findViewById(R.id.destination);
            description = itemView.findViewById(R.id.description);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
