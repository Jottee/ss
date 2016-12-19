package week2.hotel;

/**
 * Created by jotte on 19-12-16.
 */

public class Hotel {
    /* Commands:
     * 	checkIn:		- two String objects as parameters (password, name guest)
     * 					- returns a Room object with a new Guest (name guest), or null if either:
     * 						+ password is wrong,
     * 						+ there is already a guest with this name or,
     * 						+ hotel is full
     *
     *  checkOut:		- parameter: name guest.
     *  				- This guest is checked out, safe in his room is deactivated.
     *  				- If there is no guest with this name, nothing happens
     *
     *  getFreeRoom:	- return Room where no guest is checked in, or null if there is no free room
     *
     *  getRoom:		- name guest as param, returning Room where the guest is checked in,
     *  				  or null if there is no such room
     *
     *  getPassword:	- returns Password object of the hotel
     *
     *  toString:		- gives textual description of all rooms, including name guest and status
     *  				  of the safe in that room
     */
    private static Safe safe = new Safe();
    public static Password pass = new Password();
    private String name;
    private Room room1;
    private Room room2;
    private Guest guest = new Guest(name);
    private String hotelName;

    public Hotel(String h) {
        room1 = new Room(1);
        room2 = new Room(2);
        hotelName = h;
    }

    public Room checkIn(String password, String guestName) {
        if (pass.testWord(password) && getRoom(guestName) == null
                && getFreeRoom() != null) {
            if (room1.getGuest() == null) {
                Guest g = new Guest(guestName);
                g.checkin(room1);
                return g.getRoom();
            } else {
                Guest g = new Guest(guestName);
                g.checkin(room2);
                return g.getRoom();
            }
        } else {
            return null;
        }
    }


    public void checkOut(String guestName) {
        Guest g = new Guest(guestName);
        if (room1.getGuest() != null && room1.getGuest().getName().equals(g.getName())) {
            room1.getGuest().checkout();
        }
        if (room2.getGuest() != null && room2.getGuest().getName().equals(g.getName())) {
            room2.getGuest().checkout();
        }
    }

    public Room getFreeRoom() {
        if (room1.getGuest() == null) {
            System.out.println("return room1");
            return room1;
        } else if (room2.getGuest() == null) {
            System.out.println("return room2");
            return room2;
        } else {
            System.out.println("return null");
            return null;
        }
    }

    public Room getRoom(String guestName) {
        Guest g = new Guest(guestName);
        if (room1.getGuest() != null && room1.getGuest().getName().equals(g.getName())) {
            return room1;
        } else if (room2.getGuest() != null && room2.getGuest().getName().equals(g.getName())) {
            return room2;
        } else
            return null;

    }

    public Password getPassword() {
        return pass;
    }

    public String toString() {
        return "Kamer 1, gast:" + room1.getGuest() + ",kluisstatus: " + room1.getSafe().isActive() +
                "Kamer 2, gast:" + room2.getGuest() + ",kluisstatus: " + room2.getSafe().isActive();
    }
}