package com.example.mywheatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WheatherRVAdaptor extends RecyclerView.Adapter<WheatherRVAdaptor.ViewHolder> {

private Context context;
private ArrayList<WheatherRVModal> wheatherRVModalArrayList;


    public WheatherRVAdaptor(Context context, ArrayList<WheatherRVModal> wheatherRVModalArrayList) {
        this.context = context;
        this.wheatherRVModalArrayList = wheatherRVModalArrayList;
    }

    @NonNull
    @Override
    public WheatherRVAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.wheather_rv_items,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WheatherRVAdaptor.ViewHolder holder, int position) {
        WheatherRVModal modal = wheatherRVModalArrayList.get(position);
        holder.temperatureTV.setText(modal.getTemperature()+"°C");
    Picasso.get().load("http://".concat(modal.getIcon())).into(holder.conditionTV);
    holder.windTV.setText(modal.getWingSpeed()+"km/h");
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");
        try {
            Date t = input.parse(modal.getTime());
            holder.timeTV.setText(output.format(t));
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return wheatherRVModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView windTV,temperatureTV,timeTV;
        private ImageView conditionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            windTV=itemView.findViewById(R.id.idTVWindSpeed);
            temperatureTV=itemView.findViewById(R.id.idTVTemperature);
            timeTV=itemView.findViewById(R.id.idTVTime);
            conditionTV=itemView.findViewById(R.id.idTVCondition);
        }
    }
}
