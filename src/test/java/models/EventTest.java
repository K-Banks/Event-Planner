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
}