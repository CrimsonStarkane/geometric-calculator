import java.io.IOException;

class Sphere {
    private static double radius;

    private static Runnable[] formulas = {
        () -> App.resultD = 4 * Math.PI * Math.pow(radius, 2),
        () -> App.resultD = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3),
        () -> App.resultD = 2 * radius
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
            """
            What are you solving for?
            --------------------------
            0 - Back to Main Menu
            1 - Surface Area
            2 - Volume
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

class Cube {
    private static double edge;
    private static double volume;

    private static Runnable[] formulas = {
        () -> App.resultD = 6 * Math.pow(edge, 2),
        () -> App.resultD = Math.pow(edge, 3),
        () -> App.resultD = edge * Math.sqrt(3),
        () -> App.resultD = Math.pow(volume, 1.0 / 3.0)
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
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
            0, 4
        );

        if (unit == 0) return;

        App.cls.start().waitFor();
        if (unit <= 3) edge = Input.nextDouble("Enter edge: ");
        else volume = Input.nextDouble("Enter volume: ");

        formulas[unit - 1].run();
        App.printResult("Double");
    }
}

class Cuboid {
    public static void solve() throws InterruptedException, IOException {

    }
}

class Cone {
    private static double slantHeight;
    private static double radius;
    private static double height;

    private static Runnable[] formulas = {
        () -> App.resultD = Math.PI * radius * (radius + slantHeight),
        () -> App.resultD = Math.PI * radius * slantHeight,
        () -> App.resultD = (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height,
        () -> App.resultD = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)),
        () -> App.resultD = Math.PI * Math.pow(radius, 2)
    };

    public static void solve() throws InterruptedException, IOException {
        int unit = Input.nextInt(
            "Enter a choice: ",
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
            0, 5
        );

        if (unit == 0) return;

        App.cls.start().waitFor();
        radius = Input.nextDouble("Enter radius: ");
        if (unit <= 2) slantHeight = Input.nextDouble("Enter slant height: ");
        else if (unit == 3 || unit == 4) height = Input.nextDouble("Enter height: ");

        formulas[unit - 1].run();
        App.printResult("Double");
    }
}

class Cylinder {
    public static void solve() throws InterruptedException, IOException {

    }
}