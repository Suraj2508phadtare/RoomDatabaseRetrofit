package com.jayant.roomdatabaseretrofit.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jayant.roomdatabaseretrofit.Modal.TripsHistoryResp;

import java.util.List;

@Dao
public interface ActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TripsHistoryResp> actorList);

    @Query("SELECT * FROM trip_history")
    LiveData<List<TripsHistoryResp>> getAllActors();

    @Query("DELETE FROM trip_history")
    void deleteAll();
}
