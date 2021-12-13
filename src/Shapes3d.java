import java.io.IOException;

class Sphere {
    private static double radius;

    private static final Runnable[] formulas = {
        () -> App.resultD = 4 * Math.PI * Math.pow(radius, 2),
        () -> App.resultD = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3),
        () -> App.resultD = 2 * radius
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
                """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Surface Area
            2 - Volume
            3 - Diameter
            --------------------------
            """,
                3
        );

        if (unit == 0) return;

        App.clearConsole();
        radius = Input.nextDouble("Enter radius: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Cube {
    private static double edge;
    private static double volume;

    private static final Runnable[] formulas = {
        () -> App.resultD = 6 * Math.pow(edge, 2),
        () -> App.resultD = Math.pow(edge, 3),
        () -> App.resultD = edge * Math.sqrt(3),
        () -> App.resultD = Math.pow(volume, 1.0 / 3.0)
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
                """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Surface Area
            2 - Volume
            3 - Space Diagonal
            4 - Edge
            --------------------------
            """,
                4
        );

        if (unit == 0) return;

        App.clearConsole();
        if (unit <= 3) edge = Input.nextDouble("Enter edge: ");
        else volume = Input.nextDouble("Enter volume: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Cuboid {
    private static double length;
    private static double breadth;
    private static double height;

    private static final Runnable[] formulas = {
        () -> App.resultD = 2 * (length * breadth + breadth * height + height * length),
        () -> App.resultD = length * breadth * length,
        () -> App.resultD = Math.sqrt(Math.pow(length, 2) + Math.pow(breadth, 2) + Math.pow(height, 2))
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
                """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Surface Area
            2 - Volume
            3 - Space Diagonal
            --------------------------
            """,
                3
        );

        if (unit == 0) return;

        App.clearConsole();
        length = Input.nextDouble("Enter length: ");
        breadth = Input.nextDouble("Enter breadth: ");
        height = Input.nextDouble("Enter height: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Cone {
    private static double slantHeight;
    private static double radius;
    private static double height;

    private static final Runnable[] formulas = {
        () -> App.resultD = Math.PI * radius * (radius + slantHeight),
        () -> App.resultD = Math.PI * radius * slantHeight,
        () -> App.resultD = (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height,
        () -> App.resultD = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)),
        () -> App.resultD = Math.PI * Math.pow(radius, 2)
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
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
            """,
                5
        );

        if (unit == 0) return;

        App.clearConsole();
        radius = Input.nextDouble("Enter radius: ");
        if (unit <= 2) slantHeight = Input.nextDouble("Enter slant height: ");
        else if (unit == 3 || unit == 4) height = Input.nextDouble("Enter height: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}

class Cylinder {
    private static double radius;
    private static double height;
    private static double volume;

    private static final Runnable[] formulas = {
        () -> App.resultD = 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2),
        () -> App.resultD = 2 * Math.PI * radius * height,
        () -> App.resultD = Math.PI * Math.pow(radius, 2) * height,
        () -> App.resultD = Math.PI * Math.pow(radius, 2),
        () -> App.resultD = Math.sqrt(volume / (Math.PI * height))
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
                """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Total Surface Area
            2 - Curved Surface Area
            3 - Volume
            4 - Base Area
            5 - Radius
            --------------------------
            """,
                5
        );

        if (unit == 0) return;

        App.clearConsole();
        if (unit == 5) volume = Input.nextDouble("Enter volume: ");
        else radius = Input.nextDouble("Enter radius: ");
        if (unit != 4) height = Input.nextDouble("Enter height: ");

        formulas[unit - 1].run();
        App.printResult("Double");
        solve();
    }
}