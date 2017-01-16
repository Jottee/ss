package week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jelle on 16/01/2017.
 */
public class FinegrainedIntCell implements ss.week7.threads.IntCell {
    final ReentrantLock lock = new ReentrantLock(true);
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    boolean isFull = false;

    private int value;

    public void setValue(int val) {
        lock.lock();
        try {
            while(isFull) {
                notFull.await();
            }
            value = val;
            isFull = true;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        lock.lock();
        try {
            while (!isFull) {
                notEmpty.await();
            }
            notFull.signal();
            isFull = false;
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.unlock();
        }
    }
}
