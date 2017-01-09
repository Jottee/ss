package week3.hotel;

/**
 * Created by jotte on 19-12-16.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PricedSafeTest {

    private Bill.Item item;
    private static final double PRICE = 6.66;
    private static final String PRICE_PATTERN = ".*6[.,]66.*";

    @Before
    public void setUp() throws Exception {
        item = new PricedSafe(PRICE);
    }

    @Test
    public void testGetAmount() throws Exception {
        assertEquals("GetAmount should return the price of the safe.", PRICE, item.getAmount(), 0);
    }

    @Test
    public void testToString() throws Exception {
        System.out.println(item.toString());
        assertTrue("The price should be included.", item.toString().matches(PRICE_PATTERN));
    }
}
