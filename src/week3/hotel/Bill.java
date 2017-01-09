package week3.hotel;

import java.io.PrintStream;

/**
 * Created by jotte on 19-12-16.
 */
public class Bill {
    private PrintStream output;
    private double sumPrice;

    //Interface Item, double getAmount() (ItemTest.java)
    public interface Item {
        public double getAmount();
    }

    //Constructor
    public Bill(PrintStream stream) {
        this.output = stream;
        this.sumPrice = 0;
    }

    //Methods
    public void close() {
        this.output.println(String.format("%-10s%10.2f\n", "Total", this.getSum()));
    }

    public double getSum() {
        return this.sumPrice;
    }

    public void newItem(Bill.Item item) {
        if (item != null) {
            double price = item.getAmount();
            this.sumPrice += price;
            this.output.println(String.format("%-10s%10.2f\n", item, price));
        }
    }
}
