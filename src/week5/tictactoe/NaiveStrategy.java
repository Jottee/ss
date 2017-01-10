package week5.tictactoe;

import java.util.LinkedList;

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
        LinkedList<Integer> emptyFields = new LinkedList<Integer>();
        for (int i = 0; i < b.DIM * b.DIM; i++) {
            if (b.isEmptyField(i)) {
                emptyFields.add(i);
            }
        }
        int r = (int) (Math.random()) * emptyFields.size();
        return emptyFields.get(r);
    }
}