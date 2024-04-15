package org.karolina;

import org.codehaus.jackson.map.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

//public class GooglePlacesAPI {
 //   private static final String API_KEY = "YOUR_API_KEY"; // Replace with your own API key

//    public static void main(String[] args) {
//        String placeToCheck = getUserInput("Enter the address of the place you want to check: ");
//        String day = getUserInput("Enter the day of the week (e.g., Monday, Tuesday, etc.): ");
//        String time = getUserInput("Enter the time in HHmm format (e.g., 0900): ");
//
//        String encodedPlace = URLEncoder.encode(placeToCheck);
//
//        try {
//            URL url = new URL("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?" +
//                    "input=" + encodedPlace + "&inputtype=textquery&fields=place_id,name,opening_hours&key=" + API_KEY);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            int responseCode = conn.getResponseCode();
//
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                StringBuilder response = new StringBuilder();
//                String line;
//
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//                reader.close();
//
//                if (response.toString().contains("ZERO_RESULTS")) {
//                    System.out.println("Place not found or address is not correct.");
//                } else {
//                    System.out.println(response);
////                    boolean isOpen = checkIfOpen(response.toString(), day, time);
////
////                    if (isOpen) {
////                        System.out.println("The place is open at the specified time on " + day + ".");
////                    } else {
////                        System.out.println("The place is closed at the specified time on " + day + ".");
////                    }
//                }
//            } else {
//                System.out.println("Error - HTTP response code: " + responseCode);
//            }
//
//            conn.disconnect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private static String getUserInput(String prompt) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print(prompt);
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }

//}
