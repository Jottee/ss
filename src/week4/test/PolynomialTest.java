package week4.test;

/**
 * Created by jotte on 16-1-17.
 */

import org.junit.Before;
import org.junit.Test;
import week4.math.Polynomial;
import week4.math.Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private Polynomial p;
    private double[] d = {2, 3, 4};

    @Before
    public void setup() {
        p = new Polynomial(d);
    }

    @Test
    public void testPolynomial() {
        assertEquals(p.apply(2), 96, 0);
        assertEquals(p.apply(0), 0, 0);
        assertEquals(p.apply(-1), 3, 0);
    }

    @Test
    public void testDerivative() {
        assertEquals(p.derivative().apply(2), 172, 0);
        assertTrue(p.derivative() instanceof Sum);
    }

    @Test
    public void testIntegrand() {
        System.out.println(p.integrand().apply(2));
        assertTrue(p.integrand().apply(2) < 43 && p.integrand().apply(2) > 42.9);
        assertTrue(p.integrand() instanceof Sum);
    }
}