package com.demo.coursework3.model;

/**
 * Created by eugene on 2/11/18.
 */

public class AirportPreviewInfoModel {
    private String name;
    private String fs;
    private String city;
    private String country;
    private String wheatherURL;
//change this
    public AirportPreviewInfoModel() {

    }

    public AirportPreviewInfoModel(String name, String fs, String city, String country, String wheatherURL) {
        this.name = name;
        this.fs = fs;
        this.city = city;
        this.country = country;
        this.wheatherURL = wheatherURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWheatherURL() {
        return wheatherURL;
    }

    public void setWheatherURL(String wheatherURL) {
        this.wheatherURL = wheatherURL;
    }
}
