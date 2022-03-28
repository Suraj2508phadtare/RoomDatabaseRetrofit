package com.jayant.roomdatabaseretrofit.Network;

import com.jayant.roomdatabaseretrofit.Modal.TripsHistoryResp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("/trip/api/trips/user/{party_id}/")
    Call<List<TripsHistoryResp>> getAllActors(@Path("party_id") int party_id);
}
