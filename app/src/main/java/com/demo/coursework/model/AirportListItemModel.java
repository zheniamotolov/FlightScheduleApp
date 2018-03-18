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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirportListItemModel that = (AirportListItemModel) o;

        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null)
            return false;
        if (fs != null ? !fs.equals(that.fs) : that.fs != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (weatherUrl != null ? !weatherUrl.equals(that.weatherUrl) : that.weatherUrl != null)
            return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null)
            return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = countryName != null ? countryName.hashCode() : 0;
        result = 31 * result + (fs != null ? fs.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (weatherUrl != null ? weatherUrl.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
