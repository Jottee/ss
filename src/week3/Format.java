package week3;

/**
 * Created by jotte on 19-12-16.
 */
public class Format {
    public static void printLine(String text, double amount) {
        System.out.printf("%-10s%10.2f\n", text, amount);
    }

    public static void main(String[] args) {
        printLine("blabla", 3.6);
        printLine("testting", 5);
    }
}
