package week2.test;

/**
 * Created by jotte on 18-12-16.
 */

import org.junit.Test;
import week2.Rectangle;

import static org.junit.Assert.*;


public class RectangleTest {
    private Rectangle rect;

    @Test
    public void testSetup() {
        rect = new Rectangle(10, 15);
        assertEquals("Test length:", 10, rect.length());
        assertEquals("Test width:", 15, rect.width());
    }

    @Test
    public void testArea() {
        rect = new Rectangle(10, 10);
        assertEquals("Test area:", 100, rect.area());
    }

    @Test
    public void testPerimeter() {
        rect = new Rectangle(10, 10);
        assertEquals("Test perimeter:", 40, rect.perimeter());
    }
}
