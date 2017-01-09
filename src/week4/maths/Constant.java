package week4.maths;

/**
 * Created by jotte on 22-12-16.
 */
public class Constant implements Function {
    private double constant;

    @Override
    public double apply(double xvalue) {
        return constant;
    }

    public Constant(double constant) {
        this.constant = constant;
    }

    @Override
    public Function derivative() {
        return new Constant(0);

    }

    @Override
    public String toString() {
        return "Constant{" +
                "constant=" + constant +
                '}';
    }
}