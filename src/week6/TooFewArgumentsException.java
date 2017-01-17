package week6;

/**
 * Created by jotte on 16-1-17.
 */
public class TooFewArgumentsException extends WrongArgumentException {

    public TooFewArgumentsException() {
        super("error: must pass two arguments in command line");
    }
}
