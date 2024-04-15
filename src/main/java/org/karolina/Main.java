package org.karolina;

public class Main {

    public static void main(String[] args) {

        GooglePlacesAPIConnector connector = new GooglePlacesAPIConnector();
        UserInputHandler userInputHandler = new UserInputHandler();
        APIParser placeParser = new APIParser();
        PlaceChecker placeChecker = new PlaceChecker();

        String userInputPlace = userInputHandler.getUserInput("Enter the name of the place: ");
        String userInputDay = userInputHandler.getUserDayInput();
        String userInputTime = userInputHandler.getUserTimeInput();

        // Find place using user input
        String searchResponse = connector.findPlaceFromText(userInputPlace);

        // Extract place ID from the search response
        String placeId = placeParser.getPlaceIdFromResponse(searchResponse);

        // Get details of the place using the place ID
        String placeDetailsResponse = connector.getPlaceDetails(placeId);

        boolean isOpen = placeChecker.checkIfOpen(placeDetailsResponse, userInputDay, userInputTime);

        if (isOpen) {
            System.out.println("The place is open at given time");
        } else {
            System.out.println("The place is closed at given time");
        }

    }
}
