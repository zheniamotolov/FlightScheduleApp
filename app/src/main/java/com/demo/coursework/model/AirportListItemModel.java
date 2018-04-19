package com.demo.coursework.model;

/**
 * Created by eugene on 2/11/18.
 */

public class AirportListItemModel {
    private String countryName;
    private String fs;
    private String city;
    private String name;

    public AirportListItemModel() {

    }

    public AirportListItemModel(String countryName, String fs, String city, String name) {
        this.name = name;
        this.fs = fs;
        this.city = city;
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "fs='" + fs + '\'' +
                ", countryName='" + countryName + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'';
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
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = countryName != null ? countryName.hashCode() : 0;
        result = 31 * result + (fs != null ? fs.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
