package week4.math;

/**
 * Created by jotte on 10-1-17.
 */
public class Homework {
    public static void main(String[] args) {
        LinearProduct f1 = new LinearProduct(new Constant(4), new Exponent(4));
        Function f2 = f1.integrand();
        Function f3 = f1.derivative();
        System.out.println("f(x) = " + f1.toString() + ", f(8) = " + f1.apply(8));
        System.out.println("f(x) = " + f1.toString() + ", F(x) = " + f2.toString());
        System.out.println("f(x) = " + f1.toString() + ", f'x() = " + f3.toString());

    }

}
