package main;

import shapes2d.*;
import shapes3d.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static ProcessBuilder cls = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
    public static Scanner input = new Scanner(System.in);
    public static Input scan = new Input();

    public interface Function {
        public void solve() throws InterruptedException, IOException;
    }

    public interface FormulaD {
        public double calculate();
    }

    public interface FormulaBD {
        public BigDecimal calculate();
    }

    public static void main(String[] args) throws Exception {
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
            int shape = scan.nextInt(
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

            if (shape == 0)
                break;

            shapes[shape - 1].invoke(null);
        }
    }
}