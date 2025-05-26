package com.example.pas_absen16_absen28.model;

import com.google.gson.annotations.SerializedName;
public class Event {
    @SerializedName("strEvent")
    private String strEvent;

    @SerializedName("intHomeScore")
    private String intHomeScore;

    @SerializedName("intAwayScore")
    private String intAwayScore;

    @SerializedName("dateEvent")
    private String dateEvent;

    @SerializedName("strTime")
    private String strTime;


    public String getStrEvent() {
        return strEvent;
    }

    public String getIntHomeScore() {
        return intHomeScore;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public String getStrTime() {
        return strTime;
    }
}

