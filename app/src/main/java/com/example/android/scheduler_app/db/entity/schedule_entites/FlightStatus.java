package com.example.android.scheduler_app.db.entity.schedule_entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightStatus {
    @SerializedName("flightId")
    @Expose
    private Integer flightId;
    @SerializedName("carrierFsCode")
    @Expose
    private String carrierFsCode;
    @SerializedName("flightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("departureAirportFsCode")
    @Expose
    private String departureAirportFsCode;
    @SerializedName("arrivalAirportFsCode")
    @Expose
    private String arrivalAirportFsCode;
    @SerializedName("departureDate")
    @Expose
    private DepartureDate departureDate;
    @SerializedName("arrivalDate")
    @Expose
    private ArrivalDate arrivalDate;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getCarrierFsCode() {
        return carrierFsCode;
    }

    public void setCarrierFsCode(String carrierFsCode) {
        this.carrierFsCode = carrierFsCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportFsCode() {
        return departureAirportFsCode;
    }

    public void setDepartureAirportFsCode(String departureAirportFsCode) {
        this.departureAirportFsCode = departureAirportFsCode;
    }

    public String getArrivalAirportFsCode() {
        return arrivalAirportFsCode;
    }

    public void setArrivalAirportFsCode(String arrivalAirportFsCode) {
        this.arrivalAirportFsCode = arrivalAirportFsCode;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }

    public ArrivalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(ArrivalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String getDateFormatted(){
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        return formatter.format(new Date(dateInMillis));
//    }
}
