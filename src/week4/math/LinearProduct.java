package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class LinearProduct implements Function {
    private Function fun1;
    private Function fun2;

    public LinearProduct(Function f1, Function f2) {
        fun1 = f1;
        fun2 = f2;
    }

    @Override
    public double apply(double xvalue) {
        return fun1.apply(xvalue) * fun2.apply(xvalue);
    }

    @Override
    public Function derivative() {
        return new Product(fun1.derivative(), fun2.derivative());
    }

    @Override
    public String toString() {
        return "LinearProduct{" +
                "fun1=" + fun1 +
                ", fun2=" + fun2 +
                '}';
    }
}

