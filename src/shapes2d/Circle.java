package shapes2d;

import main.App.Function;
import main.App;

import java.io.IOException;
import java.util.Scanner;

public class Circle implements Function {
    private static double radius;

    public void solve() throws InterruptedException, IOException {
        displayMenu();
        int unit = promptUnit();

        if (unit == 0)
            return;

        setRadius();

        double result = 0;
        switch (unit) {
            case 1:
                result = getArea();
                break;
            case 2:
                result = getCircum();
                break;
            case 3:
                result = getDiameter();
        }

        printResult(result);
    }

    private static void displayMenu() throws InterruptedException, IOException {
        App.cls.start().waitFor();

        System.out.print(
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Area
            2 - Circumference
            3 - Diameter
            --------------------------
            """
        );
    }

    private static int promptUnit() throws InterruptedException, IOException {
        System.out.print("Enter a choice: ");

        int unit = 0;
        while (true) {
            if (App.input.hasNextInt()) {
                unit = App.input.nextInt();

                if (unit >= 0 && unit <= 3) {
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
        System.out.print("\nEnter radius: ");

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

    private static double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double getCircum() {
        return 2 * Math.PI * radius;
    }

    private static double getDiameter() {
        return 2 * radius;
    }

    private static void printResult(double result) {
        System.out.println("\nThe answer is " + result);
        System.out.print("\nPress enter to continue...");
        App.input.nextLine();
    }
}
