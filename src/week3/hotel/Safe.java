package week3.hotel;

import week2.hotel.Password;

/**
 * Created by jotte on 18-12-16.
 */
public class Safe {

    private Password pass = new Password();
    private boolean active;
    private boolean open;
    private Safe safe = new Safe();

    //@ requires !password.equals("");
    //@ ensures pass.testWord(password) ==> active == true;
    public boolean activate(String password) {
        boolean result;
        assert !password.equals("");
        if (pass.testWord(password)) {
            active = true;
            result = true;
        } else {
            result = false;
        }
        assert pass.testWord(password) ? active == true : active == false;
        return result;
    }

    //@ ensures !active && !open;
    public void deactivate() {
        active = false;
        open = false;
        assert !active && !open;
    }

    //@ requires password != "";
    //@ ensures (pass.testWord(password) && active) ? open == true : open == true || open == false;
    public void open(String password) {
        assert password != "";
        if (pass.testWord(password) && active) {
            open = true;
        }
        assert pass.testWord(password) && active ? open == true : open == true || open == false;
    }

    //@ ensures open == false;
    public void close() {
        open = false;
        assert !open;
    }

    //@ ensures active ? \result == true : \result == false;
    public boolean isActive() {
        assert active ? isActive() == true : isActive() == false;
        return active;
    }

    //@ ensures open ? \result == true : \result == false;
    public boolean isOpen() {
        assert open ? isOpen() == true : isOpen() == false;
        return open;
    }

    public static void main(String[] args) {
        Safe safe = new Safe();
        safe.activate("");
    }

    //@ ensures \result == pass;
    public Password getPassword() {
        assert getPassword() == pass;
        return pass;
    }
}

