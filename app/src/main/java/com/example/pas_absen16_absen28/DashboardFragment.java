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

import com.example.pas_absen16_absen28.adapter.EventAdapter;
import com.example.pas_absen16_absen28.model.Event;
import com.example.pas_absen16_absen28.model.EventResponse;
import com.example.pas_absen16_absen28.network.ApiService;
import com.example.pas_absen16_absen28.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    RecyclerView recyclerView;
    EventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadMatchHistory();

        return view;
    }

    private void loadMatchHistory() {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        Call<EventResponse> call = apiService.getMatchHistory("4328", "2024-2025");
        call.enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Event> events = response.body().getEvents();
                    adapter = new EventAdapter(events);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Failed to get match history", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

