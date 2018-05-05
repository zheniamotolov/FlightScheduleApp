package com.demo.coursework.db.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.demo.coursework.db.dao.AirportDao;
import com.demo.coursework.db.AirportDatabase;
import com.demo.coursework.db.model.Airport;

import java.util.List;

public class AirportRepository {

    private AirportDao mAirportDao;
    private LiveData<List<Airport>> mAllAirports;

    AirportRepository(Application application) {
        AirportDatabase db = AirportDatabase.getDatabase(application);
        mAirportDao = db.airportDao();
        mAllAirports = mAirportDao.getAllAirports();
    }

    LiveData<List<Airport>> getAllAirports() {
        return mAllAirports;
    }


    public void insert (Airport word) {
        new insertAsyncTask(mAirportDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Airport, Void, Void> {

        private AirportDao mAsyncTaskDao;

        insertAsyncTask(AirportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Airport... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
