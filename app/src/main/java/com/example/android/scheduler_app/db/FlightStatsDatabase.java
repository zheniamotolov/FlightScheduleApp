package com.example.android.scheduler_app.db;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.scheduler_app.AppExecutors;
import com.example.android.scheduler_app.api.AirportSearchResponse;
import com.example.android.scheduler_app.api.ApiUtill;
import com.example.android.scheduler_app.api.FlightStatsService;
import com.example.android.scheduler_app.db.dao.AirportDao;
import com.example.android.scheduler_app.db.entity.Airport;


import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.android.scheduler_app.constants.Constants.AIRPORT_STATE;
import static com.example.android.scheduler_app.constants.Constants.APP_ID;
import static com.example.android.scheduler_app.constants.Constants.APP_KEY;
import static com.example.android.scheduler_app.constants.Constants.DATABASE_NAME;


@Database(entities = {Airport.class}, version = 1)
public abstract class FlightStatsDatabase extends RoomDatabase {
    public abstract AirportDao airportDao();

    private static FlightStatsService flightStatsService;
    private static FlightStatsDatabase INSTANCE;
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static FlightStatsDatabase getDatabase(final Context context, final AppExecutors executors) {
        if (INSTANCE == null) {
            synchronized (FlightStatsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FlightStatsDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
