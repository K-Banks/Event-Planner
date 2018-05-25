package models;

public class Event {
    private Integer numberOfGuests;
    private String foodOption;
    private String beverageOption;
    private String entertainmentOption;
    private Integer estimatePrice;
    private String coupon;

    public Event(int numberOfGuests, String foodOption, String beverageOption, String entertainmentOption) {
        this.numberOfGuests = numberOfGuests;
        this.foodOption = foodOption;
        this.beverageOption = beverageOption;
        this.entertainmentOption = entertainmentOption;

        this.estimatePrice = 0;
        this.coupon = "";
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
        foodOption = option.toLowerCase();
    }

    public String getBeverageOption() {
        return beverageOption;
    }

    public void setBeverageOption(String option) {
        beverageOption = option.toLowerCase();
    }

    public String getEntertainmentOption() {
        return entertainmentOption;
    }

    public void setEntertainmentOption(String option) {
        entertainmentOption = option.toLowerCase();
    }

    public Integer getEstimatePrice() {
        return estimatePrice;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String option) {
        coupon = option.toLowerCase();
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
        estimatePrice = this.evaluateFoodPrice() + this.evaluateBeveragePrice() + this.evaluateEntertainmentPrice();
        if (coupon.equals("discount")) {
            estimatePrice = estimatePrice-(estimatePrice/10);
        } else if (coupon.equals("100off")) {
            estimatePrice = estimatePrice-100;
        } else {
            estimatePrice = estimatePrice;
        }
    }

    public void checkCoupon(String option) {
        if (option.toLowerCase().equals("discount") && numberOfGuests >= 100 && !beverageOption.equals("open bar")) {
            this.setCoupon(option);
        } else if (option.toLowerCase().equals("100off")) {
            this.setCoupon(option);
        }
    }

    public boolean checkFoodOption(String option) {
        option = option.toLowerCase();
        if (option.equals("chicken") || option.equals("beef") || option.equals("vegetarian") || option.equals("buffet")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBeverageOption(String option) {
        option = option.toLowerCase();
        if (option.equals("water") || option.equals("beer") || option.equals("soda") || option.equals("wine") || option.equals("open bar")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEntertainmentOption(String option) {
        option = option.toLowerCase();
        if (option.equals("live dj") || option.equals("live band") || option.equals("set playlist") || option.equals("custom playlist")) {
            return true;
        } else {
            return false;
        }
    }
}
