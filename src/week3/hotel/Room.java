package week3.hotel;

/**
 * Created by jotte on 19-12-16.
 */

/**
 * Hotel room with number and possibly a guest.
 *
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    private Safe safe;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     *
     * @param no         number of the new <code>Room</code>
     * @param pricedSafe
     */
    public Room(int no, PricedSafe pricedSafe) {
        number = no;
        this.safe = safe;
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     *
     * @return the guest of this <code>Room</code>;
     * <code>null</code> if this <code>Room</code>
     * is not currently rented
     */
    public Guest getGuest() {
        return guest;
    }

    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     *
     * @param g the next guest renting this <code>Room</code>;
     *          if <code>null</code> is passed, this <code>Room</code>
     *          is empty afterwards
     */
    public void setGuest(Guest g) {
        guest = g;
    }

    public Safe getSafe() {
        return safe;
    }

    public void setSafe(Safe safe) {
        this.safe = safe;
    }
}