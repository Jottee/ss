package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class Sum implements Function {
    public Function fun1;
    public Function fun2;

    public Sum(Function f1, Function f2) {
        this.fun1 = f1;
        this.fun2 = f2;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "fun1=" + fun1 +
                ", fun2=" + fun2 +
                '}';
    }

    public double apply(double xvalue) {
        return fun1.apply(xvalue) + fun2.apply(xvalue);
    }

    public Function derivative() {
        return new Sum(fun1.derivative(), fun2.derivative());
    }
}