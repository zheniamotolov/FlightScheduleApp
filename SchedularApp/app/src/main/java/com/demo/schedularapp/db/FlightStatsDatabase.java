package com.demo.schedularapp.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.demo.schedularapp.db.dao.AirportListItemEntityDao;
import com.demo.schedularapp.db.entites.AirportListItemEntity;


@Database(entities = {AirportListItemEntity.class}, version = 1)
public abstract class FlightStatsDatabase extends RoomDatabase {
    public abstract AirportListItemEntityDao airportListItemEntityDao();

    private static FlightStatsDatabase INSTANCE;

    public static FlightStatsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FlightStatsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FlightStatsDatabase.class, "flightStats_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
