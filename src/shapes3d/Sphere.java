package shapes3d;

import main.App.Function;
import main.App;

import java.io.IOException;
import java.util.Scanner;

public class Sphere implements Function {
    private static double radius;

    public void solve() throws InterruptedException, IOException {
        displayMenu();
        int unit = promptUser();

        if (unit == 0)
            return;
        
        setRadius();

        double result = 0;
        switch (unit) {
            case 1:
                result = solveSurfaceArea();
                break;
            case 2:
                result = solveVolume();
                break;
            case 3:
                result = solveDiameter();
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
            1 - Surface Area
            2 - Volume
            3 - Diameter
            --------------------------
            """
        );
    }

    private static int promptUser() throws InterruptedException, IOException {
        System.out.print("Enter a choice: ");

        int unit = 0;
        while (true) {
            if (App.input.hasNextInt()) {
                unit = App.input.nextInt();

                if (unit >= 0 && unit <= 3) {
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

    private static void setRadius() {
        System.out.print("Enter radius: ");

        while (true) {
            if (App.input.hasNextDouble()) {
                radius = App.input.nextDouble();
                App.input = new Scanner(System.in);
                break;
            }

            App.input = new Scanner(System.in);
            System.out.print("Invalid input! Enter radius: ");
        }
    }

    private static double solveSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    private static double solveVolume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    private static double solveDiameter() {
        return radius * 2;
    }

    private static void printResult(double result) {
        System.out.println("\nThe answer is " + result);
        System.out.print("\nPress enter to continue...");
        App.input.nextLine();
    }
}
