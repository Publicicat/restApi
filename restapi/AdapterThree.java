package com.publicicat.restapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterThree extends RecyclerView.Adapter<AdapterThree.MascotaViewHolder> {

    ArrayList<ConstructorInternet> mascotaInternet;
    Activity activityThree;

    public AdapterThree(ArrayList<ConstructorInternet> mascotaInternet, Activity activityThree) {
        this.mascotaInternet = mascotaInternet;
        this.activityThree = activityThree;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_internet, parent, false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final ConstructorInternet mascotaItem = mascotaInternet.get(position);

        Picasso.with(activityThree)
                .load(mascotaItem.getPicInternet())
                .placeholder(R.drawable.footprint)
                .into(holder.cvivPicP);
        //DbConstructor dbC = new DbConstructor(activityThree);
        holder.cvtvVotesP.setText(String.valueOf(mascotaItem.getLikesInternet()));

        holder.cvivPicP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activityThree, "You clicked " + mascotaItem.getFullNameInternet() + " pic", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotaInternet.size();
    }

    //Class inside class
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView cvivPicP;
        private final TextView cvtvVotesP;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            cvivPicP = itemView.findViewById(R.id.cv_iv_picP);
            cvtvVotesP = itemView.findViewById(R.id.cv_tv_votesP);
        }

    }
}
