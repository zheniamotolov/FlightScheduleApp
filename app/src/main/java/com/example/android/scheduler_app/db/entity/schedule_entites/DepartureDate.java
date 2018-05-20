package com.example.android.scheduler_app.db.entity.schedule_entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartureDate {

    @SerializedName("dateLocal")
    @Expose
    private String dateLocal;
    @SerializedName("dateUtc")
    @Expose
    private String dateUtc;

    public String getDateLocal() {
        return dateLocal;
    }

    public void setDateLocal(String dateLocal) {
        this.dateLocal = dateLocal;
    }

    public String getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(String dateUtc) {
        this.dateUtc = dateUtc;
    }
}
