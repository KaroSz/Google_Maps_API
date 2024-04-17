# Is-open-checker App

## Overview

Is-open-checker is a Java application that helps users check the opening hours of places using the Google Places API. Users can input the name of a place, along with a day and time, to determine if the place is open at the specified time.

## Features

- Search for a place by name using the Google Places API.
- Retrieve opening hours for the selected place.
- Check if the place is open at a specified day and time.
- User-friendly command-line interface for input and output.

## Technologies Used

- Java
- Google Places API: [Find Place](https://developers.google.com/maps/documentation/places/web-service/search-find-place) and [Place Details](https://developers.google.com/maps/documentation/places/web-service/details)
- Gson library for JSON parsing
- JUnit Jupiter for testing

## Installation

### Prerequisites

- Java Development Kit (JDK) installed
- [Google Places API key](https://developers.google.com/maps/documentation/places/web-service/get-api-key)

### Steps

1. Clone the repository:
    ```bash
    git clone https://github.com/KaroSz/Is-open-checker.git
    ```

2. Navigate to the project directory:
    ```bash
    cd Is-open-checker
    ```

3. Replace `YOUR_API_KEY` in `GooglePlacesAPIConnector.java` with your Google Places API key:
    ```java
    private static final String API_KEY = "YOUR_API_KEY";
    ```

4. Compile and run the application:
    ```bash
    javac Main.java
    java Main
    ```

## Usage

1. Run the application.
2. Enter the name of the place you want to check.
3. Enter the day of the week.
4. Enter the time in HHmm format.
5. The application will display whether the place is open at the specified time.
