package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("UTF-8 encoding is not supported on this system.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Clear screen (works on Unix/Win)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Header with ASCII art
            System.out.println("\u001B[36m" + // Cyan color
                "_________                                               ________                        ________   _____  .____    .__  _____       \n" +
                "\\_   ___ \\  ____   ______  _  _______  ___.__. ______  /  _____/_____    _____   ____   \\_____  \\_/ ____\\ |    |   |__|/ ____\\____  \n" +
                "/    \\  \\/ /  _ \\ /    \\ \\/ \\/ /\\__  \\<   |  |/  ___/ /   \\  ___\\__  \\  /     \\_/ __ \\   /   |   \\   __\\  |    |   |  \\   __\\/ __ \\ \n" +
                "\\     \\___(  <_> )   |  \\     /  / __ \\\\___  |\\___ \\  \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  /    |    \\  |    |    |___|  ||  | \\  ___/ \n" +
                " \\______  /\\____/|___|  /\\/\\_/  (____  / ____/____  >  \\______  (____  /__|_|  /\\___  > \\_______  /__|    |_______ \\__||__|  \\___  >\n" +
                "        \\/            \\/             \\/\\/         \\/          \\/     \\/      \\/     \\/          \\/                \\/             \\/ \n" +
                "\u001B[0m");

            System.out.println("\u001B[33mTIP: Press 'ctrl + c' to exit | Enter 'clear' to wipe the terminal\u001B[0m\n");
            System.out.println();
            System.out.println("\u001B[33mIf symbols are not displaying correctly in your terminal, it may be due to the default character encoding.\u001B[0m");
            System.out.println("\u001B[33mTo fix this, run the following command in your terminal before executing the program:\u001B[0m chcp 65001\n");
            System.out.println();
            System.out.println();

            // Menu options with ASCII icons
            System.out.println("\u001B[32m1. 🎲 Random Grid\u001B[0m");


            System.out.println("\u001B[32m2. 🏗️ Predefined State\u001B[0m");

            System.out.println("\u001B[32m3. 🧪 Unit Tests\u001B[0m");

            System.out.println("\u001B[32m4. 🚪 Exit\u001B[0m");

            System.out.print("\n\u001B[35mChoose an option: \u001B[0m");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter grid height: ");
                    int height = sc.nextInt();
                    System.out.print("Enter grid width: ");
                    int width = sc.nextInt();
                    System.out.print("Enter repetitions (negative for infinite): ");
                    int repetitions = sc.nextInt();

                    GridState gridState = new GridState(height, width);
                    gridState.playGame(repetitions);
                    break;

                case 2:
                    System.out.println("\u001B[33mAvailable Patterns:\u001B[0m");
                    System.out.println("  * GosperGliderGun   * AgainstTheGrain");
                    System.out.println("  * WithTheGrain      * c6Spaceship");
                    System.out.println("  * CarnivalShuttle   * DiamondRing");
                    System.out.println("  * Toad              * DinnerTable");
                    System.out.println("  * TimCoeSpaceFiller");

                    System.out.print("\nEnter pattern name: ");
                    String fileName = sc.nextLine();
                    String filePath = "SettedStates/" + fileName + ".txt";
                    System.out.print("Enter repetitions: ");
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
                    System.out.println("\u001B[31m" + 
                        "  ╔════════════╗\n" +
                        "  ║ See you!  ║\n" +
                        "  ╚════════════╝\n" + 
                        "\u001B[0m");
                    break;

                default:
                    System.out.println("\u001B[31mInvalid option!\u001B[0m");
            }
        }
        sc.close();
    }
}