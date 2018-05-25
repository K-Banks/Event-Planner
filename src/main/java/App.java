import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Boolean end = true;

        while (end) {
            System.out.println("Hello, welcome to Event Planner.");
            Event newEvent = new Event(0, "", "", "");

            try {
                System.out.println("Let's start with the number of guests you are expecting for your event. Please enter your best estimate then hit enter.");
                System.out.print("Number of guests expected: ");
                String userGuestInput = bufferedReader.readLine();
                System.out.println();
                while (!Pattern.matches("[0-9]+", userGuestInput)) {
                    System.out.println("Sorry, that is an invalid entry. Please only enter numbers.");
                    System.out.print("Number of guests expected: ");
                    userGuestInput = bufferedReader.readLine();
                }
                newEvent.setNumberOfGuests(Integer.parseInt(userGuestInput));
                System.out.println("Great! So you are expecting " + newEvent.getNumberOfGuests() + " guests. Let's go over food and drink options next.");




            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
