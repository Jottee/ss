package week3.pw;

/**
 * Created by jotte on 18-12-16.
 */

public class Password {
    public final static String INITIAL = "JJ";

    private String pass;
    private Checker checker;
    private String factoryPassword;

    public Password() {
        BasicChecker.getINITPASS();
    }


    public boolean acceptable(String p) {
        return (p.length() >= 6 && !p.contains(" "));
    }

    public Password(Checker check) {
        checker = check;
        factoryPassword = checker.generatePassword();
        pass = factoryPassword;

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