package com.jayant.roomdatabaseretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jayant.roomdatabaseretrofit.Adapter.ActorAdapter;
import com.jayant.roomdatabaseretrofit.Modal.TripsHistoryResp;
import com.jayant.roomdatabaseretrofit.Network.Api;
import com.jayant.roomdatabaseretrofit.Network.NetworkUtil;
import com.jayant.roomdatabaseretrofit.Network.RetrofitInstance;
import com.jayant.roomdatabaseretrofit.Repository.ActorRespository;
import com.jayant.roomdatabaseretrofit.ViewModal.ActorViewModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActorViewModal actorViewModal;

    private RecyclerView recyclerView;
    private List<TripsHistoryResp> actorList;
    private ActorRespository actorRespository;
    private ActorAdapter actorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        actorRespository=new ActorRespository(getApplication());

        actorList=new ArrayList<>();
        actorAdapter=new ActorAdapter(this,actorList);

        actorViewModal=new ViewModelProvider(this).get(ActorViewModal.class);
        networkRequest(this);


    }

    private void networkRequest(final LifecycleOwner lifecycleOwner)
    {
        Api apiService = RetrofitInstance.getRetroClient().create(Api.class);
        Call<List<TripsHistoryResp>> call=apiService.getAllActors(274);
        call.enqueue(new Callback<List<TripsHistoryResp>>() {
            @Override
            public void onResponse(Call<List<TripsHistoryResp>> call, Response<List<TripsHistoryResp>> response) {
                if(response.isSuccessful())
                {
                    actorRespository.insert(response.body());
                    Log.d("main", "onResponse: " + response.body());

                    actorList = response.body();
                    recyclerView.setAdapter(actorAdapter);
                    actorAdapter.getAllActors(actorList);
                    Log.d("main", "onApiCall: "+actorList);
                }
            }

            @Override
            public void onFailure(Call<List<TripsHistoryResp>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong...", Toast.LENGTH_SHORT).show();

                actorViewModal.getAllActor().observe(lifecycleOwner, new Observer<List<TripsHistoryResp>>() {
                    @Override
                    public void onChanged(List<TripsHistoryResp> actorList) {
                        recyclerView.setAdapter(actorAdapter);
                        actorAdapter.getAllActors(actorList);

                        Log.d("main", "onChanged: "+actorList);
                    }
                });
            }
        });

    }
}
