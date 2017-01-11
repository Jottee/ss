package week5.tictactoe;

/**
 * Created by jotte on 10-1-17.
 */
public class ComputerPlayer extends Player {


    private Strategy strategy;
    private Mark mark;

    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + "-" + mark.name(), mark);
        this.strategy = strategy;

    }

    public ComputerPlayer(Mark mark) {
        super(new NaiveStrategy().getName() + "-" + mark.name(), mark);
        this.strategy = new NaiveStrategy();
    }

    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, mark);
    }

    @Override
    public String getName() {
        return "" + strategy.getName() + "-" + mark.name();
    }
}
