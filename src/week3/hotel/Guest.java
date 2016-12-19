package week3.hotel;

import week2.hotel.Room;

/**
 * Created by jotte on 19-12-16.
 */

public class Guest {
    private String name;
    private week2.hotel.Room room;

    // ----------------- Constructor ------------------
    public Guest(String n) {
        name = n;
    }

    // ----------------- Methods ----------------------
    //Returns the name of this Guest.
    public String getName() {
        return name;
    }

    //Returns the Room that is rented by this Guest.
    public week2.hotel.Room getRoom() {
        return room;

    }

    /**
     * Rents a Room to this Guest. This is only possible if this Guest does not already have a Room.
     * and the Room to be assigned is not already rented.
     * Also adapts the Guest-reference of the Room.
     */
    public boolean checkin(Room r) {
        if (r.getGuest() == null && this.room == null) {
            r.setGuest(this);
            this.room = r;
            return true;
        } else {
            return false;
        }
    }

    //Sets the Room of this Guest to null. Also resets the Guest-reference of the (current) Room.
    public boolean checkout() {
        if (this.room != null && room.getGuest() != null) {
            room.setGuest(null);
            this.room = null;
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        return "Guest is " + getName() + ", and room is " + getRoom();
        //return "The guest is " + name + " and the room is " + room;
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub

    }

}