package week4.maths;

/**
 * Created by jotte on 22-12-16.
 */
public interface Function {
    public double apply(double xvalue);

    public Function derivative();

    public String toString();
}
