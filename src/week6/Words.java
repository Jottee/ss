package week6;

/**
 * Created by jotte on 15-1-17.
 */

import java.util.Scanner;

public class Words {

    public static void main(String[] args) {
        newLine();
        boolean breaksecond = false;
        Scanner in = new Scanner(System.in);
        Scanner nextLine;
        while ((nextLine = new Scanner(in.nextLine())) != null) {
            String word;
            int count = 0;
            while (nextLine.hasNext()) {
                word = nextLine.next();
                if (word.equals("end") && count == 0) {
                    System.out.println("End of programme.");
                    breaksecond = true;
                }
                System.out.println("Word " + (count++) + ": " + word);
            }
            nextLine.close();
            if (breaksecond) break;
            newLine();
        }
        in.close();
    }

    private static void newLine() {
        System.out.println("Line (or \"end\"): ");
    }

}