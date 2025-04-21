package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    // Set the standard output to use UTF-8 encoding to properly display special characters
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("UTF-8 encoding is not supported on this system.");
            return; // Exit the program if UTF-8 is not supported
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Height: ");
        int height = sc.nextInt();
        System.out.println("Width: ");
        int width = sc.nextInt();
        GridState gridState = new GridState(height, width);

        // RUN THE GAME
        gridState.playGame(1); // the loop will never reach a positive number


        sc.close();
    }
}
