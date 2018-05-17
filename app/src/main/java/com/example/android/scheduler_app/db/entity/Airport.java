package com.example.android.scheduler_app.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity(tableName = "airport")
public class Airport {

    @PrimaryKey
    @NonNull
    @SerializedName("fs")
    @Expose
    private String fs;
    @SerializedName("faa")
    @Expose
    private String faa;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("timeZoneRegionName")
    @Expose
    private String timeZoneRegionName;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("utcOffsetHours")
    @Expose
    private Integer utcOffsetHours;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("elevationFeet")
    @Expose
    private Integer elevationFeet;
    @SerializedName("classification")
    @Expose
    private Integer classification;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("weatherUrl")
    @Expose
    private String weatherUrl;
    @SerializedName("delayIndexUrl")
    @Expose
    private String delayIndexUrl;

    /**
     * No args constructor for use in serialization
     */
    public Airport() {
    }

    /**
     * @param countryName
     * @param utcOffsetHours
     * @param countryCode
     * @param regionName
     * @param stateCode
     * @param delayIndexUrl
     * @param city
     * @param elevationFeet
     * @param weatherUrl
     * @param classification
     * @param name
     * @param fs
     * @param active
     * @param faa
     * @param timeZoneRegionName
     * @param longitude
     * @param localTime
     * @param latitude
     */
    public Airport(String fs, String faa, String name, String city, String stateCode, String countryCode, String countryName, String regionName, String timeZoneRegionName, String localTime, Integer utcOffsetHours, Double latitude, Double longitude, Integer elevationFeet, Integer classification, Boolean active, String weatherUrl, String delayIndexUrl) {
        super();
        this.fs = fs;
        this.faa = faa;
        this.name = name;
        this.city = city;
        this.stateCode = stateCode;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionName = regionName;
        this.timeZoneRegionName = timeZoneRegionName;
        this.localTime = localTime;
        this.utcOffsetHours = utcOffsetHours;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevationFeet = elevationFeet;
        this.classification = classification;
        this.active = active;
        this.weatherUrl = weatherUrl;
        this.delayIndexUrl = delayIndexUrl;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public Integer getUtcOffsetHours() {
        return utcOffsetHours;
    }

    public void setUtcOffsetHours(Integer utcOffsetHours) {
        this.utcOffsetHours = utcOffsetHours;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getElevationFeet() {
        return elevationFeet;
    }

    public void setElevationFeet(Integer elevationFeet) {
        this.elevationFeet = elevationFeet;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport that = (Airport) o;
        return Objects.equals(fs, that.fs) &&
                Objects.equals(faa, that.faa) &&
                Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(stateCode, that.stateCode) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(regionName, that.regionName) &&
                Objects.equals(timeZoneRegionName, that.timeZoneRegionName) &&
                Objects.equals(localTime, that.localTime) &&
                Objects.equals(utcOffsetHours, that.utcOffsetHours) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(elevationFeet, that.elevationFeet) &&
                Objects.equals(classification, that.classification) &&
                Objects.equals(active, that.active) &&
                Objects.equals(weatherUrl, that.weatherUrl) &&
                Objects.equals(delayIndexUrl, that.delayIndexUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fs, faa, name, city, stateCode, countryCode, countryName, regionName, timeZoneRegionName, localTime, utcOffsetHours, latitude, longitude, elevationFeet, classification, active, weatherUrl, delayIndexUrl);
    }
}



