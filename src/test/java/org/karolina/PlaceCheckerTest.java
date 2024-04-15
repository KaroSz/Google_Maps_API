package org.karolina;

import static org.junit.jupiter.api.Assertions.*;

class PlaceCheckerTest {

    @org.junit.jupiter.api.Test
    public void checkIfOpen() {

        String jsonResponse = "{   \"html_attributions\" : [],   \"result\" :    {      \"name\" : \"The National Museum in Warsaw\",      \"opening_hours\" :       {         \"periods\" :          [            {               \"close\" :                {                  \"day\" : 0,                  \"time\" : \"1800\"               },               \"open\" :                {                  \"day\" : 0,                  \"time\" : \"1000\"               }            },            {               \"close\" :                {                  \"day\" : 2,                  \"time\" : \"1800\"               },               \"open\" :                {                  \"day\" : 2,                  \"time\" : \"1000\"               }            },            {               \"close\" :                {                  \"day\" : 3,                  \"time\" : \"1800\"               },               \"open\" :                {                  \"day\" : 3,                  \"time\" : \"1000\"               }            },            {               \"close\" :                {                  \"day\" : 4,                  \"time\" : \"1800\"               },               \"open\" :                {                  \"day\" : 4,                  \"time\" : \"1000\"               }            },            {               \"close\" :                {                  \"day\" : 5,                  \"time\" : \"2000\"               },               \"open\" :                {                  \"day\" : 5,                  \"time\" : \"1000\"               }            },            {               \"close\" :                {                  \"day\" : 6,                  \"time\" : \"1800\"               },               \"open\" :                {                  \"day\" : 6,                  \"time\" : \"1000\"               }            }         ]      }   },   \"status\" : \"OK\"}";

        // User input for Tuesday at 12:00 PM
        String userDay = "Tuesday";
        String userTime = "1200";

        PlaceChecker placeChecker = new PlaceChecker();

        boolean isOpen = placeChecker.checkIfOpen(jsonResponse, userDay, userTime);
        assertTrue(isOpen);
    }
}