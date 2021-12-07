package shapes2d;

import main.App.FormulaBD;
import main.App;

import java.io.IOException;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;

public class Triangle {
    private static BigDecimal[] sides = new BigDecimal[3];
    private static BigDecimal base;
    private static BigDecimal height;
    private static BigDecimal area;

    public static void solve() throws InterruptedException, IOException {
        int unit = App.scan.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Perimeter
            2 - Area
            3 - Height
            --------------------------
            """,
            0, 3
        );

        if (unit == 0) return;

        // if (unit == 1)
        //     formulas[0].calculate();

        BigDecimal result = BigDecimal.ZERO;
        switch (unit) {
            case 1:
                setSides();
                result = getPerimeter();
                break;
            case 2:
                setBase();
                setHeight();
                result = getArea();
                break;
            case 3:
                setArea();
                setBase();
                result = getHeight();
        }

        printResult(result);
    }

    // Setter functions
    private static void setSides() {
        String[] order = {"1st", "2nd", "3rd"};

        for (int i = 0; i < 3; i++) {
            String prompt = String.format("Enter length of %s side: ", order[i]);
            System.out.print(prompt);
            sides[i] = getUserInput(prompt);
        }
    }

    private static void setBase() {
        String prompt = "Enter base length: ";
        System.out.print(prompt);
        base = getUserInput(prompt);
    }

    private static void setHeight() {
        String prompt = "Enter height: ";
        System.out.print(prompt);
        height = getUserInput(prompt);
    }

    private static void setArea() {
        String prompt = "Enter area: ";
        System.out.print(prompt);
        area = getUserInput(prompt);
    }

    private static BigDecimal getUserInput(String prompt) {
        BigDecimal value = BigDecimal.ZERO;

        while (true) {
            if (App.input.hasNextBigDecimal()) { // Check if the user inputted an integer
                value = App.input.nextBigDecimal();
                App.input = new Scanner(System.in); // Clear the buffer
                break;
            }

            App.input = new Scanner(System.in);
            System.out.print("Invalid input! " + prompt);
        }

        return value;
    }

    // Solve for dimensions
    private static BigDecimal getPerimeter() {
        BigDecimal sum = BigDecimal.ZERO;

        for (BigDecimal side : sides)
            sum = side.add(sum);

        return sum;
    }

    private static BigDecimal getArea() {
        return base.multiply(height).divide(BigDecimal.valueOf(2));
    }

    private static BigDecimal getHeight() {
        return area.divide(base, MathContext.DECIMAL64).multiply(BigDecimal.valueOf(2));
    }

    private static void printResult(BigDecimal result) {
        System.out.println("\nThe answer is " + result);
        System.out.print("\nPress enter to continue...");
        App.input.nextLine();
    }
}
