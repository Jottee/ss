package week2.test;

import org.junit.Before;
import org.junit.Test;
import week2.hotel.Guest;
import week2.hotel.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoomTest {
    private Guest guest;
    private Room room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }

    @Test
    public void testSafe() {
        assertNotNull(room.getSafe());
    }
}
