package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class LinearProduct extends Product implements Function {

    public LinearProduct(Constant f1, Function f2) {
        super(f1, f2);
    }

    public Function derivative() {

        return new LinearProduct((Constant) f1, f2.derivative());
    }

    public Function integrand() {
        Function a = null;
        if (f2 instanceof Integrandable) {
            Integrandable integ = (Integrandable) f2;
            a = new Product(f1, integ.integrand());
        }
        return a;

    }

}

