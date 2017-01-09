package week3;

/**
 * Created by jotte on 21-12-16.
 */
public class Multiplication implements OperatorWithIdentity {

    @Override
    public int operate(int left, int right) {
        return left * right;
    }

    @Override
    public int identity() {
        return 1;
    }
}
