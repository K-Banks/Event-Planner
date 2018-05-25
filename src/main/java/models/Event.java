package models;

public class Event {
    private Integer numberOfGuests;
    private String foodOption;
    private String beverageOption;
    private String entertainmentOption;
    private Integer estimatePrice = 0;

    public Event(int numberOfGuests, String foodOption, String beverageOption, String entertainmentOption) {
        this.numberOfGuests = numberOfGuests;
        this.foodOption = foodOption;
        this.beverageOption = beverageOption;
        this.entertainmentOption = entertainmentOption;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int number) {
        numberOfGuests = number;
    }

    public String getFoodOption() {
        return foodOption;
    }

    public void setFoodOption(String option) {
        foodOption = option;
    }

    public String getBeverageOption() {
        return beverageOption;
    }

    public void setBeverageOption(String option) {
        beverageOption = option;
    }

    public String getEntertainmentOption() {
        return entertainmentOption;
    }

    public void setEntertainmentOption(String option) {
        entertainmentOption = option;
    }

    public Integer getEstimatePrice() {
        return estimatePrice;
    }

    public Integer evaluateFoodPrice() {
        Integer foodPrice = 0;
        if (foodOption.equals("chicken") || foodOption.equals("vegetarian")) {
            foodPrice = numberOfGuests*5;
        } else if (foodOption.equals("beef")) {
            foodPrice = numberOfGuests*7;
        } else if (foodOption.equals("buffet")) {
            foodPrice = numberOfGuests*10;
        } else {
            foodPrice = foodPrice;
        }
        return foodPrice;
    }

    public Integer evaluateBeveragePrice() {
        Integer beveragePrice = 0;
        if (beverageOption.equals("water")) {
            beveragePrice = numberOfGuests*0;
        } else if (beverageOption.equals("soda")) {
            beveragePrice = numberOfGuests/2;
        } else if (beverageOption.equals("beer")) {
            beveragePrice = numberOfGuests*2;
        } else if (beverageOption.equals("wine")) {
            beveragePrice = numberOfGuests*4;
        } else if (beverageOption.equals("open bar")) {
            beveragePrice = numberOfGuests*6;
        } else if (beverageOption.equals("water")) {
            beveragePrice = beveragePrice;
        } else {
            beveragePrice=beveragePrice;
        }
        return beveragePrice;
    }

    public Integer evaluateEntertainmentPrice() {
        Integer entertainmentPrice = 0;
        if (entertainmentOption.equals("live dj")) {
            entertainmentPrice = 200;
        } else if (entertainmentOption.equals("live band")) {
            entertainmentPrice = 500;
        } else if (entertainmentOption.equals("set playlist")) {
            entertainmentPrice = entertainmentPrice;
        } else if (entertainmentOption.equals("custom playlist")) {
            entertainmentPrice = 150;
        } else {
            entertainmentPrice = entertainmentPrice;
        }
        return entertainmentPrice;
    }

    public void calculateEstimatePrice() {

    }
}
