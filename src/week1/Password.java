package week1;

/**
 * Created by jotte on 18-12-16.
 */

public class Password {
    public final static String INITIAL = "JJ";

    private String pass;

    public Password() {
        pass = INITIAL;
    }

    public boolean acceptable(String p) {
        return (p.length() >= 6 && !p.contains(" "));
    }

    public boolean setWord(String old_pass, String new_pass) {
        boolean res = false;
        if (testWord(old_pass) && acceptable(new_pass)) {
            pass = new_pass;
            res = true;
        }
        return res;
    }

    public boolean testWord(String test_pass) {
        return pass.equals(test_pass);
    }
}