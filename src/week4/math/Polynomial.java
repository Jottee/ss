package week4.math;

/**
 * Created by jotte on 10-1-17.
 */
public class Polynomial implements Function {
    public LinearProduct[] linProd;

    public Polynomial(double[] values) {
        linProd = new LinearProduct[values.length];
        for (int i = 0; i < values.length; i++) {
            linProd[i] = new LinearProduct(new Constant(i + 2), new Exponent((int) values[i]));
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
        Function f = null;
        for (int i = 0; i < linProd.length; i++) {
            if (f == null) {
                f = linProd[i].derivative();
            } else {
                f = new Sum(f, linProd[i].derivative());
            }
        }
        return f;
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
        Function a = null;
        for (int i = 0; i < linProd.length; i++) {
            if (a == null) {
                a = linProd[i].integrand();
            } else {
                a = new Sum(linProd[i].integrand(), a);
            }

        }
        return a;
    }
}
