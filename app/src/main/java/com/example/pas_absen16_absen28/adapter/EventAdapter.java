package com.example.pas_absen16_absen28.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen16_absen28.R;
import com.example.pas_absen16_absen28.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventList;

    public EventAdapter(List<Event> events) {
        this.eventList = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.tvEventName.setText(event.getStrEvent());
        String score = (event.getIntHomeScore() == null ? "-" : event.getIntHomeScore()) +
                " : " +
                (event.getIntAwayScore() == null ? "-" : event.getIntAwayScore());
        holder.tvScore.setText(score);
        holder.tvDateTime.setText(event.getDateEvent() + " " + event.getStrTime());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvEventName, tvScore, tvDateTime;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvScore = itemView.findViewById(R.id.tvScore);
            tvDateTime = itemView.findViewById(R.id.tvDateTime);
        }
    }
}

