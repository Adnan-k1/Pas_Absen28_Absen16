package com.example.pas_absen16_absen28;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen16_absen28.adapter.TeamAdapter;
import com.example.pas_absen16_absen28.model.Team;
import com.example.pas_absen16_absen28.model.TeamResponse;
import com.example.pas_absen16_absen28.network.ApiService;
import com.example.pas_absen16_absen28.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaligaFragment extends Fragment {

    RecyclerView recyclerView;
    TeamAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                         @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    recyclerView = view.findViewById(R.id.recyclerViewTeams);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    loadTeams();

    return view;
    }

    private void loadTeams() {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        Call<TeamResponse> call = apiService.getTeams("English Premier League");
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    adapter = new TeamAdapter(teams);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Failed to get teams", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}