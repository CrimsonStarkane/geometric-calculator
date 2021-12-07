import java.io.IOException;
import java.math.BigDecimal;

class Circle {
    private static double radius;

    private static Runnable[] formulas = {
        () -> App.resultD = Math.PI * Math.pow(radius, 2),
        () -> App.resultD = 2 * Math.PI * radius,
        () -> App.resultD = 2 * radius
    };

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

        if (unit == 0) return;

        App.cls.start().waitFor();
        radius = Input.nextDouble("Enter radius: ");

        formulas[unit - 1].run();
        App.printResult("Double");
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
    }
}

class Triangle {
    private static BigDecimal[] sides = new BigDecimal[3];
    private static double base;
    private static double height;
    private static double area;

    private static Runnable[] formulas = {
        () -> {
            for (int i = 0; i < 3; i++)
                sides[i] = Input.nextBigDecimal("Enter length of side " + (i + 1));

            App.resultBD = BigDecimal.ZERO;
            for (BigDecimal side : sides)
                App.resultBD = side.add(App.resultBD);
        },
        () -> {
            height = Input.nextDouble("Enter height: ");
            App.resultD = (base * height) / 2;
        },
        () -> {
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

        if (unit == 1) App.printResult("BigDecimal");
        else App.printResult("Double");
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
    }
}

class Trapezium {
    public static void solve() throws InterruptedException, IOException {
        
    }
}