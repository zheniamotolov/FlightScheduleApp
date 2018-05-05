package com.demo.coursework.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Airport {

    @PrimaryKey
    @ColumnInfo(name = "fs")
    private String fs;

    @ColumnInfo(name = "airportName")
    private String airportName;

    @ColumnInfo(name = "countryName")
    private String countryName;

    @ColumnInfo(name = "cityName")
    private String cityName;

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
