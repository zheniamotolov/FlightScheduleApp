package com.demo.schedularapp.db.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import com.demo.schedularapp.db.FlightStatsDatabase;
import com.demo.schedularapp.db.dao.AirportListItemEntityDao;
import com.demo.schedularapp.db.entites.AirportListItemEntity;

import java.util.List;

public class AirportListItemRepository {

    private AirportListItemEntityDao mAirportListItemEntityDao;
    private LiveData<List<AirportListItemEntity>> mAllAirportsItems;

    AirportListItemRepository(Application application) {
        FlightStatsDatabase db = FlightStatsDatabase.getDatabase(application);
        mAirportListItemEntityDao = db.airportListItemEntityDao();
        mAllAirportsItems = mAirportListItemEntityDao.getAllAirportsItems();
    }

    LiveData<List<AirportListItemEntity>> getAllAirports() {
        return mAllAirportsItems;
    }


    public void insert(AirportListItemEntity airportItem) {
        new insertAsyncTask(mAirportListItemEntityDao).execute(airportItem);
    }

    private static class insertAsyncTask extends AsyncTask<AirportListItemEntity, Void, Void> {

        private AirportListItemEntityDao mAsyncTaskDao;

        insertAsyncTask(AirportListItemEntityDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final AirportListItemEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
