import java.math.BigDecimal;
import java.math.MathContext;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.PI * Math.pow(25, 2));

        BigDecimal pi = new BigDecimal(String.valueOf(Math.PI));
        BigDecimal radius = new BigDecimal("25");

        System.out.println(radius.pow(2, MathContext.DECIMAL32).multiply(pi));
    }
}
