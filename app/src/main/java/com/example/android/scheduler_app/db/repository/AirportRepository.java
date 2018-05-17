package com.example.android.scheduler_app.db.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;


import com.example.android.scheduler_app.db.FlightStatsDatabase;
import com.example.android.scheduler_app.db.entity.Airport;

import java.util.List;


public class AirportRepository {

    //    private LiveData<List<Airport>> mAllAirportsItems;
//    private final AirportDao airportDao;
//    private final FlightStatsDatabase db;
//    private final FlightStatsService flightStatsService;
////    private final AppExecutors appExecutors;
//

    private static AirportRepository sInstance;

    private final FlightStatsDatabase mDatabase;
    private MediatorLiveData<List<Airport>> mObservableAirportsts;

    AirportRepository(final FlightStatsDatabase flightStatsDatabase) {
        mDatabase = flightStatsDatabase;
        mObservableAirportsts = new MediatorLiveData<>();
        mObservableAirportsts.addSource(mDatabase.airportDao().getAllAirportsItems(),
                airports -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableAirportsts.postValue(airports);
                    }
                });

    }

    public static AirportRepository getInstance(final FlightStatsDatabase database) {
        if (sInstance == null) {
            synchronized (AirportRepository.class) {
                if (sInstance == null) {
                    sInstance = new AirportRepository(database);
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the list of airports from the database and get notified when the data changes.
     */
    public LiveData<List<Airport>> getAirports() {
        return mObservableAirportsts;
    }

    public LiveData<Airport> loadAirport(final String airportFs) {
        return mDatabase.airportDao().loadAllById(airportFs);
    }

}