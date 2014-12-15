package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import settings.VariablesConst;

public class Main {
    private static VariablesConst VariablesConst;

    public static void main(String[] args) throws SQLException {
        VariablesConst = new VariablesConst();

        System.out.println("=== Welcome to JBudgetControl ===");
        paramAnalyse(args);
        ArrayList<String> options = new ArrayList<String>();
        options.add("transactions:");
        if (VariablesConst.isoAccount())
            options.add("accounts:");
        if (VariablesConst.isoCategory())
            options.add("categories:");
        if (VariablesConst.isoUser())
            options.add("user account:");
        runMainOption(MenuCreator(options));
        System.out.println("Program was closed.");
        System.exit(0);
    }

    private static int MenuCreator(ArrayList<String> options) {
        System.out.println("[====== MENU BEGIN ======]");
        for (int i = 0; i < options.size(); i++) {
            System.out.println("Press '" + i + "' for " + options.get(i));
        }
        System.out.print("Please select an option:");
        int input;

        Scanner userInput = new Scanner(System.in);
        input = userInput.nextInt();
        userInput.reset();

        System.out.println("[======= MENU END =======]");
        System.out.println();
        return input;
    }

    // Functions in main menu
    private static void runMainOption(int select) {
        switch (select) {
            case 0: {
                System.out.println("TransactionManager was selected");
                ArrayList<String> options = new ArrayList<String>();
                options.add("show");
                if (VariablesConst.isoWrite()) {
                    if (VariablesConst.isoTaInsert())
                        options.add("insertion");
                    if (VariablesConst.isoTaMod())
                        options.add("modification");
                    if (VariablesConst.isoTaDel())
                        options.add("delete");
                }
                runTaOption(MenuCreator(options));
                break;
            }
            case 1: {
                System.out.println("AccountManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            case 2: {
                System.out.println("CategoryManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            case 3: {
                System.out.println("UserManager was selected");
                System.err.println("Sorry this option was not implemented!");
                break;
            }
            default: {
                System.out.println("Input failure !");
                break;
            }
        }
    }

    // Functions in transactions menu
    private static void runTaOption(int select) {
        switch (select) {
            case 0: {
                System.out.println("Viewmodus was selected");
                break;
            }
            case 1: {
                System.out.println("Insertion was selected");
                break;
            }
            case 2: {
                System.out.println("Modification was selected");
                break;
            }
            case 3: {
                System.out.println("Delete was selected");
                break;
            }
            default: {
                System.out.println("Input failure !");
                break;
            }
        }
    }

    // set the options for task2
    private static void paramAnalyse(String[] args) {
        if (args.length != 0) {
            switch (args[0].charAt(0)) {
                case '0': {
                    System.out.println("Version 'normal'");
                    VariablesConst.setoTaMod(false);
                    VariablesConst.setoTaDel(false);
                    break;
                }
                case '1': {
                    System.out.println("Version 'gold'");
                    VariablesConst.setoTaMod(true);

                    VariablesConst.setoAccount(true);
                    VariablesConst.setoAtMod(true);

                    VariablesConst.setoCategory(true);
                    VariablesConst.setoCyMod(true);
                    break;
                }
                case '2': {
                    System.out.println("Version 'platinum'");
                    VariablesConst.setoTaMod(true);
                    VariablesConst.setoTaDel(true);

                    VariablesConst.setoAccount(true);
                    VariablesConst.setoAtMod(true);
                    VariablesConst.setoAtDel(true);

                    VariablesConst.setoCategory(true);
                    VariablesConst.setoCyMod(true);
                    VariablesConst.setoCyDel(true);
                    break;
                }
                default: {
                    System.err.print("Invalid parameter input!");
                    System.exit(1);
                }
            }
            if (args.length > 1) {
                switch (args[1].charAt(0)) {
                    case 'r': {
                        VariablesConst.setoRead(true);
                        VariablesConst.setoWrite(false);
                    }
                    case 'w': {
                        VariablesConst.setoRead(true);
                        VariablesConst.setoWrite(true);
                    }
                    default: {
                        VariablesConst.setoRead(true);
                        VariablesConst.setoWrite(false);
                    }
                }
            }
        }
    }
}
