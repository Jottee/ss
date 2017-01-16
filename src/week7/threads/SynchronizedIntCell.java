package week7.threads;

/**
 * Created by jelle on 16/01/2017.
 */
public class SynchronizedIntCell implements ss.week7.threads.IntCell {
    private int value = 0;
    boolean empty = true;
    public synchronized void setValue(int val) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.value = val;
        notify();
    }

    public synchronized int getValue() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notify();
        return value;
    }

}
