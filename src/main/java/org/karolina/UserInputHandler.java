package org.karolina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class UserInputHandler {

    private static final List<String> VALID_DAYS = Arrays.asList(
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

    public static String getUserInput(String prompt) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getUserDayInput() {
        String userDay;

        while (true) {
            userDay = getUserInput("Enter the day of the week (e.g., Monday, Tuesday, etc.): ");

            if (isValidDay(userDay)) {
                break;
            } else {
                System.out.println("Invalid day. Please enter a valid day of the week.");
            }
        }

        return userDay;
    }

    private static boolean isValidDay(String day) {
        return VALID_DAYS.contains(day);
    }

    public static String getUserTimeInput() {
        String userTime;

        while (true) {
            userTime = getUserInput("Enter the time (HHmm): ");

            if (isValidTimeFormat(userTime)) {
                break;
            } else {
                System.out.println("Invalid time format. Please enter the time in HHmm format.");
            }
        }

        return userTime;
    }

    private static boolean isValidTimeFormat(String time) {
        return time.matches("^([0-1]?[0-9]|2[0-3])[0-5][0-9]$");
    }
}
