package week3.hotel;

/**
 * Created by jotte on 19-12-16.
 */
public class PricedRoom extends week3.hotel.Room implements Bill.Item {

    private double amount;

    public PricedRoom(int roomNo, double roomPrice, double safePrice) {
        super(roomNo, new PricedSafe(safePrice));
        this.amount = roomPrice;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        String output = "Price: " + amount;
        return output;
    }
}
