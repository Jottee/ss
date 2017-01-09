package week3.hotel;

/**
 * Created by jotte on 22-12-16.
 */
public class Item implements Bill.Item {

    public double amount;
    public String text;

    @Override
    public double getAmount() {
        return amount;
    }

    public Item(String text, Double amount) {
        this.text = text;
        this.amount = amount;


    }

    @Override
    public String toString() {
        return text;
    }

}
