package week7.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jelle on 16/01/2017.
 */
public class TestSyncConsole2 extends Thread {
    private static ReentrantLock lock;

    public static void main(String[] args) {
        TestSyncConsole2 inst1 = new TestSyncConsole2();
        TestSyncConsole2 inst2 = new TestSyncConsole2();
        lock = new ReentrantLock(true);
        inst1.start();
        inst2.start();
    }

    @Override
    public void run() {
        sum();
    }

    private synchronized int sum() {
        lock.lock();
        try {
            Console.println("test");
            int a = Console.readInt("Enter first int");
            int b = Console.readInt("Enter second int");
            int res = a + b;
            String result = "The result is: " + res;
            Console.println(result);
            return (res);
        } finally {
            lock.unlock();
        }
    }
}