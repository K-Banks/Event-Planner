import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Boolean end = true;
        Boolean firstCheckout = true;

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
                String userEntertainmentChoice = bufferedReader.readLine().toLowerCase();
                while (newEvent.checkEntertainmentOption(userEntertainmentChoice) == false) {
                    System.out.println("Sorry, that is an invalid selection. Please enter one of the four choices (live DJ, live band, set playlist, or custom playlist)");
                    System.out.print("Your selection: ");
                    userEntertainmentChoice = bufferedReader.readLine().toLowerCase();
                }
                newEvent.setEntertainmentOption(userEntertainmentChoice);

                System.out.println("Awesome, we have your event details set. You are expecting " + newEvent.getNumberOfGuests() + " guests. We will be serving " + newEvent.getFoodOption() + " and " + newEvent.getBeverageOption() + " and the music will be provided by a " + newEvent.getEntertainmentOption());
                if (newEvent.getNumberOfGuests() >= 100 && newEvent.getBeverageOption().equals("open bar")) {
                    System.out.println("Your event qualifies for a coupon! Enter 'discount' for 10% off your estimate.");
                } else if (firstCheckout) {
                    System.out.println("Thank you for planning this event with us. As a first time user, enter code '100off' for $100 off your estimate!");
                    firstCheckout = false;
                }
                newEvent.calculateEstimatePrice();
                System.out.println("Your current estimate for the event is: $" + newEvent.getEstimatePrice());
                System.out.println("Do you have a coupon code to enter? Y or N");
                String estimateConfirm = bufferedReader.readLine().toLowerCase();
                if (estimateConfirm.equals("y")) {
                    System.out.print("Please enter your coupon code: ");
                    String coupon = bufferedReader.readLine().toLowerCase();
                    newEvent.checkCoupon(coupon);
                    newEvent.calculateEstimatePrice();
                    System.out.println("Your new estimate is: $" + newEvent.getEstimatePrice());
                } else {
                    System.out.println("Your final estimate is confirmed for $" + newEvent.getEstimatePrice());
                }

                System.out.println("Thank you for planning your event with us. Would you like to plan another? Y or N");
                String createNewEvent = bufferedReader.readLine().toLowerCase();
                if (createNewEvent.equals("n")) {
                    end = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
