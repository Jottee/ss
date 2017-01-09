package week3.pw;

/**
 * Created by jotte on 19-12-16.
 */
public class TimedPassword extends Password {
    private long validTime;
    public long timeOfPassCreation = 0;

    public TimedPassword() {
        this(3600000);
    }

    public TimedPassword(long validTime) {
        this.validTime = validTime;
        timeOfPassCreation = System.currentTimeMillis();
    }

    @Override
    public boolean setWord(String oldpass, String newpass) {
        boolean ans = false;
        if (super.setWord(oldpass, newpass)) {
            timeOfPassCreation = System.currentTimeMillis();
            ans = true;
        }
        return ans;
    }

    public boolean isExpired() {
        if (timeOfPassCreation + validTime > System.currentTimeMillis()) {
            return false;
        } else {
            return true;
        }
    }
}
