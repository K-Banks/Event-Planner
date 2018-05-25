package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void event_instantiatesAnEventObject_true() {
        Event testEvent = new Event(0, "", "", "");
        assertTrue(testEvent instanceof Event);
    }

    @Test
    public void getNumberOfGuests_returnsNumberOfGuests_4() {
        Event testEvent = new Event(4, "", "", "");
        Integer expected = 4;
        assertEquals(expected, testEvent.getNumberOfGuests());
    }

    @Test
    public void setNumberOfGuests_setsNumberOfGuests_6() {
        Event testEvent = new Event(4, "", "", "");
        Integer expected = 6;
        testEvent.setNumberOfGuests(expected);
        assertEquals(expected, testEvent.getNumberOfGuests());
    }

    @Test
    public void getFoodOption_returnsFoodOption_chicken() {
        Event testEvent = new Event(4, "chicken", "", "");
        String expected = "chicken";
        assertEquals(expected, testEvent.getFoodOption());
    }

    @Test
    public void setFoodOption_setsFoodOption_beef() {
        Event testEvent = new Event(4, "chicken", "", "");
        String expected = "beef";
        testEvent.setFoodOption(expected);
        assertEquals(expected, testEvent.getFoodOption());
    }

    @Test
    public void getBeverageOption_returnsBeverageOption_water() {
        Event testEvent = new Event(4, "chicken", "water", "");
        String expected = "water";
        assertEquals(expected, testEvent.getBeverageOption());
    }

    @Test
    public void setBeverageOption_setsBeverageOption_soda() {
        Event testEvent = new Event(4, "chicken", "water", "");
        String expected = "soda";
        testEvent.setBeverageOption(expected);
        assertEquals(expected, testEvent.getBeverageOption());
    }

    @Test
    public void getEntertainmentOption_returnsEntertainmentOption_DJ() {
        Event testEvent = new Event(4, "chicken", "water", "DJ");
        String expected = "DJ";
        assertEquals(expected, testEvent.getEntertainmentOption());
    }

    @Test
    public void setEntertainmentOption_setsEntertainmentOption_LiveBand() {
        Event testEvent = new Event(4, "chicken", "water", "DJ");
        String expected = "Live Band";
        testEvent.setEntertainmentOption(expected);
        assertEquals(expected, testEvent.getEntertainmentOption());
    }

    @Test
    public void evaluateFoodPrice_returnsEstimatedPriceForFood_70() {
        Event testEvent = new Event(10, "beef", "", "");
        Integer expected = 70;
        assertEquals(expected, testEvent.evaluateFoodPrice());
    }

    @Test
    public void evaluateBeveragePrice_returnsEstimatedPriceForBeverages_40() {
        Event testEvent = new Event(10, "beef", "wine", "");
        Integer expected = 40;
        assertEquals(expected, testEvent.evaluateBeveragePrice());
    }

    @Test
    public void evaluateEntertainmentPrice_returnsEntertainmentPrice_500() {
        Event testEvent = new Event(10, "beef", "wine", "live band");
        Integer expected = 500;
        assertEquals(expected, testEvent.evaluateEntertainmentPrice());
    }

    @Test
    public void getEstimatePrice_returnsEstimatePrice_true() {
        Event testEvent = new Event(10, "beef", "wine", "");
        assertTrue(testEvent.getEstimatePrice() instanceof Integer);
    }

    @Test
    public void calculateEstimatePrice_setsEventEstimatePriceBasedOnProvidedParameters_410() {
        Event testEvent = new Event(20, "buffet", "soda", "live dj");
        testEvent.calculateEstimatePrice();
        Integer expected = 410;
        assertEquals(expected, testEvent.getEstimatePrice());
    }

    @Test
    public void getCoupon_returnsCouponValue_true() {
        Event testEvent = new Event(20, "", "", "");
        assertTrue(testEvent.getCoupon() instanceof String);
    }

    @Test
    public void setCoupon_setsCouponValue_string() {
        Event testEvent = new Event(20, "", "", "");
        testEvent.setCoupon("string");
        assertTrue(testEvent.getCoupon().equals("string"));
    }

    @Test
    public void calculateEstimatePrice_appliesDiscountToEstimatePrice_369() {
        Event testEvent = new Event(20, "buffet", "soda", "live dj");
        testEvent.setCoupon("Discount");
        testEvent.calculateEstimatePrice();
        Integer expected = 369;
        assertEquals(expected, testEvent.getEstimatePrice());
    }
}