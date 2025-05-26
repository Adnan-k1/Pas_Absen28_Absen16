package com.example.pas_absen16_absen28.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strBadge")
    private String strBadge;

    @SerializedName("strStadium")
    private String strStadium;

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public String getStrStadium() {
        return strStadium;
    }
}
