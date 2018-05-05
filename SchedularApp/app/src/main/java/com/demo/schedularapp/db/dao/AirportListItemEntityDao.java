package com.demo.schedularapp.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.demo.schedularapp.db.entites.AirportListItemEntity;

import java.util.List;

@Dao
public interface AirportListItemEntityDao {
    @Query("SELECT * FROM airport_list_item")
    LiveData<List<AirportListItemEntity>> getAllAirportsItems();

    @Query("SELECT * FROM airport_list_item WHERE fs =:airportFs")
    AirportListItemEntity loadAllByIds(String airportFs);

    @Query("SELECT * FROM airport_list_item WHERE name  =:airportName")
    AirportListItemEntity findByAirportListItemEntityName(String airportName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AirportListItemEntity... airports);

    @Delete
    void delete(AirportListItemEntity airport);
}
