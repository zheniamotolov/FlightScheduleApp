package com.demo.schedularapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.schedularapp.delete_it.Item;
import com.demo.schedularapp.delete_it.MainActivityAdapter;
import com.demo.schedularapp.menuitems.AirportsFragment;
import com.demo.schedularapp.menuitems.HomeFragment;
import com.demo.schedularapp.ui.search.SearchFragment;
import com.demo.schedularapp.menuitems.SettingsFragment;
import com.demo.schedularapp.ui.common.NavigationController;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    SearchView searchView;
    RecyclerView listshowrcy;
    List<Item> productlists = new ArrayList<>();
    MainActivityAdapter adapter;
    /////////////

    @Inject
    NavigationController navigationController;

    /////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productlists.add(new Item("Harley Davidson Street 750 2016 Std",
                R.drawable.ic_search_black_24dp));
        productlists.add(new Item("Triumph Street Scramble 2017 Std",
                R.drawable.ic_search_black_24dp));
        productlists.add(new Item("Suzuki GSX R1000 2017 STD",
                R.drawable.ic_search_black_24dp));
        productlists.add(new Item("Suzuki GSX R1000 2017 R",
                R.drawable.ic_settings_black_24dp));
        productlists.add(new Item("Suzuki Gixxer 2017 SP",
                R.drawable.ic_settings_black_24dp));
        productlists.add(new Item("Suzuki Gixxer 2017 SF 2017 Fuel injected ABS",
                R.drawable.ic_home_black_24dp));
        productlists.add(new Item("BMW R 1200 R 2017",
                R.drawable.ic_home_black_24dp));
        productlists.add(new Item("BMW R 1200 RS 2017",
                R.drawable.ic_home_black_24dp));
        listshowrcy = (RecyclerView) findViewById(R.id.listshow);
        listshowrcy.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listshowrcy.setLayoutManager(linearLayoutManager);

        adapter = new MainActivityAdapter(productlists, MainActivity.this);
        listshowrcy.setAdapter(adapter);

        loadFragment(new HomeFragment());
        BottomNavigationView navigation = findViewById(R.id.bottom_menu);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_button, menu);
        final MenuItem myActionMenuItem = menu.findItem(R.id.search_button);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(
                android.support.v7.appcompat.R.id.search_src_text)).
                setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Item> filtermodelist = filter(productlists, newText);
                adapter.setfilter(filtermodelist);
                return true;
            }
        });
        return true;
    }

    private List<Item> filter(List<Item> pl, String query) {
        query = query.toLowerCase();
        final List<Item> filteredModeList = new ArrayList<>();
        for (Item model : pl) {
            final String text = model.getName().toLowerCase();
            if (text.startsWith(query)) {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }

    //for changing the text color of searchview
    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }


    ////cccccccccccccccc
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
