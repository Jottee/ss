package week2.test;

/**
 * Created by jotte on 19-12-16.
 */

import org.junit.Before;
import org.junit.Test;
import week2.hotel.Password;
import week2.hotel.Safe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SafeTest {
    //Creates testvariable safe from type Safe
    private Safe safe;


    @Before
    public void setUp() throws Exception {
        safe = new Safe();

    }

    //Tests activate()
    @Test
    public void testActivate() {
        //Deactivate first, then test if activate() can activate the safe.
        safe.deactivate();

        //Test activate() with a wrong password
        safe.activate("wrong");
        assertFalse(safe.isActive());

        //Test activate() with a correct password
        safe.activate(new String(Password.INITIAL));
        assertTrue(safe.isActive());

        //Test activate() when it is already activated
        safe.deactivate();
        safe.activate(new String(Password.INITIAL));
        safe.activate(new String(Password.INITIAL));
        assertTrue(safe.isActive());
    }

    //Tests deactivate()
    @Test
    public void testDeactivate() {
        //Activate it first (with a correct password),
        //then test if deactivate() can activate the safe
        safe.activate(new String(Password.INITIAL));

        safe.deactivate();
        assertFalse(safe.isOpen());
        assertFalse(safe.isActive());
        //deactivate() should close and deactivate it, check both.
    }

    //Tests open()
    @Test
    public void testOpen() {
        //Test with a deactivated safe first, both with correct and incorrect password.
        safe.close();
        safe.deactivate();

        safe.open("wrong");
        assertFalse(safe.isOpen());

        safe.open(new String(Password.INITIAL));
        assertFalse(safe.isOpen());
        //Because the safe is deactivated, this should be assertFalse even with correct pass


        //Now activate the safe, then check with correct and incorrect password.
        safe.close();
        safe.activate(new String(Password.INITIAL));

        safe.open("wrong");
        assertFalse(safe.isOpen());

        safe.open(new String(Password.INITIAL));
        assertTrue(safe.isOpen());
    }

    //Tests close()
    @Test
    public void testClose() {
        //Activate and open first (if it is deactivated, it can't be opened)
        safe.activate(new String(Password.INITIAL));
        safe.open(new String(Password.INITIAL));

        safe.close();
        assertFalse(safe.isOpen());
        assertTrue(safe.isActive()); //Remember, close() shouldn't change the activity status
    }

    //Tests isActive()
    @Test
    public void testisActive() {
        //Tests isActive() when it is deactivated
        safe.deactivate();
        assertFalse(safe.isActive());

        //Tests isActive() when it is activated
        safe.activate(new String(Password.INITIAL));
        assertTrue(safe.isActive());
    }

    //Tests isOpen()
    @Test
    public void testisOpen() {
        //Activates the safe first so it can be opened
        safe.activate(new String(Password.INITIAL));


        safe.close();
        assertFalse(safe.isOpen());

        safe.open(new String(Password.INITIAL));
        assertTrue(safe.isOpen());
    }


}