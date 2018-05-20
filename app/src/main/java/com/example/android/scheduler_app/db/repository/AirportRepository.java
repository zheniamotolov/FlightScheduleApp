package com.example.android.scheduler_app.db.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.os.AsyncTask;


import com.example.android.scheduler_app.db.FlightStatsDatabase;
import com.example.android.scheduler_app.db.dao.AirportDao;
import com.example.android.scheduler_app.db.entity.Airport;

import java.util.List;


public class AirportRepository {
    private static AirportRepository sInstance;
    private AirportDao airportDao;
    private final FlightStatsDatabase mDatabase;
    private LiveData<List<Airport>> mObservableAirportsts;

    public AirportRepository(final FlightStatsDatabase flightStatsDatabase) {
         airportDao = flightStatsDatabase.airportDao();
        mDatabase = flightStatsDatabase;
        mObservableAirportsts = airportDao.getAllAirportsItems();
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

    public void insert(List<Airport> airports) {
        new insertAsyncTask(airportDao).execute(airports);
    }

    private static class insertAsyncTask extends AsyncTask<List<Airport>, Void, Void> {

        private AirportDao mAsyncTaskDao;

        insertAsyncTask(AirportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Airport>... params) {
            mAsyncTaskDao.insertAirports(params[0]);
            return null;
        }
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