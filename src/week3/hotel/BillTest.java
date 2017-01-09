package week3.hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jotte on 19-12-16.
 */

public class BillTest {
    private Bill bill;


    @Before
    public void makeBill() {
        bill = new Bill(System.out);

    }

    @Test
    public void testNewitem() {
        assertEquals("Startsum is zero", bill.getSum(), 0, 0.000001);
        bill.newItem(new Item("test0,2", 0.2));
        assertEquals("Add item one", 0.2, bill.getSum(), 0.000001);
        bill.newItem(new Item("test", 0.23));
        assertEquals("Add item one", 0.43, bill.getSum(), 0.000001);
        bill.newItem(null);
        assertEquals("Added empty item", 0.43, bill.getSum(), 0.000001);
        bill.close();
    }
}

