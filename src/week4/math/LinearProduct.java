package week4.math;

/**
 * Created by jotte on 22-12-16.
 */
public class LinearProduct extends Product implements Function {

    private Function f1;
    private Constant cons;

    public LinearProduct(Function f1, Constant c) {
        super(f1, c);
        this.f1 = f1;
        this.cons = c;
    }

    public Function derivative() {
        return new LinearProduct(f1.derivative(), cons);
    }

    public Function integrand() {
        Function a = null;
        if (f1 instanceof Integrandable) {
            Integrandable integ = (Integrandable) f1;
            a = new Product(cons, (Constant) integ.integrand());
        }
        return a;

    }

}

