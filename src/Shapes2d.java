import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

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
    public static void solve() throws InterruptedException, IOException {

    }
}

class Rectangle {
    private static BigDecimal length;
    private static BigDecimal width;

    private static Runnable[] formulas = {
        () -> App.resultBD = length.add(width).multiply(BigDecimal.valueOf(2)),
        () -> App.resultBD = length.multiply(width),
        () -> App.resultBD = length.pow(2).add(width.pow(2)).sqrt(MathContext.DECIMAL64)
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
        length = Input.nextBigDecimal("Enter length: ");
        width = Input.nextBigDecimal("Enter width: ");

        formulas[unit - 1].run();
        App.printResult("BigDecimal");
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
            base = Input.nextDouble("Enter base: ");
            height = Input.nextDouble("Enter height: ");
            App.resultD = (base * height) / 2;
        },
        () -> {
            area = Input.nextDouble("Enter area: ");
            base = Input.nextDouble("Enter base: ");
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
        formulas[unit - 1].run();

        if (unit == 1) App.printResult("BigDecimal");
        else App.printResult("Double");
    }
}

class Parallelogram {
    public static void solve() throws InterruptedException, IOException {

    }
}

class Trapezium {
    public static void solve() throws InterruptedException, IOException {

    }
}