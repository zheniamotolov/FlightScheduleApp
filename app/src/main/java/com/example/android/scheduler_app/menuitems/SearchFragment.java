package com.example.android.scheduler_app.menuitems;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.scheduler_app.R;
import com.example.android.scheduler_app.api.AirportSearchResponse;
import com.example.android.scheduler_app.api.ApiUtill;
import com.example.android.scheduler_app.api.FlightStatsService;
import com.example.android.scheduler_app.databinding.FragmentSearchBinding;
import com.example.android.scheduler_app.db.entity.Airport;
import com.example.android.scheduler_app.ui.AirportAdapter;
import com.example.android.scheduler_app.ui.AirportClickCallback;

import com.example.android.scheduler_app.ui.MainActivity;
import com.example.android.scheduler_app.viewmodel.AirportsListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

    private SearchView searchView;

    public static final String TAG = "myLogs";
    private AirportAdapter mAirportAdapter;
    private AirportsListViewModel viewModel;
    private FragmentSearchBinding mBinding;
    private List<Airport> cachedAirports;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        mAirportAdapter = new AirportAdapter(mAirportClickCallback);
        mBinding.airportsList.setAdapter(mAirportAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(AirportsListViewModel.class);
        fetchData();
        subscribeUi(viewModel);
    }

    private void subscribeUi(AirportsListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getAirports().observe(this, new Observer<List<Airport>>() {
            @Override
            public void onChanged(@Nullable List<Airport> Airports) {
                if (Airports != null) {
                    cachedAirports = Airports;
                    mBinding.setIsLoading(false);
                    mAirportAdapter.setAirportList(Airports);
                } else {
                    mBinding.setIsLoading(true);
                }
                mBinding.executePendingBindings();
            }
        });
    }


    private final AirportClickCallback mAirportClickCallback = new AirportClickCallback() {
        @Override
        public void onClick(Airport airport) {

            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((MainActivity) getActivity()).showAirportSchedule(airport);
            }
        }
    };

    private List<Airport> filter(List<Airport> productEntities, String query) {
        final List<Airport> filteredModeList = new ArrayList<>();
        for (Airport item : productEntities) {
            if (item.getName().toLowerCase().startsWith(query.toLowerCase())) {
                filteredModeList.add(item);
            }

        }
        return filteredModeList;
    }


    private  void fetchData(){
        FlightStatsService flightStatsService = ApiUtill.getFlightStatsService();
        flightStatsService.getAirports(/*AIRPORT_STATE, APP_ID, APP_KEY*/).enqueue(new Callback<AirportSearchResponse>() {
            @Override
            public void onResponse(Call<AirportSearchResponse> call, Response<AirportSearchResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("FlightStatsApi", "posts loaded from API");
                    cachedAirports = response.body().getAirports();
                    viewModel.insert(cachedAirports);
                } else {
                    int statusCode = response.code();
                    Log.d("FlightStatsApi", "error code " + statusCode);

                }
            }

            @Override
            public void onFailure(Call<AirportSearchResponse> call, Throwable t) {
                Log.d("FlightStatsApi", "error loading from API");

            }
        });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                menuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Airport> filterdList = filter(cachedAirports, newText);
                mAirportAdapter.setAirportList(filterdList);
                return true;
            }
        });
//        binding.searchView.setMenuItem(menu.findItem(R.id.action_search));
    }


}
