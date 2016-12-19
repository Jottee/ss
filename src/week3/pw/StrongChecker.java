package week3.pw;

/**
 * Created by jotte on 19-12-16.
 */

public class StrongChecker extends BasicChecker {

    private static final String INITPASS = "abcdef1";

    @Override
    public boolean acceptable(String check) {
        return super.acceptable(check) && Character.isLetter(check.charAt(0)) && Character.isDigit(check.charAt(check.length() - 1));
    }

    public String generatePassword() {
        return INITPASS;
    }
}