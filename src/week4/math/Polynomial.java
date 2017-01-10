package week4.math;

/**
 * Created by jotte on 10-1-17.
 */
public class Polynomial implements Function {
    private LinearProduct[] linProd;

    public Polynomial(double[] values) {
        linProd = new LinearProduct[values.length];
        for (int i = 0; i < values.length; i++) {
            linProd[i] = new LinearProduct(new Exponent((int) values[i]), new Constant(i + 2));
        }
    }


    @Override
    public double apply(double xvalue) {
        double ans = 0;
        for (int i = 0; i < linProd.length; i++) {
            ans += (linProd[i]).apply(xvalue);
        }
        return ans;
    }


    @Override
    public Function derivative() {
        Function a = new Constant(0);
        for (int i = 0; i < linProd.length; i++) {
            a = new Sum(a, linProd[i].derivative());
        }
        return a;
    }

    @Override
    public String toString() {
        String a = "";
        for (int i = 0; i < linProd.length; i++) {
            a = a + " " + linProd[i].toString();
            if (i + 1 != linProd.length) {
                a = a + " +";
            }
        }
        return a;
    }

    public Function integrand() {
        Function a = new Constant(0);
        for (int i = 0; i < linProd.length; i++) {
            a = new Sum(linProd[i].integrand(), a);
        }
        return a;
    }
}
