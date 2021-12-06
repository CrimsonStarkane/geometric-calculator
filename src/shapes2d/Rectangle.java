package shapes2d;

import main.App;
import main.App.Function;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Rectangle implements Function {
    // Dimensions of shape
    // Length and width is all we need for all formulas
    private static BigDecimal length;
    private static BigDecimal width;

    public void solve() throws InterruptedException, IOException {
        displayMenu();

        // Gets the choice of the user
        System.out.print("Enter a choice: ");
        int unit = App.input.nextInt();
        App.input = new Scanner(System.in); // Clears input buffer

        if (unit == 0)
            return;

        setSides();

        BigDecimal result = BigDecimal.ZERO;
        switch (unit) {
            case 1:
                result = getPerimeter();
                break;
            case 2:
                result = getArea();
                break;
            case 3:
                result = getDiagonal();
        }

        System.out.println("\nThe answer is " + result);
        System.out.print("\nPress enter to continue...");
        App.input.nextLine(); // Pauses the program
    }

    // displayMenu function
    private static void displayMenu() throws InterruptedException, IOException {
        App.cls.start().waitFor(); // Clears the screen

        System.out.print(
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Perimeter
            2 - Area
            3 - Diagonal
            --------------------------
            """
        );
    }

    // Get given units
    private static void setSides() {
        System.out.print("\nEnter length: ");
        length = App.input.nextBigDecimal();
        
        System.out.print("Enter width: ");
        width = App.input.nextBigDecimal();
        App.input = new Scanner(System.in); // Clears input buffer
    }

    // Solve for dimensions
    private static BigDecimal getPerimeter() {
        return length.add(width).multiply(BigDecimal.valueOf(2));
    }

    private static BigDecimal getArea() {
        return length.multiply(width);
    }

    private static BigDecimal getDiagonal() {
        BigDecimal a = length.pow(2).add(width.pow(2));
        return a.sqrt(MathContext.DECIMAL64);
    }
}
