package com.demo.coursework.parser;

import android.content.Context;
import android.util.Log;

import com.demo.coursework.model.AirportListItemModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by eugene on 2/4/18.
 */

public class JSONParser {
    public static AirportListItemModel[] getPreviewWeatherStringFromJson(Context context, String airportDataJsonStr) throws JSONException {
        JSONObject airportDataJson = new JSONObject(airportDataJsonStr);
        JSONArray airportsArray = airportDataJson.getJSONArray("airports");
        String[] parsedAirportData = new String[airportsArray.length()];
//
////        if (airportsJson.has(STATUS_MESSAGE_CODE)) {
////            checkStatus(airportsJson);
////        }

//        for (int i = 0; i < airportsArray.length(); i++) {
//            JSONObject airport = airportsArray.getJSONObject(i);
//            parsedAirportData[i] = airport.getString(AIRPORT_NAME) +//todo replace to normal parcing
//                    "\n" + airport.getString(AIRPORT_FS) +
//                    "\n" + airport.getString(AIRPORT_CITY) +
//                    "\n" + airport.getString(AIRPORT_COUNTRY);
//        }


        Gson gson = new Gson();
        AirportListItemModel[] airportListItemModelArray = gson.fromJson(
                String.valueOf(airportsArray),
                AirportListItemModel[].class
        );
        return airportListItemModelArray;
    }
}
