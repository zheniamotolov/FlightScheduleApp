package com.demo.coursework3.utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.demo.coursework3.constants.FlightTrackerConstants.*;

public class NetworkUtils {
    public static URL buildUrl() throws MalformedURLException {
        Uri builtUri = Uri.parse(ALL_AIRPORTS_SEARCH_URL)
                .buildUpon()
                .appendQueryParameter(PARAM_APP_ID, APP_ID)
                .appendQueryParameter(PARAM_APP_KEY, APP_KEY)
                .build();
        URL url = new URL(builtUri.toString());
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        if (url == null) {
            return "no url";
        }
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
