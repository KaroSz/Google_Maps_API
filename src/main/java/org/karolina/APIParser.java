package org.karolina;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIParser {

    public String getPlaceIdFromResponse(String jsonResponse) {
        JsonObject jsonObject = new JsonParser().parse(jsonResponse).getAsJsonObject();
        String placeId = jsonObject.getAsJsonArray("candidates").get(0).getAsJsonObject().get("place_id").getAsString();
        return placeId;
    }

}



