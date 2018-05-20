package com.example.android.scheduler_app.menuitems;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.scheduler_app.R;
import com.example.android.scheduler_app.api.ApiUtill;
import com.example.android.scheduler_app.api.FlightStatsService;
import com.example.android.scheduler_app.databinding.FragmentAirportScheduleBinding;
import com.example.android.scheduler_app.db.entity.Airport;
import com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus;
import com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatusList;
import com.example.android.scheduler_app.ui.FlightStatusAdapter;
import com.example.android.scheduler_app.ui.FlightStatusClickCallback;
import com.example.android.scheduler_app.viewmodel.AirportScheduleViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AirportScheduleFragment extends Fragment {
    private static final String AIRPORT_FS = "c";
    private FragmentAirportScheduleBinding mBinding;
    private static FlightStatsService flightStatsService;
    private FlightStatusAdapter mFlightStatusAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_airport_schedule,
                container,
                false);
        mFlightStatusAdapter = new FlightStatusAdapter(mFlightStatusClickCallback);
        mBinding.flightList.setAdapter(mFlightStatusAdapter);
        return mBinding.getRoot();

    }
        private final FlightStatusClickCallback mFlightStatusClickCallback = new FlightStatusClickCallback() {
        @Override
        public void onClick(FlightStatus flightStatus) {
            // soon
        }
    };
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AirportScheduleViewModel.Factory factory = new AirportScheduleViewModel.Factory(
                getActivity().getApplication(), getArguments().getString(AIRPORT_FS));

        final AirportScheduleViewModel model = ViewModelProviders.of(this, factory)
                .get(AirportScheduleViewModel.class);

        mBinding.setAirportScheduleViewModel(model);

        subscribeToModel(model);
    }

    private void subscribeToModel(final AirportScheduleViewModel model) {

        String fs=model.getmAirportFs();
        loadAirportInfo(model);
        if(fs!=null) {
            loadAirportFlights(model.getmAirportFs());
        }
    }

    private void loadAirportFlights(String airportFs) {
        flightStatsService = ApiUtill.getFlightStatsService();
        flightStatsService.getFlightStatuses(airportFs).enqueue(new Callback<FlightStatusList>() {
            @Override
            public void onResponse(Call<FlightStatusList> call, Response<FlightStatusList> response) {
                if (response.isSuccessful()) {
                    Log.d("FlightStatsApi", "flights status loaded from API");
                    mBinding.setIsLoading(false);
                    mFlightStatusAdapter.setFlightStatusList(response.body().getFlightStatuses());
                } else {
                    int statusCode = response.code();
                    Log.d("FlightStatsApi", "error boddy is " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<FlightStatusList> call, Throwable t) {
                Log.d("FlightStatsApi", "error loading from API");

            }

        });

    }

    private void loadAirportInfo(AirportScheduleViewModel model) {
        model.getmObservableAirport().observe(this, new Observer<Airport>() {
            @Override
            public void onChanged(@Nullable Airport airport) {
                model.setAirport(airport);
            }
        });
    }

    public static AirportScheduleFragment forAirport(String airportFs) {
        AirportScheduleFragment fragment = new AirportScheduleFragment();
        Bundle args = new Bundle();
        args.putString(AIRPORT_FS, airportFs);
        fragment.setArguments(args);
        return fragment;
    }

}
