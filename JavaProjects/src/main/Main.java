package main;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException{
        System.out.println("=== Welcome to JBudgetControl ===");
        menu();
        System.out.println("Program was closed.");
        System.exit(0);
    }

    private static void menu() {
        System.out.println("[====== MENU BEGIN ======]");
        System.out.println("Press '1' for transactions:");
        System.out.println("Press '2' for accounts:");
        System.out.println("Press '3' for categories:");
        System.out.println("Press '4' for user account:");
        System.out.print("Please select an option: ");
        int input;

        Scanner userInput = new Scanner(System.in);
        input = userInput.nextInt();
        userInput.close();
        runOption(input);
        System.out.println("[======= MENU END =======]");
        System.out.println();
    }

    private static void runOption(int select) {
        switch (select) {
            case 1: {
                System.out.println("TransactionManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            case 2: {
                System.out.println("AccountManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            case 3: {
                System.out.println("CategoryManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            case 4: {
                System.out.println("UserManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            default:
                System.out.println("Input failure !");
                break;
        }

    }

}
