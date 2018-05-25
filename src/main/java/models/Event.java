package models;

public class Event {
    private Integer numberOfGuests;
    private String foodOption;
    private String beverageOption;
    private String entertainmentOption;

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
        return null;
    }
}
