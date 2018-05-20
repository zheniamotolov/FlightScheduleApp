package com.example.android.scheduler_app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.android.scheduler_app.BasicApp;
import com.example.android.scheduler_app.db.entity.Airport;
import com.example.android.scheduler_app.db.entity.Resource;
import com.example.android.scheduler_app.db.repository.AirportRepository;

import java.util.List;

public class AirportsListViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<Airport>> mObservableAirports;
    private AirportRepository airportRepository;
    private final MutableLiveData<String> query = new MutableLiveData<>();
    private final LiveData<Resource<List<Airport>>> results = new MutableLiveData<>();

    //    @Inject
    public AirportsListViewModel(/*AirportRepository airportRepository,*/Application application) {
        super(application);
        airportRepository = ((BasicApp) application).getRepository();
        mObservableAirports = new MediatorLiveData<>();
        mObservableAirports.setValue(null);

        LiveData<List<Airport>> airports = airportRepository
                .getAirports();
        mObservableAirports.addSource(airports, mObservableAirports::setValue);

    }

    public LiveData<List<Airport>> getAirports() {
        return mObservableAirports;
    }

    public void insert(List<Airport> airports) {
        airportRepository.insert(airports);
    }
}
