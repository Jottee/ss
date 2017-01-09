package week4.maths;

/**
 * Created by jotte on 22-12-16.
 */
public class Product implements Function {
    private Function func1;
    private Function func2;

    public Product(Function f1, Function f2) {
        func1 = f1;
        func2 = f2;
    }

    @Override
    public double apply(double xvalue) {
        return func1.apply(xvalue) * func2.apply(xvalue);
    }

    @Override
    public Function derivative() {
        return new Product(func1.derivative(), func2.derivative());
    }

    @Override
    public String toString() {
        return "Product{" +
                "func1=" + func1 +
                ", func2=" + func2 +
                '}';
    }
}