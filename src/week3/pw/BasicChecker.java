package week3.pw;

/**
 * Created by jotte on 19-12-16.
 */

public class BasicChecker implements Checker {

    private static String INITPASS = "abcdef";

    public static String getINITPASS() {
        return INITPASS;
    }

    public static void setINITPASS(String INITPASS) {
        BasicChecker.INITPASS = INITPASS;
    }

    @Override
    public boolean acceptable(String check) {
        return check.length() >= 6 && !check.contains(" ");
    }

    public String generatePassword() {
        return getINITPASS();
    }

    public static void main(String[] args) {
        new BasicChecker().acceptable(null);
    }

}
