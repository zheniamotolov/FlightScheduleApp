package com.demo.coursework3.utilities;

import android.content.Context;
import android.util.Log;

import com.demo.coursework3.model.AirportPreviewInfoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;

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


    public static String[] getPreviewWeatherStringFromJson(Context context, String airportDataJsonStr) throws JSONException {
        String[] parsedAirportData = null;
        JSONArray airportsArray = new JSONArray(airportDataJsonStr);

//        if (airportsJson.has(STATUS_MESSAGE_CODE)) {
//            checkStatus(airportsJson);
//        }

//        JSONArray airportsArray = airportsJson.getJSONArray(FORMAT_LIST);
        parsedAirportData = new String[airportsArray.length()];

        for (int i = 0; i < airportsArray.length(); i++) {
            JSONObject airport = airportsArray.getJSONObject(i);
            parsedAirportData[i] = airport.getString(AIRPORT_NAME) +//todo replace to normal parcing
                    "-" + airport.getString(AIRPORT_FS) +
                    "-" + airport.getString(AIRPORT_CITY) +
                    "-" + airport.getString(AIRPORT_COUNTRY) +
                    "-" + airport.getString(AIRPORT_WHEATHER_URL);
//            Gson gson = new Gson();
//            Type type = new TypeToken<List<AirportPreviewInfoModel>>() {
//            }.getType();
//            List<AirportPreviewInfoModel> airportList = gson.fromJson(airportDataJsonStr, type);
//            for (AirportPreviewInfoModel airportObject : airportList) {
//                Log.i("Contact Details", airport.getName() +
//                        "-" + airportObject.getFs() +
//                        "-" + airportObject.getCity() +
//                        "-" + airportObject.getCountry() +
//                        "-" + airportObject.getWheatherURL());
//
//            }
        }

        return parsedAirportData;

    }

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
