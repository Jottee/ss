package week5.tictactoe;

/**
 * Created by jotte on 16-1-17.
 */
public class SmartStrategy implements Strategy {
    @Override
    public String getName() {
        return "Smart";
    }

    @Override
    public int determineMove(Board b, Mark m) {
        if (b.isEmptyField(4)) {
            return 4;
        } else if (canWin(b, m)) {
            return winningMove(b, m);
        } else if (canWin(b, m.other())) {
            return winningMove(b, m.other());
        } else return new NaiveStrategy().determineMove(b, m);
    }

    private boolean canWin(Board b, Mark m) {
        int i = 0;
        while (b.isField(i)) {
            Board copyBoard = b.deepCopy();
            copyBoard.setField(i, m);
            if (copyBoard.hasWinner()) {
                return true;
            }
            i++;
        }
        return false;
    }

    private int winningMove(Board b, Mark m) {
        int i = 0;
        int win = 0;
        while (b.isField(i)) {
            Board copyBoard = b.deepCopy();
            copyBoard.setField(i, m);
            if (copyBoard.hasWinner()) {
                win = i;
                return win;
            }
            i++;
        }
        return win;
    }
}