
package com.demo.coursework3.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    final static String APP_ID = "e9d75068&appKey";
    final static String APP_KEY = "e2ee1c87e66c2107768a30d2dfc9c3eb";
    final static String PARAM_APP_ID="appId";
    final static String PARAM_APP_KEY = "appKey";
    //https://api.flightstats.com/flex/airports/rest/v1/json/all?appId=e9d75068&appKey=e2ee1c87e66c2107768a30d2dfc9c3eb
    final static String ALL_AIRPORTS_SEARCH_URL =
            "https://api.flightstats.com/flex/airports/rest/v1/json/all";

//    final static String PARAM_QUERY = "q";

//    /*
//     * The sort field. One of stars, forks, or updated.
//     * Default: results are sorted by best match if no field is specified.
//     */
//    final static String PARAM_SORT = "sort";
//    final static String sortBy = "stars";

    public static URL buildUrl(String githubSearchQuery) {
        Uri builtUri = Uri.parse(ALL_AIRPORTS_SEARCH_URL).buildUpon()
                .appendQueryParameter(PARAM_APP_ID,APP_ID)
                .appendQueryParameter(PARAM_APP_KEY,APP_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
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
