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
    private String name;

    public AirportListItemModel() {

    }

    public AirportListItemModel(String countryName, String fs, String city, String weatherUrl, String longitude, String latitude) {
        this.name = name;
        this.fs = fs;
        this.city = city;
        this.countryName = countryName;
        this.weatherUrl = weatherUrl;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "AirportListItemModel{" +
                "countryName='" + countryName + '\'' +
                ", fs='" + fs + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", weatherUrl='" + weatherUrl + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
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
