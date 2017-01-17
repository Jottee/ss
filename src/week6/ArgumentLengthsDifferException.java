package week6;

/**
 * Created by jotte on 16-1-17.
 */
public class ArgumentLengthsDifferException extends WrongArgumentException {
    public ArgumentLengthsDifferException(int i1, int i2) {
        super("error: Length of strings differ, " + i1 + " and " + i2);
    }
}
