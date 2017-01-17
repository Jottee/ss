package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class Product implements Function {
    protected Function f1;
    protected Function f2;

    public Product(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public Function derivative() {
        return new Sum(new Product(f1.derivative(), f2),
                new Product(f2.derivative(), f1));
    }

    public double apply(double argument) {
        return this.f1.apply(argument) * this.f2.apply(argument);
    }

    public String toString() {
        return "(" + f1.toString() + ") * (" + f2.toString() + ")";
    }
}