package com.example.android.scheduler_app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.android.scheduler_app.R;
import com.example.android.scheduler_app.db.entity.Airport;
import com.example.android.scheduler_app.menuitems.AirportScheduleFragment;
import com.example.android.scheduler_app.menuitems.AirportsFragment;
import com.example.android.scheduler_app.menuitems.HomeFragment;
import com.example.android.scheduler_app.menuitems.SearchFragment;
import com.example.android.scheduler_app.menuitems.SettingsFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            HomeFragment fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, HomeFragment.TAG).commit();
        }
        BottomNavigationView navigation = findViewById(R.id.bottom_menu);
        navigation.setOnNavigationItemSelectedListener(this);


    }

    /**`
     * Shows the airport schedule  fragment
     */
    public void showAirportSchedule(Airport airport) {
        AirportScheduleFragment airportScheduleFragment = AirportScheduleFragment.forAirport(airport.getFs());
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("airport_schedule")
                .replace(R.id.fragment_container,
                        airportScheduleFragment, null)
                .commit();
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {//every time we tap on bottom menu
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_search:
                fragment = new SearchFragment();
                break;

            case R.id.navigation_airports:
                fragment = new AirportsFragment();
                break;

            case R.id.navigation_settings:
                fragment = new SettingsFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
