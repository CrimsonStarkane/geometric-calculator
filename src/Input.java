import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

// A wrapper class which takes care of user input handling
public class Input {
    static Scanner input = new Scanner(System.in);

    static int nextInt(String prompt, String menu, int start, int end) throws InterruptedException, IOException {
        App.cls.start().waitFor();
        System.out.print(menu);
        System.out.print(prompt);

        int num = 0;
        while (true) {
            if (input.hasNextInt()) {
                num = input.nextInt();

                if (num >= start && num <= end) {
                    input = new Scanner(System.in);
                    return num;
                }
            }

            App.cls.start().waitFor();
            System.out.print(menu);
            System.out.print("Invalid input! " + prompt);
            input = new Scanner(System.in);
        }
    }

    static double nextDouble(String prompt) {
        System.out.print(prompt);

        while (true) {
            if (input.hasNextDouble()) {
                double num = input.nextDouble();
                input = new Scanner(System.in);
                return num;
            }

            System.out.print("Invalid input! " + prompt);
            input = new Scanner(System.in);
        }
    }

    static BigDecimal nextBigDecimal(String prompt) {
        System.out.print(prompt);

        while (true) {
            if (input.hasNextBigDecimal()) {
                BigDecimal num = input.nextBigDecimal();
                input = new Scanner(System.in);
                return num;
            }

            System.out.print("Invalid input! " + prompt);
            input = new Scanner(System.in);
        }
    }

    static void nextLine() {
        input.nextLine();
    }
}