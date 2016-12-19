package week2.hotel;

/**
 * Created by jotte on 18-12-16.
 */
public class Safe {

    private Password pass = new Password();
    private boolean active = false;
    private boolean open = false;

    //@ requires !password.equals("");
    //@ ensures pass.testWord(password) ==> isActive();
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

    //@ ensures !isActive() && !isOpen();
    public void deactivate() {
        active = false;
        open = false;
        assert !active && !open;
    }

    //@ requires password != "";
    //@ ensures (pass.testWord(password) && isActive()) ? isOpen() : !isOpen();
    public void open(String password) {
        assert !password.equals("");
        if (pass.testWord(password) && active) {
            open = true;
        }
        assert pass.testWord(password) && active ? open == true : open == false;
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

