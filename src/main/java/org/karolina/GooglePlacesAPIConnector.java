package org.karolina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GooglePlacesAPIConnector {
    private static final String API_KEY = "YOUR_API_KEY";

    public String findPlaceFromText(String userInput) {
        String jsonResponse = "";

        try {
            String encodedInput = URLEncoder.encode(userInput, "UTF-8");
            URL url = new URL("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?" +
                    "input=" + encodedInput + "&inputtype=textquery&fields=name,place_id&key=" + API_KEY);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                jsonResponse = response.toString();
            } else {
                System.out.println("Error - HTTP response code: " + responseCode);
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    public String getPlaceDetails(String placeId) {
        String jsonResponse = "";

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/place/details/json?" +
                    "place_id=" + placeId + "&fields=name,opening_hours/periods&key=" + API_KEY);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                jsonResponse = response.toString();
            } else {
                System.out.println("Error - HTTP response code: " + responseCode);
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }
}

