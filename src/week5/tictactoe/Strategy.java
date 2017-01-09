package week5.tictactoe;

/**
 * Created by jotte on 9-1-17.
 */
public interface Strategy {
    public String getName();

    public int determineMove(Board b, Mark m);
}
