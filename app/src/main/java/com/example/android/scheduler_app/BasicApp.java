package com.example.android.scheduler_app;

import android.app.Application;

//import com.example.android.scheduler_app.db.AppDatabase;
import com.example.android.scheduler_app.db.FlightStatsDatabase;
import com.example.android.scheduler_app.db.repository.AirportRepository;

/**
 * Android Application class. Used for accessing singletons.
 */
public class BasicApp extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public FlightStatsDatabase getDatabase() {
        return FlightStatsDatabase.getDatabase(this,mAppExecutors);
    }

    public AirportRepository getRepository() {
        return AirportRepository.getInstance(getDatabase());
    }
}
