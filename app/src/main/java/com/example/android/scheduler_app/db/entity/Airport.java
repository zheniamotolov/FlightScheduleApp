package com.example.android.scheduler_app.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "airport")
public class Airport {

    @PrimaryKey
    @NonNull
    @SerializedName("fs")
    @Expose
    private String fs;
    @SerializedName("iata")
    @Expose
    private String iata;
    @SerializedName("icao")
    @Expose
    private String icao;
    @SerializedName("faa")
    @Expose
    private String faa;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("street1")
    @Expose
    private String street1;
    @SerializedName("street2")
    @Expose
    private String street2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("cityCode")
    @Expose
    private String cityCode;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("timeZoneRegionName")
    @Expose
    private String timeZoneRegionName;
    @SerializedName("weatherZone")
    @Expose
    private String weatherZone;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("utcOffsetHours")
    @Expose
    private double utcOffsetHours;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("elevationFeet")
    @Expose
    private int elevationFeet;
    @SerializedName("classification")
    @Expose
    private int classification;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("dateFrom")
    @Expose
    private String dateFrom;
    @SerializedName("dateTo")
    @Expose
    private String dateTo;
    @SerializedName("weatherUrl")
    @Expose
    private String weatherUrl;
    @SerializedName("delayIndexUrl")
    @Expose
    private String delayIndexUrl;

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getFaa() {
        return faa;
    }

    public void setFaa(String faa) {
        this.faa = faa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getTimeZoneRegionName() {
        return timeZoneRegionName;
    }

    public void setTimeZoneRegionName(String timeZoneRegionName) {
        this.timeZoneRegionName = timeZoneRegionName;
    }

    public String getWeatherZone() {
        return weatherZone;
    }

    public void setWeatherZone(String weatherZone) {
        this.weatherZone = weatherZone;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public double getUtcOffsetHours() {
        return utcOffsetHours;
    }

    public void setUtcOffsetHours(double utcOffsetHours) {
        this.utcOffsetHours = utcOffsetHours;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getElevationFeet() {
        return elevationFeet;
    }

    public void setElevationFeet(int elevationFeet) {
        this.elevationFeet = elevationFeet;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getDelayIndexUrl() {
        return delayIndexUrl;
    }

    public void setDelayIndexUrl(String delayIndexUrl) {
        this.delayIndexUrl = delayIndexUrl;
    }
}
