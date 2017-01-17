package week6;

/**
 * Created by jotte on 15-1-17.
 */

import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Enter name: ");
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            if (in.hasNextLine()) {
                loop = parseInput(in.nextLine());
            }
        }
        in.close();
    }

    private static boolean parseInput(String input) {
        if (input.equals("")) return false;
        System.out.println("Hello " + input);
        return true;
    }

}