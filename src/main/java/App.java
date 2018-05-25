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

                System.out.println("For food, we offer pre-made vegetarian, chicken, and beef dishes. We also offer a buffet with all options available for your guests.");
                System.out.println("Please enter one of the four choices as your selection for the event (chicken, vegetarian, beef, or buffet)");
                System.out.print("Your selection: ");
                String userFoodChoice = bufferedReader.readLine().toLowerCase();
                while (newEvent.checkFoodOption(userFoodChoice) == false) {
                    System.out.println("Sorry, that is an invalid selection. Please enter one of the four choices (chicken, vegetarian, beef, or buffet)");
                    System.out.print("Your selection: ");
                    userFoodChoice = bufferedReader.readLine().toLowerCase();
                }
                newEvent.setFoodOption(userFoodChoice);
                System.out.println("Great! We will be serving you and your guests " + newEvent.getFoodOption());


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
