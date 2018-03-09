package com.demo.coursework.utilities;

import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;


import static com.demo.coursework.constants.FlightTrackerConstants.STATUS_MESSAGE_CODE;

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
