package com.publicicat.restapi;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterOne extends RecyclerView.Adapter<AdapterOne.MascotasViewHolder> {

    ArrayList<Constructor> mascotas;
    Activity activity;
    public AdapterOne(ArrayList<Constructor> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_timeline, parent, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        Constructor mascotaItem = mascotas.get(position);

        holder.cvivPic.setImageResource(mascotaItem.getPic());
        holder.cvtvName.setText(mascotaItem.getName());
        //holder.cvtvVotes.setText(Integer.toString(mascotasItem.getVotes()));
        holder.cvtvVotes.setText(String.valueOf(mascotaItem.getVotes()));

        holder.cvivBoneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste un voto a " + mascotaItem.getName(), Toast.LENGTH_SHORT).show();
                DbConstructor dbC = new DbConstructor(activity);
                dbC.darVoteMascota(mascotaItem);
                holder.cvtvVotes.setText(String.valueOf(dbC.obtenerVotesMascota(mascotaItem)));
            }
        });
        /*
        holder.cvivBoneg.setOnClickListener(new View.OnClickListener() {
            int n = mascotasItem.getVotes();
            int z = n + 5;
            @Override
            public void onClick(View v) {
                if (n <= z){
                    z=z;
                    n = n + 1;
                    holder.cvtvVotes.setText(Integer.toString(n));
                } else {
                    holder.cvtvVotes.setText("Lol");
                }

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    //Class inside class
    public static class MascotasViewHolder extends RecyclerView.ViewHolder {

        private final ImageView cvivPic;
        private final TextView cvtvName;
        private final TextView cvtvVotes;
        private final ImageView cvivBoneg;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            cvivPic = itemView.findViewById(R.id.cv_iv_pic);
            cvtvName = itemView.findViewById(R.id.cv_tv_name);
            cvtvVotes = itemView.findViewById(R.id.cv_tv_votes);
            cvivBoneg = itemView.findViewById(R.id.cv_iv_boundg);
        }
    }
}



