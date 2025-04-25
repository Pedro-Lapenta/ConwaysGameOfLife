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
        boolean exit = false;

        while (!exit) {
            System.out.println("=============================");
            System.out.println("=== Conway's Game of Life ===");
            System.out.println("=============================");
            
            System.out.println("\u001B[32mTIP: Press 'ctrl + c' to exit the program and clear (or cls) to clear the terminal\u001B[0m");
            System.out.println();

            System.out.println("1. Run game with random grid");
            System.out.println("2. Run game with predefined state");
            System.out.println("3. Run unit tests");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter grid height: ");
                    int height = sc.nextInt();
                    System.out.print("Enter grid width: ");
                    int width = sc.nextInt();
                    System.out.println("Enter number of repetitions (negative int to run indefinitely): ");
                    int repetitions = sc.nextInt();

                    GridState gridState = new GridState(height, width);
                    gridState.playGame(repetitions);
                    break;

                case 2:

                    System.out.println("Default Pre-loaded Options: ");
                    System.out.println("GosperGliderGun");
                    System.out.println("AgainstTheGrain");
                    System.out.println("WithTheGrain");
                    System.out.println("c6Spaceship");
                    System.out.println("CarnivalShuttle");
                    System.out.println("DiamondRing");
                    System.out.println("Toad");
                    System.out.println("DinnerTable");
                    System.out.println("TimCoeSpaceFiller");

                    System.out.println("Enter the file name for the predefined state: ");
                    String fileName = sc.nextLine();

                    String filePath = "SettedStates/" + fileName + ".txt";
                    System.out.println("Enter number of repetitions (negative int to run indefinitely): ");
                    repetitions = sc.nextInt();

                    SettedState settedState = new SettedState(filePath);
                    settedState.playGame(repetitions);
                    break;

                case 3:
                    UnitTesting unitTesting = new UnitTesting();
                    unitTesting.unitTests();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}