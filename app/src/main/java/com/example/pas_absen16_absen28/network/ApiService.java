package com.example.pas_absen16_absen28.network;

import com.example.pas_absen16_absen28.model.TeamResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/v1/json/3/search_all_teams.php")
    Call<TeamResponse> getTeams(
            @Query("l") String leagueName
    );
};
