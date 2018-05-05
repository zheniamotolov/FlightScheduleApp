package com.demo.schedularapp.db.entites;

/**
 * Created by eugene on 2/11/18.
 */


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "airport_list_item")
public class AirportListItemEntity {

    @PrimaryKey
    @NonNull
    private String fs;
    private String countryName;
    private String city;
    private String name;

    public AirportListItemEntity() {

    }

    public AirportListItemEntity(String countryName, String fs, String city, String name) {
        this.name = name;
        this.fs = fs;
        this.city = city;
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }


    public String getFs() {
        return fs;
    }


    public String getCity() {
        return city;
    }


}
