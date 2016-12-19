package week3.hotel;

/**
 * Created by jotte on 19-12-16.
 */
public class PricedSafe extends week3.hotel.Safe implements Bill.Item {

    private double amount;

    public PricedSafe(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        String output = "";
        output += "Price: " + amount;
        return output;
    }
}
