package com.demo.coursework.model;

/**
 * Created by eugene on 2/11/18.
 */

public class AirportListItemModel {
    private String countryName;
    private String fs;
    private String city;
    private String country;
    private String weatherUrl;
    private String longitude;
    private String latitude;

    public AirportListItemModel() {

    }

    public AirportListItemModel(String countryName, String fs, String city, String country, String weatherUrl, String longitude, String latitude) {
        this.countryName = countryName;
        this.fs = fs;
        this.city = city;
        this.country = country;
        this.weatherUrl = weatherUrl;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getFs() {
        return fs;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }


    public String getWeatherUrl() {
        return weatherUrl;
    }


}
