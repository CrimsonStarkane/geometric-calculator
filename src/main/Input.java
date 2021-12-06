package main;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

// A wrapper class which takes care of error handling with user input
public class Input {
    Scanner input = new Scanner(System.in);

    public int nextInt(String prompt) {
        System.out.print(prompt);

        while (true) {
            if (input.hasNextInt())
                return input.nextInt();

            System.out.print("Invalid input! " + prompt);
            input.next();
        }
    }

    public int nextInt(String prompt, String menu, int start, int end) throws InterruptedException, IOException {
        App.cls.start().waitFor();
        System.out.print(menu);
        System.out.print(prompt);

        int num = 0;
        while (true) {
            if (input.hasNextInt()) {
                num = input.nextInt();

                if (num >= start && num <= end)
                    return num;
            }

            App.cls.start().waitFor();
            System.out.print(menu);
            System.out.print("Invalid input! " + prompt);
            input.next();
        }
    }

    public double nextDouble(String prompt) {
        System.out.print(prompt);

        while (true) {
            if (input.hasNextDouble())
                return input.nextDouble();

            System.out.print("Invalid input! " + prompt);
            input.next();
        }
    }

    public double nextDouble(String prompt, String menu, int start, int end) throws InterruptedException, IOException {
        App.cls.start().waitFor();
        System.out.print(menu);
        System.out.print(prompt);

        double num = 0;
        while (true) {
            if (input.hasNextDouble()) {
                num = input.nextDouble();

                if (num >= start && num <= end)
                    return num;
            }

            App.cls.start().waitFor();
            System.out.print(menu);
            System.out.print("Invalid input! " + prompt);
            input.next();
        }
    }

    public BigDecimal nextBigDecimal(String prompt) {
        System.out.print(prompt);

        while (true) {
            if (input.hasNextBigDecimal())
                return input.nextBigDecimal();

            System.out.print("Invalid input! " + prompt);
            input.next();
        }
    }
}
