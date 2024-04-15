package org.karolina;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class PlaceChecker {

    HashMap<String, Integer> dayMappings = new HashMap<>() {
        {
            put("Sunday", 0);
            put("Monday", 1);
            put("Tuesday", 2);
            put("Wednesday", 3);
            put("Thursday", 4);
            put("Friday", 5);
            put("Saturday", 6);
        }

    };

    public boolean checkIfOpen(String jsonResponse, String userDay, String userTime) {
        JsonObject jsonObject = new JsonParser().parse(jsonResponse).getAsJsonObject();

        if (jsonObject.has("result")) {
            JsonObject result = jsonObject.getAsJsonObject("result");
            if (result.has("opening_hours")) {
                JsonObject openingHours = result.getAsJsonObject("opening_hours");
                JsonArray periods = openingHours.getAsJsonArray("periods");

                int userDayNumber = dayMappings.get(userDay);

                for (int i = 0; i < periods.size(); i++) {
                    JsonObject period = periods.get(i).getAsJsonObject();
                    JsonObject open = period.getAsJsonObject("open");
                    JsonObject close = period.getAsJsonObject("close");

                    int apiDay = open.get("day").getAsInt();
                    String openTime = open.get("time").getAsString();
                    String closeTime = close.get("time").getAsString();

                    if (userDayNumber == apiDay && isPlaceOpenAtGivenTime(openTime, closeTime, userTime)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPlaceOpenAtGivenTime(String openingTime, String closingTime, String userTime) {
        int opening = Integer.parseInt(openingTime);
        int closing = Integer.parseInt(closingTime);
        int user = Integer.parseInt(userTime);

        // Midnight edge case
        if (opening == 0 && closing == 0 && user == 0) {
            return true; // Place is open at midnight
        }
        // Check if the user time falls within the opening and closing times
        return user >= opening && user <= closing;
    }

}

