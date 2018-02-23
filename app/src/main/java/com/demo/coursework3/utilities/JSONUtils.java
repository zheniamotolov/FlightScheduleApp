package com.demo.coursework3.utilities;

import android.content.Context;
import android.util.Log;

import com.demo.coursework3.model.AirportPreviewInfoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;


import static com.demo.coursework3.constants.AirportConstants.AIRPORT_CITY;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_COUNTRY;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_FS;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_NAME;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_WHEATHER_URL;
import static com.demo.coursework3.constants.AirportConstants.FORMAT_LIST;
import static com.demo.coursework3.constants.FlightTrackerConstants.STATUS_MESSAGE_CODE;

/**
 * Created by eugene on 2/10/18.
 */

public class JSONUtils {
    private static String[] checkStatus(JSONObject forecastJson) throws JSONException {
        int statusCode = forecastJson.getInt(STATUS_MESSAGE_CODE);
        switch (statusCode) {
            case HttpURLConnection.HTTP_OK:
                break;
            case HttpURLConnection.HTTP_NOT_FOUND:
                /* Location invalid */
                Log.e("JSONUtils", "Location invalid");
                return null;
            default:
                /* Server probably down */
                Log.e("JSONUtils", "Server probably down");
                return null;
        }
        return null;//todo change this method
    }

}
