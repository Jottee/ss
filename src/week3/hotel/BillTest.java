package week3.hotel;

import static org.junit.Assert.assertEquals;

/**
 * Created by jotte on 19-12-16.
 */

public class BillTest {
    private Bill bill;


    @before
    public void makeBill() {
        public void setUp () throws Exception {
            bill = new Bill(System.out);
        }
    }

    @test
    public void testNewitem() {
        assertEquals("Startsum is zero", bill.getSum(), 0, 0.000001);
        bill.newItem(new Bill.Item());
        assertEquals("Add item one", 1, bill.getSum(), 0.000001);
        bill.newItem(new Bill.Item());
        assertEquals("Add item one", 2, bill.getSum(), 0.000001);
        bill.newItem(null);
        assertEquals("Added empty item", 2, bill.getSum(), 0.000001);
        bill.close();
    }
}

