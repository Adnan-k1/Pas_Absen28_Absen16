package com.example.pas_absen16_absen28.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EventResponse {
    @SerializedName("events")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }
}
