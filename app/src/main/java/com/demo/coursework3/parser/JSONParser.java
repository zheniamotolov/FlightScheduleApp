package com.demo.coursework3.parser;

import android.content.Context;
import android.util.Log;

import com.demo.coursework3.model.AirportPreviewInfoModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.demo.coursework3.constants.AirportConstants.AIRPORT_CITY;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_COUNTRY;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_FS;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_NAME;
import static com.demo.coursework3.constants.AirportConstants.AIRPORT_WHEATHER_URL;

/**
 * Created by eugene on 2/4/18.
 */

public class JSONParser {
    public static String[] getPreviewWeatherStringFromJson(Context context, String airportDataJsonStr) throws JSONException {

        JSONObject airportDataJson = new JSONObject(airportDataJsonStr);

        JSONArray airportsArray = airportDataJson.getJSONArray("airports");
        String[] parsedAirportData = new String[airportsArray.length()];
//
////        if (airportsJson.has(STATUS_MESSAGE_CODE)) {
////            checkStatus(airportsJson);
////        }
        for (int i = 0; i < airportsArray.length(); i++) {
            JSONObject airport = airportsArray.getJSONObject(i);
            parsedAirportData[i] = airport.getString(AIRPORT_NAME) +//todo replace to normal parcing
                    "-" + airport.getString(AIRPORT_FS) +
                    "-" + airport.getString(AIRPORT_CITY) +
                    "-" + airport.getString(AIRPORT_COUNTRY) +
                    "-" + airport.getString(AIRPORT_WHEATHER_URL);
        }
        Gson gson = new Gson();
        AirportPreviewInfoModel[] airportPreviewInfoModelArray = gson.fromJson(
                airportDataJsonStr,
                AirportPreviewInfoModel[].class
        );
        for (AirportPreviewInfoModel item : airportPreviewInfoModelArray) {
            Log.i("Contact Details",
                    item.getName() +
                            "-" + item.getFs() +
                            "-" + item.getCity() +
                            "-" + item.getCountry() +
                            "-" + item.getWheatherURL());

        }
        return parsedAirportData;
    }
}
