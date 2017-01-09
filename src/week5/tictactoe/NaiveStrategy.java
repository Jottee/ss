package week5.tictactoe;

/**
 * Created by jotte on 9-1-17.
 */
public class NaiveStrategy implements Strategy {

    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public int determineMove(Board b, Mark m) {
        return 0;
    }
}
