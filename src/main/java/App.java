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

                System.out.println("Next, please what drinks we should serve. The options include: water, soda, beer, wine, or open bar for a premium price.");
                System.out.print("Your selection of beverage: ");
                String userBeverageChoice = bufferedReader.readLine().toLowerCase();
                while (newEvent.checkBeverageOption(userBeverageChoice) == false) {
                    System.out.println("Sorry, that is an invalid selection. Please enter one of the five choices (water, beer, wine, soda, open bar)");
                    System.out.print("Your selection: ");
                    userBeverageChoice = bufferedReader.readLine().toLowerCase();
                }
                newEvent.setBeverageOption(userBeverageChoice);
                System.out.println("Got it. We will be serving " + newEvent.getBeverageOption());

                System.out.println("Finally, let's decide on entertainment. We offer a limited selection of musical entertainment. We options for a live DJ, a live band, our own set playlist or a custom playlist we can tailor to your specific taste.");
                System.out.println("Please enter one of the following as your selection: live DJ, live band, set playlist, or custom playlist");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
