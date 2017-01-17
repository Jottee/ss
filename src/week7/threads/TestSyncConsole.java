package week7.threads;
/**
 * Created by jelle on 16/01/2017.
 */
public class TestSyncConsole extends Thread {
    public static void main(String[] args) {
        TestSyncConsole inst1 = new TestSyncConsole();
        TestSyncConsole inst2 = new TestSyncConsole();
        inst1.start();
        while (inst1.getState() != State.TERMINATED) {
        }
        inst2.start();
    }

    @Override
    public void run() {
        sum();
    }

    private synchronized int sum() {
        Console.println("test");
        int a = Console.readInt("Enter first int");
        int b = Console.readInt("Enter second int");
        int res = a + b;
        String result = "The result is: " + res;
        Console.println(result);
        return (res);
    }
}