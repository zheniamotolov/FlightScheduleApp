package com.example.android.scheduler_app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.android.scheduler_app.BasicApp;
import com.example.android.scheduler_app.db.entity.Airport;
import com.example.android.scheduler_app.db.entity.AirportSchedule;
import com.example.android.scheduler_app.db.repository.AirportRepository;

import java.util.List;

public class AirportScheduleViewModel extends AndroidViewModel {


    private final LiveData<Airport> mObservableAirport;

    public ObservableField<Airport> airport = new ObservableField<>();

    private final String mAirportFs;

    public AirportScheduleViewModel(@NonNull Application application,
                                    AirportRepository airportRepository,
                                    final String airportFs) {
        super(application);
        mAirportFs = airportFs;

        mObservableAirport = airportRepository.loadAirport(mAirportFs);
    }

    public String getmAirportFs() {
        return mAirportFs;
    }

    public LiveData<Airport> getmObservableAirport() {
        return mObservableAirport;
    }

    public void setAirport(Airport airport) {
        this.airport.set(airport);
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final String mAirportFs;

        private final AirportRepository mRepository;

        public Factory(@NonNull Application application, String airportFs) {
            mApplication = application;
            mAirportFs = airportFs;
            mRepository = ((BasicApp) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new AirportScheduleViewModel(mApplication, mRepository, mAirportFs);
        }
    }
}
