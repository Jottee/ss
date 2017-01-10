package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class Exponent implements Function {
    private int exponent;

    public Exponent(int x) {
        this.exponent = x;
    }

    @Override
    public Function derivative() {
        if (this.exponent == 1) {
            return new Constant(this.exponent);
        }
        return new LinearProduct(new Exponent(exponent - 1), new Constant(exponent));
    }

    @Override
    public double apply(double xvalue) {
        return Math.pow(xvalue, this.exponent);
    }

}
