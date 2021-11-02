package com.publicicat.restapi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTwo extends RecyclerView.Adapter<AdapterTwo.MascotaViewHolder> {

    ArrayList<Constructor> mascota;
    Activity activityTwo;

    public AdapterTwo(ArrayList<Constructor> mascota, Activity activityTwo) {
        this.mascota = mascota;
        this.activityTwo = activityTwo;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_profile, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Constructor mascotaItem = mascota.get(position);

        holder.cvivPicP.setImageResource(mascotaItem.getPic());
        DbConstructor dbC = new DbConstructor(activityTwo);
        //Get votes or get the id from specific user
        //But... how to set here the id from a preselection from user???!!!
        holder.cvtvVotesP.setText(String.valueOf(dbC.obtenerVotesUnaMascota(mascotaItem)));

    }

    @Override
    public int getItemCount() {
        return mascota.size();
    }

    //Class inside class
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView cvivPicP;
        private final TextView cvtvVotesP;

        public MascotaViewHolder(@NonNull View itemView){
            super(itemView);
            cvivPicP = itemView.findViewById(R.id.cv_iv_picP);
            cvtvVotesP = itemView.findViewById(R.id.cv_tv_votesP);
        }

    }
}

