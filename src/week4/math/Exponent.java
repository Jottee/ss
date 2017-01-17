package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class Exponent implements Function, Integrandable {
    private int exponent;

    public Exponent(int x) {
        this.exponent = x;
    }

    @Override
    public Function derivative() {
        if (this.exponent == 1) {
            return new Constant(this.exponent);
        }
        return new LinearProduct(new Constant(exponent), new Exponent(exponent - 1));
    }

    @Override
    public double apply(double xvalue) {
        return Math.pow(xvalue, this.exponent);
    }

    @Override
    public LinearProduct integrand() {
        double d = 1.0 / (exponent * 1.0 + 1.0);
        return new LinearProduct(new Constant(d), new Exponent(exponent + 1));
    }

    @Override
    public String toString() {
        return "Exponent{" +
                "exponent=" + exponent +
                '}';
    }
}

