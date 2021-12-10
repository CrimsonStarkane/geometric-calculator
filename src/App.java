import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class App {
    // Used for clearing the screen of the terminal
    public static ProcessBuilder cls = new ProcessBuilder("cmd", "/c", "cls").inheritIO();

    // We used 2 result variables to accomodate for both possible data types and for optimization purposes
    public static double resultD;
    public static BigDecimal resultBD;

    public static void main(String[] args) throws Exception {
        // Array that stores all the methods to be called from each shape class
        Method[] shapes = {
            Circle.class.getMethod("solve"), Square.class.getMethod("solve"),
            Rectangle.class.getMethod("solve"), Triangle.class.getMethod("solve"),
            Parallelogram.class.getMethod("solve"), Trapezium.class.getMethod("solve"),
            Sphere.class.getMethod("solve"), Cube.class.getMethod("solve"),
            Cuboid.class.getMethod("solve"), Cone.class.getMethod("solve"),
            Cylinder.class.getMethod("solve")
        };

        // Main loop (program flow)
        while (true) {
            // Prompt the user
            int shape = Input.nextInt(
                "Enter a choice: ",
                """
                            Pick a shape
                ------------------------------------
                  2D Shapes            3D Shapes
                ------------------------------------
                1 - Circle           7  - Sphere
                2 - Square           8  - Cube
                3 - Rectangle        9  - Cuboid
                4 - Triangle         10 - Cone
                5 - Parallelogram    11 - Cylinder
                6 - Trapezium
                          0 - Exit Program
                ------------------------------------
                """,
                0, 11
            );

            if (shape == 0) break;

            // Invoke or call the method of the chosen shape
            shapes[shape - 1].invoke(null);
        }
    }

    public static void printResult(String type) throws InterruptedException, IOException {
        cls.start().waitFor(); // We use the 'cls' object from earlier to clear the console screen

        System.out.println("The answer is " + (type == "Double" ? resultD : resultBD));
        System.out.print("\nPress enter to continue...");
        
        Input.nextLine(); // Pauses the program until the user hits enter
    }
}