package shapes3d;

import main.App;
import main.App.Function;

import java.io.IOException;
import java.util.Scanner;

public class Cone implements Function {
    // Dimensions of shape
    private static double radius;
    private static double height;
    private static double slantHeight;

    public void solve() throws InterruptedException, IOException {
        displayMenu();
        int unit = promptUser();

        if (unit == 0)
            return;

        double result = 0;
        switch (unit) {
            case 1:
                result = solveTSA();
                break;
            case 2:
                result = solveCSA();
                break;
            case 3:
                result = solveVolume();
                break;
            case 4:
                result = solveSlantHeight();
                break;
            case 5:
                result = solveBaseArea();
        }

        printResult(result);
    }

    // displayMenu function
    private static void displayMenu() throws InterruptedException, IOException {
        App.cls.start().waitFor();

        System.out.print(
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Total Surface Area
            2 - Curved Surface Area
            3 - Volume
            4 - Slant Height
            5 - Base Area
            --------------------------
            """
        );
    }

    // Prompt the user for input
    private static int promptUser() throws InterruptedException, IOException {
        System.out.print("Enter a choice: ");

        int unit = 0;
        while (true) {
            if (App.input.hasNextInt()) {
                unit = App.input.nextInt();

                if (unit >= 0 && unit <= 5) {
                    System.out.println();
                    App.input = new Scanner(System.in);
                    break;
                }
            }

            App.input = new Scanner(System.in);
            displayMenu();
            System.out.print("Invalid input! Enter valid choice: ");
        }

        return unit;
    }

    // Set given units

    private static void setSlantHeight() {
        String prompt = "Enter slant height: ";
        System.out.print(prompt);
        slantHeight = getUserInput(prompt);
    }

    private static void setHeight() {
        String prompt = "Enter height: ";
        System.out.print(prompt);
        height = getUserInput(prompt);
    }

    private static void setRadius() {
        String prompt = "Enter base radius: ";
        System.out.print(prompt);
        radius = getUserInput(prompt);
    }

    private static double getUserInput(String prompt) {
        double value = 0;
        while (true) {
            if (App.input.hasNextDouble()) {
                value = App.input.nextDouble();
                App.input = new Scanner(System.in);
                break;
            }

            App.input = new Scanner(System.in);
            System.out.print("Invalid input! " + prompt);
        }

        return value;
    }

    // Solve for dimensions

    private static double solveTSA() {
        setRadius();
        int unit = getUnitType();

        double result = 0;
        switch (unit) {
            case 1:
                setSlantHeight();
                result = Math.PI * radius * (radius + slantHeight);
                break;
            case 2:
                setHeight();
                slantHeight = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
                result = Math.PI * radius * (radius + slantHeight);
        }

        return result;
    }

    private static double solveCSA() {
        setRadius();
        int unit = getUnitType();
        
        double result = 0;
        switch (unit) {
            case 1:
                setSlantHeight();
                result = Math.PI * radius * slantHeight;
                break;
            case 2:
                setHeight();
                slantHeight = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
                result = Math.PI * radius * slantHeight;
        }

        return result;
    }

    private static double solveVolume() {
        setRadius();
        setHeight();
        return Math.PI * Math.pow(radius, 2) * (height / 3);
    }

    private static double solveSlantHeight() {
        setRadius();
        setHeight();
        return Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
    }

    private static double solveBaseArea() {
        setRadius();
        return Math.PI * Math.pow(radius, 2);
    }

    private static int getUnitType() {
        System.out.println();
        System.out.print(
            """
            Enter one of the values below
            ------------------------------
            1 - Slant Height
            2 - Height
            ------------------------------
            """
        );

        int unit = 0;
        while (true) {
            if (App.input.hasNextInt()) {
                unit = App.input.nextInt();

                if (unit == 1 || unit == 2) {
                    System.out.println();
                    App.input = new Scanner(System.in);
                    break;
                }
            }

            App.input = new Scanner(System.in);
            System.out.print("Invalid input! Enter valid choice: ");
        }

        return unit;
    }

    // Print result
    private static void printResult(double result) {
        System.out.println("\nThe answer is " + result);
        System.out.print("\nPress enter to continue...");
        App.input.nextLine();
    }
}
