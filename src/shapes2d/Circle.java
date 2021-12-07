package shapes2d;

import main.App;
import main.App.FormulaD;

import java.io.IOException;

public class Circle {
    private static double radius;

    private static FormulaD[] formulas = {
        () -> Math.PI * Math.pow(radius, 2),
        () -> 2 * Math.PI * radius,
        () -> 2 * radius
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = App.scan.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Area
            2 - Circumference
            3 - Diameter
            --------------------------
            """,
            0, 3
        );

        if (unit == 0) return;

        radius = App.scan.nextDouble("Enter radius: ");
        double result = formulas[unit - 1].calculate();

        System.out.println("\nThe answer is " + result);
        System.out.print("\nPress enter to continue...");
        App.input.nextLine();
    }
}
