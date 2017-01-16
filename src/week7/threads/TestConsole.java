package week7.threads;
/**
 * Created by jelle on 16/01/2017.
 */
public class TestConsole extends Thread {
    public static void main(String[] args) {
        TestConsole inst1 = new TestConsole();
        TestConsole inst2 = new TestConsole();
        inst1.start();
        inst2.start();
    }

    @Override
    public void run() {
        sum();
    }

    private int sum() {
        Console.println("test");
        int a = Console.readInt("Enter first int");
        int b = Console.readInt("Enter second int");
        int res = a + b;
        String result = "The result is: " + res;
        Console.println(result);
        return (res);
    }
}
