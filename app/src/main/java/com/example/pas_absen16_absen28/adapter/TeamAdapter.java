package com.example.pas_absen16_absen28.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_absen16_absen28.R;
import com.example.pas_absen16_absen28.model.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvName.setText(team.getStrTeam());
        holder.tvStadium.setText(team.getStrStadium());
        Glide.with(holder.itemView.getContext())
                .load(team.getStrBadge())
                .into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBadge;
        TextView tvName, tvStadium;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBadge = itemView.findViewById(R.id.ivTeamBadge);
            tvName = itemView.findViewById(R.id.tvTeamName);
            tvStadium = itemView.findViewById(R.id.tvStadium);
        }
    }
}
