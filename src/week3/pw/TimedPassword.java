package week3.pw;

/**
 * Created by jotte on 19-12-16.
 */
public class TimedPassword extends Password {
    private long validTime;
    public long time = 0;

    public TimedPassword(long validTime) {
        this.validTime = validTime;
        time = System.currentTimeMillis();
    }

    @Override
    public boolean setWord(String oldpass, String newpass) {
        boolean ans = false;
        if (super.setWord(oldpass, newpass)) {
            time = System.currentTimeMillis();
            ans = true;
        }
        return ans;
    }

    public boolean isExpired() {
        if (time + validTime > System.currentTimeMillis()) {
            return false;
        } else {
            return true;
        }
    }
}
