import java.io.IOException;
import java.math.BigDecimal;

class Circle {
    // Declare shape dimensions
    private static double radius;

    // Stores the formulas in an array
    private static Runnable[] formulas = {
        () -> App.resultD = Math.PI * Math.pow(radius, 2),
        () -> App.resultD = 2 * Math.PI * radius,
        () -> App.resultD = 2 * radius
    };

    // The exception classes handles the exceptions of the ProcessBuilder
    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
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

        if (unit == 0) return; // Return to main menu if user enters 0

        // Enter the dimensions needed for calculation
        App.cls.start().waitFor();
        radius = Input.nextDouble("Enter radius: ");
        
        formulas[unit - 1].run();   // Execute the chosen formula
        App.printResult("Double");  // Print the result of type double
        solve(); // Execute the function again after printing the result
    }
}

class Square {
    private static double side;
    private static double area;

    private static Runnable[] formulas = {
        () -> App.resultD = 4 * side,
        () -> App.resultD = Math.pow(side, 2),
        () -> App.resultD = side * Math.sqrt(2),
        () -> App.resultD = Math.sqrt(area)
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Perimeter
            2 - Area
            3 - Diagonal
            4 - Side
            --------------------------
            """,
            0, 4
        );

        if (unit == 0) return;

        App.cls.start().waitFor();
        if (unit == 4) area = Input.nextDouble("Enter area: ");
        else side = Input.nextDouble("Enter side length: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Rectangle {
    private static double length;
    private static double width;

    private static Runnable[] formulas = {
        () -> App.resultD = (length + width) * 2,
        () -> App.resultD = length * width,
        () -> App.resultD = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2))
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Perimeter
            2 - Area
            3 - Diagonal
            --------------------------
            """,
            0, 3
        );

        if (unit == 0) return;

        App.cls.start().waitFor();
        length = Input.nextDouble("Enter length: ");
        width = Input.nextDouble("Enter width: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Triangle {
    // BigDecimal is used to ensure accurate representation of floating-point value after performing arithmetic
    private static BigDecimal[] sides = new BigDecimal[3];

    // The rest remain of type double to optimize code
    private static double base;
    private static double height;
    private static double area;

    private static Runnable[] formulas = {
        () -> {
            // Prompts the user for input 3 times and stores it in array 'sides'
            for (int i = 0; i < 3; i++)
                sides[i] = Input.nextBigDecimal("Enter length of side " + (i + 1) + ": ");

            // Calculates the sum of all the sides in order to get the PERIMETER
            App.resultBD = BigDecimal.ZERO;
            for (BigDecimal side : sides)
                App.resultBD = side.add(App.resultBD);
        },
        () -> {
            // Calculates the AREA
            height = Input.nextDouble("Enter height: ");
            App.resultD = (base * height) / 2;
        },
        () -> {
            // Calculates the HEIGHT
            area = Input.nextDouble("Enter area: ");
            App.resultD = (area / base) * 2;
        }
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
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

        App.cls.start().waitFor();
        if (unit >= 2) base = Input.nextDouble("Enter base: ");
        
        formulas[unit - 1].run();
        
        // If user chose to solve perimeter, then the result will be a BigDecimal
        if (unit == 1) App.printResult("BigDecimal");
        else App.printResult("Double");
        solve();
    }
}

class Parallelogram {
    private static double sides;
    private static double base;
    private static double height;
    private static double area;

    private static Runnable[] formulas = {
        () -> {
            sides = Input.nextDouble("Enter side length: ");
            App.resultD = 2 * (sides + base);
        },
        () -> App.resultD = base * height,
        () -> App.resultD = area / base,
        () -> App.resultD = area / height
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Perimeter
            2 - Area
            3 - Height
            4 - Base
            --------------------------
            """,
            0, 4
        );

        if (unit == 0) return;

        App.cls.start().waitFor();
        if (unit <= 3) base = Input.nextDouble("Enter base length: ");
        if (unit >= 3) area = Input.nextDouble("Enter area: ");
        if (unit == 2 || unit == 4) height = Input.nextDouble("Enter height: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Trapezium {
    private static double baseTop;
    private static double baseBot;
    private static double height;
    private static double area;

    private static Runnable[] formulas = {
        () -> App.resultD = (baseTop + baseBot) / 2 * height,
        () -> App.resultD = 2 * area / (baseTop + baseBot),
        () -> App.resultD = 2 * area / height - baseTop
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Area
            2 - Height
            3 - Bottom Base
            --------------------------
            """,
            0, 3
        );

        if (unit == 0) return;

        App.cls.start().waitFor();
        baseTop = Input.nextDouble("Enter top base: ");
        if (unit <= 2) baseBot = Input.nextDouble("Enter bottom base: ");
        if (unit == 1 || unit == 3) height = Input.nextDouble("Enter height: ");
        if (unit >= 2) area = Input.nextDouble("Enter area: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}